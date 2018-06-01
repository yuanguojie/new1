/**
 * 左侧手风琴导航的相关事件
 */
$(function() {

	$('#tabs').tabs('add', {
		title : '首页',
		href : getPrefix()+"page/home_detail",
		tabWidth : "80px",
		selected : true
	});

	$.parser.onComplete = function() {
		$(".easyui-accordion .easyui-tree li span a[rel]").click(
				function(event) {
					var rel = $(this).attr("rel");
					var title = $(this).attr("title");
					var target =$(this).attr("target");
					var id =$(this).attr("id");
					if (rel == "tabs") {
						opentabs(title, target,id);
					}

				})
	};

});
	function opentabs(title, target,id) {
		var $tabs = $('#tabs');
		//控制只能打开一次
		if ($tabs.tabs("exists", title)) {
			$tabs.tabs("select", title);
			return;
		}
		var url=getPrefix()+target;
	    var datas={
	    		"url":url,
	    		"title":title
	    }

		$tabs.tabs('add', {
			title : title,
			href : url,
			closable : true,
			selected : true
		});
		$tabs.data(id,datas);
		
	}
function getPrefix(){

	var arr=location.href.split('/');
	if (arr.length>0){
		return "/"+arr[3]+"/";
	}else{
		return "/";
	}
}

/**
 * 打开对话框
 * @param $obj 对话框对象
 * @param title 标题
 * @param width 宽度
 * @param height 高度
 * @param href    远程url
 * @param callfn   保存的回调函数
 * @returns
 */
function opendlg($obj, title, width, height, href, callfn) {
	$obj.dialog({
		title : title,
		width : width,
		height : height,
		cache : false,
		href : getPrefix()+href,
		modal : true,
		buttons : [ {
			text : '保存',
			iconCls : 'icon-ok',
			handler : function() {
				callfn();
			}
		}, {
			text : '关闭',
			iconCls : 'icon-cancel',
			handler : function() {
				$obj.dialog('close');
			}
		} ]
	});
}
//关闭tabs 
function closeTabs(){
	var tab = $('#tabs').tabs('getSelected');
	var index = $('#tabs').tabs('getTabIndex',tab);
	$('#tabs').tabs("close",index);
}
//刷新tabs,id为菜单树的功能ID
function refreshTabs(id){
	var obj=$('#tabs').data(id);
	$('#tabs').tabs("select",obj.title);
	var tab = $('#tabs').tabs('getSelected');  
	// 获取选择的面板
	tab.panel('refresh',obj.url);
}
//关闭Tabs同时刷新
function closeRefresh(id){
	closeTabs();
	refreshTabs(id);
}
