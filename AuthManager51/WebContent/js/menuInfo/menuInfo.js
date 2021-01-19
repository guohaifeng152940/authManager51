var addUrl="../../menuInfo/addMenuInfo.action";
var updateUrl="../../menuInfo/updateMenuInfo.action";
var currentUrl="";


function formatterIcon(value,row,index){
	return "<div class='"+value+"'>&nbsp;</div>";
}

function openMenuInfoAddDialog(){
	var node=$("#treeGridMenuInfo").treegrid("getSelected");
	if(node==null){
		$.messager.alert("系统提示","请选择需要添加的父节点","warning");
		return false;
	}
	//alert(node.menu_id);
	currentUrl=addUrl;
	$("#parentId").val(node.menu_id);
	$("#dlgMenuInfo").dialog("open").dialog("setTitle","添加菜单信息");
}

function saveMenuInfo(){
	$("#fmMenuInfo").form("submit",{
		url:currentUrl,
		onSubmit:function(){
			var isValid = $(this).form('validate');
			return isValid;
		},
		success:function(result){
			var result=eval("("+result+")");
			if(result.msg){
				closeMenuInfoDialog();
				$("#treeGridMenuInfo").treegrid("reload");
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

function closeMenuInfoDialog(){
	$("#fmMenuInfo").form("clear");
	$("#dlgMenuInfo").dialog("close");
}