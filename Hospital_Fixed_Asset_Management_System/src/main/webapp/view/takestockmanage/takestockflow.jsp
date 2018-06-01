<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    
    
    
   <script type="text/javascript">
	// 查找角色信息
	function selecttsf(){
		var $val =$(":input[name=searchtsfname]").val();
		$("#tsfmassagetable").datagrid('load',{
			billNo : $val
		});
	}
	// 点击添加盘点清单，弹出添加角色对话框
	$('#addtsf').bind('click',function(){
		$("#ddtsf").dialog({
			title: "增加清单项",
			width: 400,
			height: 300,
			buttons:'#btsf',
			closed: false,
			href: getPrefix()+'/takestockaddflow',
			modal: true
		})
	});
	// 保存增添的清单信息
	$('#savetsf').bind('click',function(){
		$('#tsfform').form('submit',{
			onSubmit: function(){
				if ($("#tsfform :input[name='billNo']").val()==""){
					$("#tsfform #msgtsf").html("请输入单据号");
					return false;
					} 
				var storage = $("#tsfform #storageId").val();
				var dept = $("#tsfform #deptId").val();
				$("#tsfform :input[name='storageId']").val(storage);
				$("#tsfform :input[name='deptId']").val(dept);
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
		$("#tsfmassagetable").datagrid('load',{
			
		});
	});
	// 提交修改后的角色信息
	$('#updtsf').bind('click',function(){
		$('#tsfform2').form('submit',{
			onSubmit: function(){
				if ($("#tsfform2 :input[name='name']").val()==""){
					$("#tsfform2 #msgtsf").html("请输入角色名");
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
		$("#tsfmassagetable").datagrid('load',{
			
		});
	})
		//创建修改编辑对话框
		function gettsf(tsfid){
		$("#edittsf").dialog({
			title: "设置折旧单",
			width: 400,
			height: 200,
			buttons:'#Utsf',
			closed: false,
			href: getPrefix()+'page/takestockmanage_Setdepreciation',
			modal: true,
			onLoad: function(){
				$("#tsfform2 :input[name='id']").val(tsfid);
			}
		});
		}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#tsfmassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btntsfremove"]').linkbutton({
		    iconCls: 'icon-no'
		});
		$('[name="btntsfedit"]').linkbutton({
			iconCls: 'icon-ok'
		});

	}
	})
    </script>
    
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="tsfmassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchtsfname"  style="width: 345px" data-options="searcher:selecttsf"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="addtsf" data-options="plain:true,iconCls:'icon-add'">资产清单</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="tsfmassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/tsfselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'billNo',width:100">单据号</th>
				   <th data-options="field:'assetId',width:100">资产名称</th>
				   <th data-options="field:'tsdate',width:100">盘点日期</th>
				   <th data-options="field:'flowFlag',width:100">流程标记</th>
				   <th data-options="field:'deptId',width:100">部门</th>
				   <th data-options="field:'createEmpId',width:100">建单人</th>
				   <th data-options="field:'storageId',width:100">仓库</th>
				   <th data-options="field:'sortCode',width:100">序号</th>
				   <th data-options="field:'depr_id',width:100">折旧编号</th>
				   <th data-options="field:'totalAmount',width:100">总数量</th>
				   <th data-options="field:'lostAmount',width:100">报废损失数量</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="edittsf">
	</div>
	<div id="Utsf" style="display:none">
		<a href="#" id="updtsf" class="easyui-linkbutton">确认</a>
		<a href="#" id="a" class="easyui-linkbutton">取消</a>
	</div>
	<div id="ddtsf">
	</div>

	<div id="btsf" style="display:none">
		<a href="#" id="savetsf" class="easyui-linkbutton">Save</a>
		<a href="#" class="easyui-linkbutton">Close</a>
	</div>
	</div>