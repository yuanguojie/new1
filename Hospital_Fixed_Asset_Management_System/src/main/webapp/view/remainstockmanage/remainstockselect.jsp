<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>





    <script type="text/javascript">
	// 查找库存信息
	function selectrstock(){
		var $val =$(":input[name = 'searchrstockname']").val();
		$("#rstockmassagetable").datagrid('load',{
			assetId : $val
		});
	}
    </script>
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="rstockmassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchrstockname" style="width: 345px" data-options="searcher:selectrstock"  label='资产编号:' labelPosition='left' >
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
				   <th data-options="field:'assetId',width:100">资产名称</th>
				   <th data-options="field:'amount',width:100">数量</th>
				   <th data-options="field:'price',width:100">金额</th>
				   <th data-options="field:'deptId',width:100">部门</th>
				   <th data-options="field:'storageId',width:100">仓库</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>