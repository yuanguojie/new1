<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    <script type="text/javascript">
	// 查找角色信息
	function selecttstock(){
		var $val =$(":input[name=searchtstockname]").val();
		$("#tstockmassagetable").datagrid('load',{
				name: $val
		});
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#tstockmassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btntstockremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btntstockedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
    </script>
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="tstockmassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchtstockname"  style="width: 345px" data-options="searcher:selecttstock"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="addtstock" data-options="plain:true,iconCls:'icon-add'">新 增</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="tstockmassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/tstockselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'billNo',width:100">单据号</th>
				   <th data-options="field:'TSDate',width:100">盘点日期</th>
				   <th data-options="field:'checkDateT',width:100">核准日期</th>
				   <th data-options="field:'flowFlag',width:100">流程标记</th>
				   <th data-options="field:'deptId',width:100">部门编号</th>
				   <th data-options="field:'createEmpId',width:100">建单人编号</th>
				   <th data-options="field:'takeEmpId',width:100">盘点人编号</th>
				   <th data-options="field:'storageId',width:100">仓库编号</th>
				   <th data-options="field:'checkEmpId',width:100">核准人编号</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>