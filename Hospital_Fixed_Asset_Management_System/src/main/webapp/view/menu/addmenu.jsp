<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <script type="text/javascript">
    	$("#menuform :input[name='sysRoleId']").val($("#Type").val())
    </script>
     <form id="menuform" action="${pageContext.request.contextPath}/addmenu" method="post">
     	<div style="margin:5px 0px 5px 0px">
			<select id="Type">
				<option value="1">系统管理员</option>
				<option value="2">固定资产管理员</option>
				<option value="3">员工</option>
				<option value="4">部长</option>
			</select>
			<input name="sysRoleId" type="hidden">
		</div>
    	<div style="margin:5px 0px 5px 0px">
    		<label for="name">菜单名称:</label>
    		<input class="easyui-validatebox" type="text" name="name" data-options="required:true"/>
    	</div>
    	<div style="margin:5px 0px 5px 0px">
    		<label for="url">菜单链接:</label>
    		<input class="easyui-validatebox" type="text" name="url" data-options=""/>
    	</div>
    	<div style="margin:5px 0px 5px 0px">
    		<label for="parentId">父级菜单:</label>
    		<input class="easyui-validatebox" type="text" name="parentId" data-options="required:true"/>
    	</div>
    	<div id="msg" style="margin-top: -6px;color:red;"></div>
    </form>