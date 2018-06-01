<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    
    
     <form id="tsfform2" action="${pageContext.request.contextPath}/setdepreciation" method="post">
    	<div>
    		<input type="hidden" name="takeEmpId" value="${sessionScope.user.id}" />
    	</div>
    	<div>
    		<input type="hidden" name="id">
    	</div>
    	<div>
    		<scan>确认该条数据检查无误？</scan>
    	</div>
    	<div id="msgtsf" style="margin-top: -6px;color:red;"></div>
    </form>