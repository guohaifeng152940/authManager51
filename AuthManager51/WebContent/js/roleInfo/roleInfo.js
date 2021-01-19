function searchRoleInfo(){
	var s_roleName=$("#s_roleName").val();
	$("#dgRoleInfo").datagrid("load",{
		s_roleName:s_roleName
	});
}

function roleInfoMenu(){
	var roleRows=$("#dgRoleInfo").datagrid("getSelections");
	if(roleRows.length!=1){
		$.messager.alert("系统提示","请选择一个角色进行授权！","warning");
		return false;
	}
	var roleId=roleRows[0].role_id;
	$.ajax({
		url:"../../menuInfo/findAllMeunInfoByRoleId.action",
		type:"post",
		data:{roleId:roleId},
		dataType:"json",
		success:function(result){
			$("#tree").tree({
				data:result,
				lines:true,
				checkbox:true,
				cascadeCheck:false,
				onLoadSuccess:function(node, param){
					$("#tree").tree("expandAll");
				},
				onCheck:function(node,checked){
					if(checked){
						var nodeParent=$("#tree").tree("getParent",node.target);
						$("#tree").tree("check",nodeParent.target);
					}else{
						var nodeChildrens=$("#tree").tree("getChildren",node.target);
						for(var i=0;i<nodeChildrens.length;i++){
							$("#tree").tree("uncheck",nodeChildrens[i].target);
						}
					}
				}
			});
		}
	});
	
	$("#dlgMenuInfo").dialog("open").dialog("setTitle","给角色授权");
}

function closeRoleAndMenu(){
	$("#dlgMenuInfo").dialog("close");
}

function saveRoleAndMenu(){
	var nodes=$("#tree").tree("getChecked");
	if(nodes.length==0){
		$.messager.alert("系统提示","请至少选择一个权限！","warning");
		return false;
	}
	
	var arrayNodes=new Array();
	$.each(nodes,function(index,node){
		arrayNodes.push(node.id);
	});
	var menuIds=arrayNodes.toString();
	
	var roleRows=$("#dgRoleInfo").datagrid("getSelections");
	var role_id=roleRows[0].role_id;
	
	$.ajax({
		url:"../../menuInfo/saveRoleAndMenu.action",
		type:"post",
		data:{role_id:role_id,menuIds:menuIds},
		dataType:"json",
		success:function(result){
			if(result.msg){
				closeRoleAndMenu();
				$("#dgRoleInfo").datagrid("reload");
				$.messager.alert("系统提示","授权成功！","info");
				
			}else{
				$.messager.alert("系统提示","授权成功！","info");
			}
		}
	});
}





