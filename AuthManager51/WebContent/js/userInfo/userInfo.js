var addUrl="../../userInfo/addUserInfo.action";
var updateUrl="../../userInfo/updateUserInfo.action";
var currentUrl="";

function searchUserInfo(){
	var s_userName=$("#s_userName").val();
	$("#dgUserInfo").datagrid("load",{
		s_userName:s_userName
	});
}

function openUserInfoAddDialog(){
	$("#user_name").removeAttr("disabled",true);
	$("#fmUserInfo").form("enableValidation");
	$("#dlgUserInfo").dialog("open").dialog("setTitle","新增用户信息");
	currentUrl=addUrl;
}

$("#user_name").blur(function(){
	var userName=$("#user_name").val();
	$.ajax({
		url:"../../userInfo/findUserNameIsExist.action",
		data:{userName:userName},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.msg){
				$.messager.alert("系统提示","该用户名<span style='color:red;font-size:24px'>"+userName+"</span>已存在，请重新输入姓名")
				$("#user_name").val("");
			}
		}
	});
});

function saveUserInfo(){
	$("#user_name").removeAttr("disabled",true);
	$("#fmUserInfo").form("enableValidation");
	$("#fmUserInfo").form("submit",{
		url:currentUrl,
		onSubmit:function(){
			var isValid = $(this).form('validate');
			return isValid;
		},
		success:function(result){
			var result=eval("("+result+")");
			if(result.msg){
				closeUserInfoDialog();
				$("#dgUserInfo").datagrid("reload");
				$.messager.alert("系统提示","保存成功！","info");
			}else{
				$.messager.alert("系统提示","保存失败！","error");
			}
		},
		error:function(){
			$.messager.alert("系统提示","系统繁忙，请稍后操作！","error");
		}
	});
	currentUrl="";
}

function closeUserInfoDialog(){
	$("#fmUserInfo").form("clear");
	$("#dlgUserInfo").dialog("close");
}

function openUserInfoModifyDialog(){
	var rows=$("#dgUserInfo").datagrid("getSelections");
	if(rows.length!=1){
		$.messager.alert("系统提示","请选择一行需要修改的数据","error");
		return false;
	}
	currentUrl=updateUrl;
	$("#fmUserInfo").form("disableValidation");
	$("#user_name").attr("disabled",true);
	$("#fmUserInfo").form("load",rows[0]);
	$("#dlgUserInfo").dialog("open").dialog("setTitle","修改用户信息");
}

function deleteUserInfo(){
	var rows=$("#dgUserInfo").datagrid("getSelections");
	if(rows.length<1){
		$.messager.alert("系统提示","请至少选择一行需要删除的数据","error");
		return false;
	}
	
	$.messager.confirm("系统提示","您确认要删除选中的<span style='color:red;font-size:18px'>"+rows.length+"条</span>数据吗？",function(r){
		if(r){
			var arrayIds=new Array();
			$.each(rows,function(index,row){
				arrayIds.push(row.user_id);
			});
			var userIds=arrayIds.toString();
			$.ajax({
				url:"../../userInfo/deleteUserInfo.action",
				type:"post",
				data:{userIds:userIds},
				dataType:"json",
				success:function(result){
					if(result.msg){
						$("#dgUserInfo").datagrid("reload");
						$.messager.alert("系统提示","您已成功删除<span style='color:red;font-size:18px'>"+result.count+"条</span>数据","info");
					}else{
						$.messager.alert("系统提示","保存失败！","error");
					}
				}
			});
		}
	});
}

function userInfoRole(){
	var rows=$("#dgUserInfo").datagrid("getSelections");
	if(rows.length!=1){
		$.messager.alert("系统提示","请选择一个需要授权的用户","error");
		return false;
	}
	
	$.ajax({
		url:"../../roleInfo/findAllRoleInfoForUser.action",
		type:"post",
		data:{user_id:rows[0].user_id},
		dataType:"json",
		success:function(result){
			$("#dgRoleInfo").datagrid({
				onLoadSuccess:function(data){
					$.each(data.rows,function(index,row){
						if(row.checked){
							$("#dgRoleInfo").datagrid("selectRow",index);
						}
					});
				},
				data:result.rows
			});
		}
	});
	
	/*$("#dgRoleInfo").datagrid({
	    url:"../../roleInfo/findAllRoleInfo.action",
	    data:
	});*/
	$("#dlgRoleInfo").dialog("open").dialog("setTitle","用户授权");
}

function searchRoleInfo(){
	var s_roleName=$("#s_roleName").val();
	$("#dgRoleInfo").datagrid("load",{
		s_roleName:s_roleName
	});
}

function saveUserAndRole(){
	var roleRows=$("#dgRoleInfo").datagrid("getChecked");
	/*if(roleRows.length<1){
		$.messager.alert("系统提示","请至少选择一个角色授权给用户","error");
		return false;
	}*/
	//alert(roleRows);
	var userRow=$("#dgUserInfo").datagrid("getSelected");
	var userId=userRow.user_id;
	if(roleRows==""){
		$.messager.confirm("系统提示","您确认要将用户"+userRow.user_name+"的角色回收吗？",function(r){
			if(r){
				$.ajax({
					url:"../../userInfo/deleteUserOwerRole.action",
					type:"post",
					data:{userId:userId},
					dataType:"json",
					success:function(result){
						if(result.msg){
							$("#dgUserInfo").datagrid("reload");
							closeUserAndRole();
							$.messager.alert("系统提示","授权成功","info");
						}else{
							$.messager.alert("系统提示","授权失败","error");
						}
					},
					error:function(){
						$.messager.alert("系统提示","系统繁忙，请稍后操作！","error");
					}
				});
			}
		});
	}else{
		
		var roleIdArrays=new Array();
		$.each(roleRows,function(index,row){
			roleIdArrays.push(row.role_id);
		});
		var roleIds=roleIdArrays.toString();
		
		$.ajax({
			url:"../../userInfo/insertUserAndRole.action",
			type:"post",
			data:{userId:userId,roleIds:roleIds},
			dataType:"json",
			success:function(result){
				if(result.msg){
					$("#dgUserInfo").datagrid("reload");
					closeUserAndRole();
					$.messager.alert("系统提示","授权成功","info");
				}else{
					$.messager.alert("系统提示","授权失败","error");
				}
			},
			error:function(){
				$.messager.alert("系统提示","系统繁忙，请稍后操作！","error");
			}
		});
	}
	
	
}

function closeUserAndRole(){
	$("#dgRoleInfo").datagrid("unselectAll");
	$("#dlgRoleInfo").dialog("close");
}

