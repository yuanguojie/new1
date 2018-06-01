<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    <script type="text/javascript">
	// 查找角色信息
	function selectrstock(){
		var $val =$(":input[name = 'searchrstockname']").val();
		$("#rstockmassagetable").datagrid('load',{
			assetId : $val
		});
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#rstockmassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btnrstockremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btnrstockedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
    </script>
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="rstockmassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchrstockname"  style="width: 345px" data-options="searcher:selectrstock"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="addrstock" data-options="plain:true,iconCls:'icon-add'">新 增</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="rstockmassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/rstockselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'amount',width:100">数量</th>
				   <th data-options="field:'price',width:100">金额</th>
				   <th data-options="field:'deptId',width:100">部门编号</th>
				   <th data-options="field:'storageId',width:100">仓库编号</th>
				   <th data-options="field:'assetId',width:100">资产编号</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>