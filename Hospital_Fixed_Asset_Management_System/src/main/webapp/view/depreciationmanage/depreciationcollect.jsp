<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    
    <script type="text/javascript">
    
    </script>
    
    
    
    
    
    
    
    
    
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="collectmassage">
    
    
    <div data-options="region:'center',border:false,fit:true">
		<table id="collectmassagetable" class="easyui-datagrid" style="height: 100%" 
		data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/collect',method:'get'">
			<thead>
				<tr>
				   <th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'asset',width:100">资产名称</th>
				   <th data-options="field:'price',width:100">原值</th>
				   <th data-options="field:'limitage',width:100">折旧年限</th>
				   <th data-options="field:'remain_ratio',width:100">残值率</th>
				   <th data-options="field:'deprecost',width:100">折旧金额</th>
				   <th data-options="field:'remain',width:100">残值</th>
				   <th data-options="field:'addepre',width:100">累计折旧</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>