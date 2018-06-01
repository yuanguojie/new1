<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<script type="text/javascript">
	// 查找角色信息
	function select3(){
		var $val =$(":input[name=searchname3]").val();
		$("#rolemassagetable").datagrid('load',{
				name: $val
		});
	}
	// 点击添加角色，弹出添加角色对话框
	$('#addrole').bind('click',function(){
		$("#ddrole").dialog({
			title: "添加新角色",
			width: 400,
			height: 200,
			buttons:'#brole',
			closed: false,
			href: getPrefix()+'page/role_addrole',
			modal: true
		})
	});
	// 保存增添的角色信息
	$('#saverole').bind('click',function(){
		$('#roleform').form('submit',{
			onSubmit: function(){
				if ($("#roleform :input[name='name']").val()==""){
					$("#roleform #msgrole").html("请输入角色名");
					return false;
					} 
			},
			success: function(data){
				var data = eval('(' + data + ')');
				if(data.success){
					alert(data.message);
				}else{
					alert(data.message);
				}
			}
		});
		$("#rolemassagetable").datagrid('load',{
			
		});
	});
	// 提交修改后的角色信息
	$('#updrole').bind('click',function(){
		$('#roleform2').form('submit',{
			onSubmit: function(){
				if ($("#roleform2 :input[name='name']").val()==""){
					$("#roleform2 #msgrole").html("请输入角色名");
					return false;
					} 
			},
			success: function(data){
				var data = eval('(' + data + ')');
				if(data.success){
					alert(data.message);
				}else{
					alert(data.message);
				}
			}
		})
		$("#rolemassagetable").datagrid('load',{
			
		});
	})
		//创建修改编辑对话框
		function getrole(roleid){
			$.ajax({
                type : "post",
                url : getPrefix()+"/getrole",
                data : {
                    id : roleid
                },
                async:false,
                success : function(data) {
                	$("#editrole").dialog({
                			title: "修改角色信息",
                			width: 400,
                			height: 200,
                			buttons:'#Urole',
                			closed: false,
                			href: getPrefix()+'page/role_updaterole',
                			modal: true,
                			onLoad: function(){
                				$("#roleform2 :input[name='id']").val(data.id);
                				$("#roleform2 :input[name='name']").val(data.name);
                		    	$("#roleform2 :input[name='status']").val(data.status);
                			}
                		});
                   
                },
                error : function(data) {
                    alert("处理出现异常...");
                }
            });
		}
	// 删除角色
	function removerole(roleid){
		$.ajax({
            type : "post",
            url : getPrefix()+"/removerole",
            data : {
                id : roleid
            },
            async:false,
            success : function(data) {
               if(data.success){
            	   alert(data.message);
               }else{
            	   alert(data.message);
               }
            },
            error : function(data) {
                alert("处理出现异常...");
            }
        });
		$("#rolemassagetable").datagrid('load',{
			
	});
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#rolemassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btnroleremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btnroleedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
	
</script>
	<div class="easyui-layout" data-options="fit:true,border:false" id="rolemassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchname3"  style="width: 345px" data-options="searcher:select3"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="addrole" data-options="plain:true,iconCls:'icon-add'">新 增</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="rolemassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/roleselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'name',width:400">角色名称</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="ddrole">
		
	</div>
	<div id="editrole">
	</div>
	<div id="Urole" style="display:none">
		<a href="#" id="updrole" class="easyui-linkbutton">Save</a>
		<a href="#" id="a" class="easyui-linkbutton">Close</a>
	</div>
	<div id="brole" style="display:none">
		<a href="#" id="saverole" class="easyui-linkbutton">Save</a>
		<a href="#" class="easyui-linkbutton">Close</a>
	</div>
	</div>