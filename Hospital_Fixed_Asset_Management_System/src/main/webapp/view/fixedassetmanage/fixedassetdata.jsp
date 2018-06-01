<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    <script type="text/javascript">
	// 查找资产信息
	function selectfdt(){
		var $val =$(":input[name=searchfdtname]").val();
		$("#fdtmassagetable").datagrid('load',{
				name: $val
		});
	}
	// 点击添加资产类型，弹出添加资产对话框
	$('#addfdt').bind('click',function(){
		$("#ddfdt").dialog({
			title: "添加新角色",
			width: 400,
			height: 320,
			buttons:'#bfdt',
			closed: false,
			href: getPrefix()+'page/fixedassetmanage_addfixedasset',
			modal: true
		})
	});
	// 保存增添的资产类型信息
	$('#savefdt').bind('click',function(){
		$('#fdtform').form('submit',{
			onSubmit: function(){
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
		$("#fdtmassagetable").datagrid('load',{
			
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
	$('#updfdt').bind('click',function(){
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
	$("#fdtmassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btnfdtremove"]').linkbutton({
		    iconCls: 'icon-remove'
		});
		$('[name="btnfdtedit"]').linkbutton({
			iconCls: 'icon-edit'
		});

	}
	})
    </script>
    
    
    
    
    
    
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="fdtmassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchfdtname"  style="width: 345px" data-options="searcher:selectfdt"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="addfdt" data-options="plain:true,iconCls:'icon-add'">新 增</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="fdtmassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/fdtselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'name',width:100">资产名称</th>
				   <th data-options="field:'code',width:100">助记码</th>
				   <th data-options="field:'standard',width:100">规格型号</th>
				   <th data-options="field:'productTypeId',width:100">资产类型</th>
				   <th data-options="field:'unitId',width:100">计量单位</th>
				   <th data-options="field:'price',width:100">价值</th>
				   <th data-options="field:'expeted_life',width:100">预计</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="editfdt">
	</div>
	<div id="Ufdt" style="display:none">
		<a href="#" id="updfdt" class="easyui-linkbutton">Save</a>
		<a href="#" id="a" class="easyui-linkbutton">Close</a>
	</div>
	<div id="ddfdt">
		
	</div>
	<div id="bfdt" style="display:none">
		<a href="#" id="savefdt" class="easyui-linkbutton">Save</a>
		<a href="#" class="easyui-linkbutton">Close</a>
	</div>
	</div>