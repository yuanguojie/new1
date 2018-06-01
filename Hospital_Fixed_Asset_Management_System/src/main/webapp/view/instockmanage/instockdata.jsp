<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    
    <script type="text/javascript">
	// 查找角色信息
	function selectinstock(){
		var $val =$(":input[name=searchinstockname]").val();
		$("#instockmassagetable").datagrid('load',{
				id : $val
		});
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#instockmassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btninstockremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btninstockedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
	function test(value,row,index){
				if (row.billNo){
					return row.billNo.id;
				} else {
					return value;
				}
	}
    </script>
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="instockmassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchinstockname"  style="width: 345px" data-options="searcher:selectinstock"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="addinstock" data-options="plain:true,iconCls:'icon-add'">新 增</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="instockmassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/instockselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'billNo',width:100,formatter:test" >采购单编号</th>
				   <th data-options="field:'buyDate',width:100">购买时间</th>
				   <th data-options="field:'totalCost',width:100">实际金额</th>
				   <th data-options="field:'flowFlag',width:100">流程标记</th>
				   <th data-options="field:'inDateT',width:100">入库时间</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>