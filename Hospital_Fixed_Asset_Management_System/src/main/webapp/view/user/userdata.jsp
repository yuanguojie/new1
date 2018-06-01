<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<script type="text/javascript">
	function select(){
		var $val =$(":input[name=searchname]").val();
		$("#usermassagetable").datagrid('load',{
				name: $val
		});
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#usermassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btnuserremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btnuseredit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
</script>
	<div class="easyui-layout" data-options="fit:true,border:false" id="usermassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchname"  style="width: 345px" data-options="searcher:select"  label='按名称搜索:' labelPosition='left' >
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="usermassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/userselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'name',width:400">用户姓名</th>
				   <th data-options="field:'loginAccount',width:100">用户账号</th>
				   <th data-options="field:'passWord',width:100">用户密码</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>