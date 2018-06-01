
<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.min.css">
		
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/easyui-1.5.2/themes/icon.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/easyui-1.5.2/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>

</head>
<script type="text/javascript">

</script>
<body class="easyui-layout">
	<div id="headnav" data-options="region:'north',border:false" style="height: 80px;"> 
	<div class="title">${projectName}</div>
		<div class="theme">
			<span class="Gray" title="Gray">■</span> <span class="Metro"
				title="Metro">■</span> <span class="Black" title="Black">■</span> <span
				class="Bootstrap" title="Bootstrap">■</span> <span class="Material"
				title="Material">■</span> <span class="Default" title="Default">■</span>
			<div>
			<!-- ${pageContext.request.contextPath}/ -->
				<a href='#'>| 修改密码 |</a> <a href="${pageContext.request.contextPath}/sysrolelist">&nbsp;&nbsp; 重新登录
					&nbsp;&nbsp;|</pre>
				</a>
			</div>
		</div>
		<div class="easyui-panel" style="height: 30px;">
			<a href="#" class="easyui-linkbutton" data-options="plain:true">菜单</a>
			<a href="#" class="easyui-menubutton" data-options="">编辑</a>
			<a href="#" class="easyui-menubutton" data-options="">帮助</a>
			<a href="#" class="easyui-menubutton" data-options="">关于</a>
		</div>
	</div>
	<div data-options="region:'south'" style="height: 10px;"></div>
<!--    -->
	<div data-options="region:'west',split:true,iconCls:'icon-man'"
		title="当前用户:${sessionScope.user.name}" style="width: 200px;">
		<div id="tree" class="easyui-accordion" data-options="fit:true,border:false">
		${ModuleString}
		</div>

	</div>
	<div data-options="region:'center'">
		<div id="tabs" data-options="border:false,fit:true" class="easyui-tabs">
       
		</div>
	</div>
	


</body>

</html>