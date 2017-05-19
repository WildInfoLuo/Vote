//网页加载完成时
$(function(){
	$('#center_area').tabs('add',{  
    	title:'首页',  
   		href:"welcome.html"
	});  

	$('.easyui-tree').tree({
		onClick: function(node){
			var text=node.text; //获取选中的树枝文本值
			var tabs=$('#center_area');
			if(text=="用户管理"){
				if(tabs.tabs('exists','用户管理')){
					tabs.tabs('select',"用户管理");
				}else{
					tabs.tabs('add',{
						title:'用户管理',  
				   		href:"user.html",
				   		closable:true
					});
				}
			}else if(text=="投票管理"){
				if(tabs.tabs('exists','投票管理')){
					tabs.tabs('select',"投票管理");
				}else{
					tabs.tabs('add',{
						title:'投票管理',  
				   		href:"file.html",
				   		closable:true
					});
				}
			}else if(text=="数据统计"){
				if(tabs.tabs('exists','数据统计')){
					tabs.tabs('select',"数据统计");
				}else{
					tabs.tabs('add',{
						title:'数据统计',  
				   		href:"file.html",
				   		closable:true
					});
				}
			}
		}
    });

});
