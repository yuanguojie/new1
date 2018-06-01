<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    <script type="text/javascript">
	// 查找角色信息
	function selectada(){
		var $val =$(":input[name=searchadaname]").val();
		$("#adamassagetable").datagrid('load',{
				name: $val
		});
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#adamassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btnadaremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btnadaedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
    </script>
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="adamassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchadaname"  style="width: 345px" data-options="searcher:selectada"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="addada" data-options="plain:true,iconCls:'icon-add'">新 增</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="adamassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/adaselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'name',width:100">资产名称</th>
				   <th data-options="field:'OAddr',width:100">原部门地址</th>
				   <th data-options="field:'NAddr',width:100">现部门地址</th>
				   <th data-options="field:'outDeptid',width:100">转出部门</th>
				   <th data-options="field:'inDeptid',width:100">转入部门</th>
				   <th data-options="field:'outEmpid',width:100">转出人</th>
				   <th data-options="field:'inEmpid',width:100">接收人</th>
				   <th data-options="field:'allocateDate',width:100">调配日期</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>