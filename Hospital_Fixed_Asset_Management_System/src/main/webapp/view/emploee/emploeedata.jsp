<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <script type="text/javascript">
	// 查找角色信息
	function selectemp(){
		var $val =$(":input[name=searchempname]").val();
		$("#empmassagetable").datagrid('load',{
				name: $val
		});
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#empmassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btnempremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btnempedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
    </script>
    
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="empmassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchempname"  style="width: 345px" data-options="searcher:selectemp"  label='按名称搜索:' labelPosition='left' >
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="empmassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/empselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'name',width:100">员工姓名</th>
				   <th data-options="field:'idCard',width:200">身份证号</th>
				   <th data-options="field:'tel',width:200">电话号码</th>
				   <th data-options="field:'addr',width:200">住址</th>
				   <th data-options="field:'inWorkDate',width:100">入职时间</th>
				   <th data-options="field:'exitDate',width:100">离职时间</th>
				   <th data-options="field:'status',width:50">状态</th>
				   <th data-options="field:'deptId',width:100">所在部门</th>
				   <th data-options="field:'sysUserId',width:100">用户编号</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>