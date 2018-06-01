<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    
    
    <form id="fdttypeform2" action="${pageContext.request.contextPath}/updatefdttype" method="post">
    	<div>
    		<input type="hidden" name="id"  />
    	</div>
    	<div>
    		<lable for="name">类型名称:</lable>
    		<input type="text" name="name" />
    	</div>
    	<br/>
    	<div>
    		<label for="parentId">父级编号:</label>
    		<input type="text" name="parentId"/>
    	</div>
    	<div id="msgfdttype" style="margin-top: -6px;color:red;"></div>
    </form>