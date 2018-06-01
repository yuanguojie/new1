<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    <form id="roleform" action="${pageContext.request.contextPath}/addrole" method="post">
    	<div>
    		<lable for="name">角色名称:</lable>
    		<input class="easyui-validatebox" type="text" name="name" data-options="required:true"/>
    	</div>
    	<br/>
    	<div>
    		<label for="status">角色状态:</label>
    		<input class="easyui-validatebox" type="text" name="status" data-options=""/>
    	</div>
    	<div id="msgrole" style="margin-top: -6px;color:red;"></div>
    </form>