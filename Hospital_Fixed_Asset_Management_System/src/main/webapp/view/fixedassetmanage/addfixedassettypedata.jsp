<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    
     <form id="fdttypeform" action="${pageContext.request.contextPath}/addfdttype" method="post">
    	<div>
    		<lable for="name">类型名称:</lable>
    		<input class="easyui-validatebox" type="text" name="name" data-options="required:true"/>
    	</div>
    	<br/>
    	<div>
    		<label for="parentId">父级编号:</label>
    		<input class="easyui-validatebox" type="text" name="parentId" data-options=""/>
    	</div>
    	<div id="msgfdttype" style="margin-top: -6px;color:red;"></div>
    </form>