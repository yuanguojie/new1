$(function() {
	var $dlg = null;
	$("#sysuserel #add").click(function(e) {
		e.preventDefault();
	
		$dlg = getDialog();
		opendlg($dlg, '新增用户', "380", "350", 'user/add', function() {
			callbackFunc($dlg);
		});

	})
	$("#sysuserel #refresh").click(function(e) {
		$('#sysuserdg').datagrid('reload');

		
	})
	$("#sysuserel  #search").click(function(){
	
		var code=$("#sysuserel [name='userCode']").val();
		var name=$("#sysuserel [name='userName']").val();

		$('#sysuserdg').datagrid({
			queryParams: {
				userCode: code,
				userName: name
			}
		});


	})
	$("#sysuserel #del").click(function(e) {
		var row = $("#sysuserdg").datagrid('getSelected');
		
		if (row.length==0){
			return ;
		}
		var userIds=row.userId;
		delrow(userIds);
	})
	$("#sysuserdg")
			.datagrid(
					{
						onClickCell : function(rowIndex, field, value) {
							if (field != 'userName' && field != 'opt') {
								return;
							}

							var data = $('#sysuserdg').datagrid('getData').rows[rowIndex];
							var userId = data.userId;
							if (field == "userName") {
								$dlg = getDialog();
								opendlg($dlg, '用户编辑', "380", "350",
										'user/edit/' + userId, function() {
									         callbackFunc($dlg);
										});
							} else {
								delrow(userId);
							}
						}

					})

})
function callbackFunc($obj){
	$("#userform").form('submit',{
		success:function(data){
			var data = eval('(' + data + ')');  
			if (data.success){   
				$obj.dialog('close');
				$('#sysuserdg').datagrid('reload');   
	        } else{
	        	$.messager.show({
	        		title:"错误",
	        		msg:"<div style='color:red;font-size: 15px'>抱歉，出错了</div>",
	        		timeout:1000,
	        		showType:'slide'

	        	});
	        }
		}
	});
}

function delrow(userId) {
	$.messager.confirm('确认', '您确认想要删除记录吗？', function(r) {
		if (r) {
			$.ajax({url:getProjectName()+"user/del/" + userId, 
				success:function(data) {
			/*    data=$.parseJSON(data);*/
				if (data.success==true) {
					$('#sysuserdg').datagrid('reload');
				} else {
					$.messager.show({
		        		title:"错误",
		        		msg:"<div style='color:red;font-size: 15px'>抱歉，出错了</div>",
		        		timeout:1000,
		        		showType:'slide'

		        	});
					
				}
			}});

		}
	});
}
function getDialog() {
	var $dlg = $("#sysuserel #dlg");
	if ($dlg.length == 0) {
		$("#sysuserel").append("<div id='dlg'></div>");
		$dlg = $("#sysuserel #dlg");

	}
	return $dlg;
}
function creatopt(value, row, index) {
	var linkString = "<div style='color:blue;cursor: pointer'>删除 </div>";
	return linkString;
}
function creatusername(value, row, index) {
	var linkString = "<div style='color:blue;cursor: pointer'>" + value
			+ "</div>";
	return linkString;
}
function creatstatus(value, row, index) {
	var rtnstr = "启用";
	if (value == "1") {
		rtnstr = "<div style='color:red'>禁用<div>";
	}
	return rtnstr;
}
