<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    <script type="text/javascript">
	// 查找角色信息
	function selectmovestock(){
		var $val =$(":input[name=searchmovestockname]").val();
		$("#movestockmassagetable").datagrid('load',{
				name: $val
		});
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#movestockmassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btnmovestockremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btnmovestockedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
    </script>
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="movestockmassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchmovestockname"  style="width: 345px" data-options="searcher:selectmovestock"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="addmovestock" data-options="plain:true,iconCls:'icon-add'">新 增</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="movestockmassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/movestockselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'billNo',width:100">出库单据号</th>
				   <th data-options="field:'outDate',width:100">出库日期</th>
				   <th data-options="field:'flowFlag',width:100">流程标记</th>
				   <th data-options="field:'totalCost',width:100">总金额</th>
				   <th data-options="field:'inDate',width:100">转入日期</th>
				   <th data-options="field:'deptId',width:100">转出部门编号</th>
				   <th data-options="field:'createEmpId',width:100">建单人</th>
				   <th data-options="field:'outEmpId',width:100">转出人</th>
				   <th data-options="field:'outStorageId',width:100">转出仓库编号</th>
				   <th data-options="field:'inDeptId',width:100">转入部门编号</th>
				   <th data-options="field:'inStorageId',width:100">转入仓库编号</th>
				   <th data-options="field:'inEmpId',width:100">接收人</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>