$(function(){
	$.ajax({
		url:"../menuInfo/findMenuInfoByParentId.action",
		type:"post",
		dataType:"json",
		success:function(result){
			$("#tree").tree({
				data:result,
				lines:true,
				onLoadSuccess:function(node, param){
					$("#tree").tree("expandAll");
				},
				onClick:function(node){
					if(node.attributes.url!=null){
						if($("#tabs").tabs("exists",node.text)){
							$("#tabs").tabs("select",node.text);
						}else{
							var content="<iframe frameborder='0' scrolling='auto' style='width:100%;height:100%;' src='../html/"+node.attributes.url+"'></iframe>";
							$("#tabs").tabs("add",{
								title:node.text,
								content:content,
								closable:true,
								iconCls:node.iconCls
							});
						}
					}
				}
			});
		}
	});
});