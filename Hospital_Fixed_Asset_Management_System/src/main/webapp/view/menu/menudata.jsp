<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


<script type="text/javascript">
	function select2(){
		var $val =$(":input[name=searchname2]").val();
		$("#menumassagetable").datagrid('load',{
				name: $val
		});
	}
	$('#addmenu').bind('click',function(){
		$("#ddmenu").dialog({
			title: "添加菜单",
			width: 400,
			height: 200,
			buttons:'#bmenu',
			closed: false,
			href: getPrefix()+'page/menu_addmenu',
			modal: true
		})
	});
	$('#savemenu').bind('click',function(){
		$('#menuform').form('submit',{
			onSubmit: function(){
				if ($("#menuform :input[name='name']").val()==""){
					$("#menuform #msg").html("请输入菜单名");
					return false;
					}  
				if ($("#menuform :input[name='parentId']").val()==""){
					$("#menuform #msg").html("请输入父级菜单名");
					return false;
					}
			},
			success: function(data){
				var data = eval('(' + data + ')');
				if(data.success){
					alert(data.message);
				}else{
					alert(data.message);
				}
			}
		})
	})
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#menumassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btnmenuremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btnmenuedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
</script>
	<div class="easyui-layout" data-options="fit:true,border:false" id="menumassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">               
			<input class="easyui-searchbox" name="searchname2"  style="width: 345px" data-options="searcher:select2"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="addmenu" data-options="plain:true,iconCls:'icon-add'">新 增</a>
		</div>
	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="menumassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/menuselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',width:80">菜单编号</th>
				   <th data-options="field:'name',width:400">菜单名称</th>
				   <th data-options="field:'url',width:100">菜单链接</th>
				   <th data-options="field:'parentId',width:100">父级菜单编号</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="ddmenu">
		
	</div>
	<div id="editmenu">
	</div>
	<div id="Umenu" style="display:none">
		<a href="#" id="updmenu" class="easyui-linkbutton">Save</a>
		<a href="#" class="easyui-linkbutton">Close</a>
	</div>
	<div id="bmenu">
		<a href="#" id="savemenu" class="easyui-linkbutton">Save</a>
		<a href="#" class="easyui-linkbutton">Close</a>
	</div>
</div>