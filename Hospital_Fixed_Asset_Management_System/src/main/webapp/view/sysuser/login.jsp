<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html  PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>医院固定资产管理系统</title>
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
// 去除掉登录信息
function getPrefix(){

	var arr=location.href.split('/');
	if (arr.length>0){
		return "/"+arr[3]+"/";
	}else{
		return "/";
	}
}
function out(){
	$.ajax({
	    type : "post",
	    url : getPrefix()+"/logout",
	    data : {
	        
	    },
	    async:false,
	    success : function(data) {
			
	    	
	    },
	    error : function(data) {
	        alert("处理出现异常...");
	    }
	});
}
out();



   $(function () {
	
	var $footer=$(".loginfooter");
   $footer.css("line-height",$footer.height()+"px");

   $(".easyui-textbox").textbox('clear');
   
   
   $("#loginbtn").click(function(){

	   $("#login").form('submit',{
		   onSubmit:function(){
			   var result=false;
			  if ($("[name='userCode']").val()==""){
				  $("#msg").html("请输入用户编码");
				   return false;
			  }
			  if ($("#password").val()==""){
				    $("#msg").html("请输入密码");
					 return false;
				  }
			    $("[name='PassWord']").val($.md5( $("#password").val()));
			    $("[name='sysRoleId']").val($("#Type").val())

		   },
		   success:function(data){
			   var data = eval('(' + data + ')');
		        if (data.success){
		        	location.href="${pageContext.request.contextPath}"+data.url;   
		        }  else{
		        	 $("#msg").html(data.message);
		        	 $("#login").form("clear");
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
	<div class="loginCentr">
		<form id="login" action="${pageContext.request.contextPath}/login" method="post">

			<div class='divCenter'>
				<div>
					<select id="Type">
						${rolelist}
					</select>
					<input name="sysRoleId" type="hidden">
				</div>
				<div>
					<input name="LoginAccount" class="easyui-textbox"
						data-options="prompt:'用户编码',iconCls:'icon-man',iconWidth:38">
				</div>
				<div>
					<input id="password" class="easyui-textbox" type="password"
						data-options="prompt:'5-7位密码',iconCls:'icon-lock',iconWidth:38">
					<input name="PassWord" type="hidden" type="text">
				</div>
				<div>
					<button id="loginbtn" type="button">登 录</button>
				
				</div>
				<div id="msg" style="margin-top: -6px;color:red;"></div>

			</div>
		</form>
	</div>
	<div class="loginfooter">
		Copyright © 2017-2019 <a href='#'>医院固定资产管理系统</a>
	</div>
</body>
</html>