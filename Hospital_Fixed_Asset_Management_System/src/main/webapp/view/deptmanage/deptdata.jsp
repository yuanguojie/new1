<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    <script type="text/javascript">
	// 查找角色信息
	function selectdept(){
		var $val =$(":input[name=searchdeptname]").val();
		$("#deptmassagetable").datagrid('load',{
				name: $val
		});
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#deptmassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btndeptremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btndeptedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
    </script>
    
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="deptmassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchdeptname"  style="width: 345px" data-options="searcher:selectdept"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="adddept" data-options="plain:true,iconCls:'icon-add'">新 增</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="deptmassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/deptselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'name',width:100">科室名称</th>
				   <th data-options="field:'sortCode',width:100"></th>
				   <th data-options="field:'DM_id',width:100">科室管理员id</th>
				   <th data-options="field:'deptType',width:100">科室类别</th>
				   <th data-options="field:'parentId',width:100">父级</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>