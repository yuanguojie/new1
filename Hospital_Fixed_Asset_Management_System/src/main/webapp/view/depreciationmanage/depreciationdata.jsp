<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    <script type="text/javascript">
	// 查找角色信息
	function selectdepre(){
		var $val =$(":input[name=searchdeprename]").val();
		$("#depremassagetable").datagrid('load',{
				name: $val
		});
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#depremassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btndepreremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btndepreedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
    </script>
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="depremassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchdeprename"  style="width: 345px" data-options="searcher:selectdepre"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="adddepre" data-options="plain:true,iconCls:'icon-add'">新 增</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="depremassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/depreselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'methodId',width:100">折旧方法编号</th>
				   <th data-options="field:'assetId',width:100">固定资产编号</th>
				   <th data-options="field:'cost',width:100">折旧后金额</th>
				   <th data-options="field:'DTime',width:100">折旧时间</th>
				   <th data-options="field:'empId',width:100">折旧员工</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>