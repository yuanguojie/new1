<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    
    <form id="iform" action="${pageContext.request.contextPath}/addi" method="post">
    	<div>
    		<lable for="name">采购单编号：</lable>
    		<input class="easyui-validatebox" type="text" name="name" data-options="required:true"/>
    	</div>
    	<br/>
    	<div>
    		<label for="status">总数量:</label>
    		<input class="easyui-validatebox" type="text" name="status" data-options=""/>
    	</div>
    	<div>
    		<label for="status">总数量:</label>
    		<input class="easyui-validatebox" type="text" name="status" data-options=""/>
    	</div>
    	<div>
    		<label for="status">总数量:</label>
    		<input class="easyui-validatebox" type="text" name="status" data-options=""/>
    	</div>
    	<div id="msgrole" style="margin-top: -6px;color:red;"></div>
    </form>