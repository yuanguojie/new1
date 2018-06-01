<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>固定资产管理系统</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/easyui-1.5.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/easyui-1.5.2/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/login.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/easyui-1.5.2/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/easyui-1.5.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/easyui-1.5.2/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jQuery.md5.js"></script>
</head>



<script type="text/javascript">
function changeCheckCode(){
	  var src=$("#checkCode").attr("src");
	   $("#checkCode").attr("src",src);
}


   $(function () {
	
	var $footer=$(".loginfooter");
   $footer.css("line-height",$footer.height()+"px");

   $(".easyui-textbox").textbox('clear');
   
   
   $("#registerbtn").click(function(){

	   $("#register").form('submit',{
		   onSubmit:function(){
			   var result=false;
			  if ($("[name='Name']").val()==""){
				  $("#msg").html("请输入姓名");
				   return false;
			  }
			  if ($("[name='LoginAccount']").val()==""){
				  $("#msg").html("请输入用户账号");
				   return false;
			  }  
			  if ($("#password").val()==""){
				    $("#msg").html("请输入密码");
					 return false;
				  }
			  if($("checkpassword").val()==$("#password").val()){
				  $("#msg").html("两次密码输入不一样");
				  return false;
			  }
			    $("[name='PassWord']").val($.md5( $("#password").val()));
		   },
		   success:function(data){
			   var data = eval('(' + data + ')');
		        if (data.success){
		        	location.href="${pageContext.request.contextPath}"+data.url;   
		        }  else{
		        	 $("#msg").html(data.message);
		        	 $("#register").form("clear");
		        	/* $.messager.show({
		        		title:"信息提示",
		        		msg:"<div style='color:red;font-size: 15px'>"+data.message+"</div>",
		        		timeout:2000,
		        		showType:'slide'

		        	}); */
		        }  
		   }
	   })
	   
   })
	
})

</script>
<body>
	<div class="loginTop"></div>
	<div class="registerCentr">
		<form id="register" action="${pageContext.request.contextPath}/register" method="post">

			<div class='divCenter'>
				<div>
					<input name="Roleid" type="hidden" value="3">
				</div>
				<div>
					<input name="Name" class="easyui-textbox"
						data-options="prompt:'真实姓名',iconCls:'icon-man',iconWidth:38">
				</div>
				<div>
					<input name="LoginAccount" class="easyui-textbox"
						data-options="prompt:'账号',iconCls:'icon-man',iconWidth:38">
				</div>
				<div>
					<input id="password" class="easyui-textbox" type="password"
						data-options="prompt:'5-7位密码',iconCls:'icon-lock',iconWidth:38">
					<input name="PassWord" type="hidden" type="text">
				</div>
				<div>
					<input id="checkpassword" class="easyui-textbox" type="password"
						data-options="prompt:'再次输入密码',iconCls:'icon-lock',iconWidth:38">
				</div>
				<div>
					<button id="registerbtn" type="button">注 册</button>
				
				</div>
				<div id="msg" style="margin-top: -6px;color:red;"></div>

			</div>
		</form>
	</div>
	<div class="loginfooter">
		Copyright © 2017-2019 <a href='#'>重庆工程学院</a>
	</div>
</body>
</html>