<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    <form id="roleform2" action="${pageContext.request.contextPath}/updaterole" method="post">
    	<div>
    		<input type="hidden" name="id"  />
    	</div>
    	<div>
    		<lable for="name">角色名称:</lable>
    		<input type="text" name="name"  />
    	</div>
    	<br/>
    	<div>
    		<label for="status">角色状态:</label>
    		<input type="text" name="status" />
    	</div>
    	<div id="msgrole" style="margin-top: -6px;color:red;"></div>
    </form>