<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>



   <style>

        #iform2 label {
    	width:80px;
    	display: inline-block;
    	}

	</style>
    
    <form id="iform2" action="${pageContext.request.contextPath}/ininfo" method="post">
    	<div>
    	<label>入库部门名：</label>
    		<select id="dept">
				${deptlist}
			</select>
    		<input type="hidden" name="deptId"/>
    	</div>
    	<br/>
    	<div>
    		<label>仓库：</label>
    		<select id="storage">
				${storagelist}
			</select>
    		<input type="hidden" name="storageId"  />
    	</div>
    	<br/>
    	<div>
    		<input type="hidden" name="id" />
    	</div>
    	<div id="msgi" style="margin-top: -6px;color:red;"></div>
    </form>