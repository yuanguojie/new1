<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    <script type="text/javascript">
	// 查找角色信息
	function selecttstockdtl(){
		var $val =$(":input[name=searchtstockdtlname]").val();
		$("#tstockdtlmassagetable").datagrid('load',{
				name: $val
		});
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#tstockdtlmassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btntstockdtlremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btntstockdtledit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
    </script>
    
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="tstockdtlmassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchtstockdtlname"  style="width: 345px" data-options="searcher:selecttstockdtl"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="addtstockdtl" data-options="plain:true,iconCls:'icon-add'">新 增</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="tstockdtlmassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/tstockdtlselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'sortCode',width:100">序号</th>
				   <th data-options="field:'depr_id',width:100">折旧编号</th>
				   <th data-options="field:'totalAmount',width:100">总数量</th>
				   <th data-options="field:'lostAmount',width:100">报废损失数量</th>
				   <th data-options="field:'takeStockId',width:100">库存盘点主键</th>
				   <th data-options="field:'assetId',width:100">资产编号</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>