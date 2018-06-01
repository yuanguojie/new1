<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    <script type="text/javascript">
	
	// 点击开始折旧
	$('#adddepref').bind('click',function(){
		//创建修改编辑对话框
		var $dm = $("#deprefmethod").val();
		var userid = $("#userid").val();
			$.ajax({
                type : "post",
                url : getPrefix()+"/startdepref",
                data : {
                    methodId : $dm,
                    empId : userid
                },
                async:false,
                success : function(data) {
                	$("#deprefmassagetable").datagrid('load',{
        				
        			});
                },
                error : function(data) {
                    alert("处理出现异常...");
                }
            });
		})
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#deprefmassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btndeprefremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btndeprefedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	});
	// 折旧汇总按钮生成tabs的功能
	$("#collect").click(
				function(event) {
					var rel = $(this).attr("rel");
					var title = $(this).attr("title");
					var target =$(this).attr("target");
					var id =$(this).attr("id");
					if (rel == "tabs") {
						opentabs(title, target,id);
					}

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
    </script>
    
    	
        <div class="easyui-layout" data-options="fit:true,border:false" id="deprefmassage">
        <input id="userid" type="hidden" value="${sessionScope.user.id}">
		<div data-options="region:'north',collapsible:false" style="height: 38px;">
			<div class="easyui-panel" data-options="border:false" id="studentEval"
				style="padding: 5px; background-color: #F2F2F2">
				<span>折旧方法</span>               
				<select id="deprefmethod">
				<option value="1">平均年限法</option>
				</select>
				<span class="btn-separator"></span>
				<span>资产类型</span>
				<select id="assetType">
				<option value="0">所有类型</option>
				</select>
				<span class="btn-separator"></span>
				<a href="#" class="easyui-linkbutton" id="adddepref" data-options="plain:true,iconCls:'icon-add'">开始折旧</a>
				<span class="btn-separator"></span>
				<a rel="tabs" title="折旧汇总" target="/page/depreciationmanage_depreciationcollect" class="easyui-linkbutton" id="collect" data-options="plain:true,iconCls:'icon-form'">折旧汇总</a>
			</div>
		</div>
    	<div data-options="region:'center',border:false,fit:true">
		<table id="deprefmassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/deprefselect',method:'get'">
			<thead>
				<tr>
				   <th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'assetId',width:100">资产编号</th>
				   <th data-options="field:'price',width:100">价值</th>
				   <th data-options="field:'unitId',width:100">计量单位</th>
				   <th data-options="field:'cost',width:100">折旧后金额</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>