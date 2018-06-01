<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <style>
    #fdtform label {
    	width:80px;
    	display: inline-block;
    }
    
	</style>
    
    
     <form id="fdtform" action="${pageContext.request.contextPath}/addfdt" method="post">
    	<div>
    		<label for="name">资产名称:</label>
    		<input class="easyui-validatebox" type="text" name="name" data-options="required:true"/>
    	</div>
    	<br/>
    	<div>
    		<label for="code">供应商:</label>
    		<input class="easyui-validatebox" type="text" name="code" data-options=""/>
    	</div>
    	<br/>
    	<div>
    		<label for="standard">规格型号:</label>
    		<input class="easyui-validatebox" type="text" name="standard" data-options=""/>
    	</div>
    	<br/>
    	<div>
    		<label for="productTypeId">资产类型:</label>
    		    <select id="assetType">
					${assettype}
				</select>
    		<input  type="hidden" name="productTypeId" data-options=""/>
    	</div>
    	<br/>
    	<div>
    		<label for="unitId">资产计量单位:</label>
    			<select id="unit">
					${unit}
				</select>
    		<input  type="hidden" name="unitId" data-options=""/>
    	</div>
    	<br/>
    	<div>
    		<label for="price">资产原价:</label>
    		<input class="easyui-validatebox" type="text" name="price" data-options=""/>
    	</div>
    	<br/>
    	<div>
    		<label for="expected_life">预计使用年限:</label>
    		<input class="easyui-validatebox" type="text" name="expected_life" data-options=""/>
    	</div>
    	<div id="msgfdt" style="margin-top: -6px;color:red;"></div>
    </form>