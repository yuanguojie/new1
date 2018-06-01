<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <script type="text/javascript">
	// 查找资产类型信息
	function selectfdttype(){
		var $val =$(":input[name=searchfdttypename]").val();
		$("#fdttypemassagetable").datagrid('load',{
				name: $val
		});
	}
	// 点击添加资产类型，弹出添加角色对话框
	$('#addfdttype').bind('click',function(){
		$("#ddfdttype").dialog({
			title: "添加新角色",
			width: 400,
			height: 200,
			buttons:'#bfdttype',
			closed: false,
			href: getPrefix()+'page/fixedassetmanage_addfixedassettypedata',
			modal: true
		})
	});
	// 保存增添的资产类型信息
	$('#savefdttype').bind('click',function(){
		$('#fdttypeform').form('submit',{
			onSubmit: function(){
				if ($("#fdttypeform :input[name='name']").val()==""){
					$("#fdttypeform #msgrole").html("请输入角色名");
					return false;
					}
				if($("#fdttypeform :input[name='parentId']").val()==""){
					$("#fdttypeform #msgrole").html("请输入父级编号");
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
		$("#fdttypemassagetable").datagrid('load',{
			
		});
	});
	//创建修改编辑对话框
	function getfdttype(fdttypeid){
		$.ajax({
            type : "post",
            url : getPrefix()+"/getfdttype",
            data : {
                id : fdttypeid
            },
            async:false,
            success : function(data) {
            	$("#editfdttype").dialog({
            			title: "修改角色信息",
            			width: 400,
            			height: 200,
            			buttons:'#Ufdttype',
            			closed: false,
            			href: getPrefix()+'page/fixedassetmanage_updatefixedassettype',
            			modal: true,
            			onLoad: function(){
            				$("#fdttypeform2 :input[name='id']").val(data.id);
            				$("#fdttypeform2 :input[name='name']").val(data.name);
            		    	$("#fdttypeform2 :input[name='parentId']").val(data.parentId);
            			}
            		});
            },
            error : function(data) {
                alert("处理出现异常...");
            }
        });
	}
	// 提交修改后的资产类型
	$('#updfdttype').bind('click',function(){
		$('#fdttypeform2').form('submit',{
			onSubmit: function(){
				if ($("#fdttypeform2 :input[name='name']").val()==""){
					$("#fdttypeform2 #msgrole").html("请输入角色名");
					return false;
					} 
				if($("#fdttypeform2 :input[name='parentId']").val()==""){
					$("#fdttypeform2 #msgrole").html("请输入父级编号");
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
		$("#fdttypemassagetable").datagrid('load',{
			
		});
	})
		// 删除资产类型
	function removefdttype(fdttypeid){
		$.ajax({
            type : "post",
            url : getPrefix()+"/removefdttype",
            data : {
                id : fdttypeid
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
		$("#fdttypemassagetable").datagrid('load',{
			
	});
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#fdttypemassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btnfdttyperemove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btnfdttypeedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
    
    
    </script>
    
    
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="fdttypemassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchfdttypename"  style="width: 345px" data-options="searcher:selectfdttype"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="addfdttype" data-options="plain:true,iconCls:'icon-add'">新 增</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="fdttypemassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/fdttypeselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'name',width:100">角色名称</th>
				   <th data-options="field:'sortCode',width:100"></th>
				   <th data-options="field:'parentId',width:100">父级产品分类</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="editfdttype">
	</div>
	<div id="Ufdttype" style="display:none">
		<a href="#" id="updfdttype" class="easyui-linkbutton">Save</a>
		<a href="#" id="a" class="easyui-linkbutton">Close</a>
	</div>
	<div id="ddfdttype">
		
	</div>
	<div id="bfdttype" style="display:none">
		<a href="#" id="savefdttype" class="easyui-linkbutton">Save</a>
		<a href="#" class="easyui-linkbutton">Close</a>
	</div>