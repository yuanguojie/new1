<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


    <script type="text/javascript">
	// 查找角色信息
	function selecti(){
		var $val =$(":input[name=searchiname]").val();
		$("#imassagetable").datagrid('load',{
				id: $val
		});
	}
	// 点击添加角色，弹出添加角色对话框
	$('#instocklog').bind('click',function(){
		$("#ddi").dialog({
			title: "添加新角色",
			width: 400,
			height: 264,
			buttons:'#bi',
			closed: false,
			href: getPrefix()+'page/instockmanage_addinstocklog',
			modal: true
		})
	});
	// 点击保存添加资产登记表
	$('#savei').bind('click',function(){
		$('#ilogform').form('submit',{
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
		$("#imassagetable").datagrid('load',{
			
		});
	});
	
	//创建修改编辑对话框
	function geti(iid){
		$("#editi").dialog({
			title: "填写入库信息",
			width: 400,
			height: 200,
			buttons:'#Ui',
			closed: false,
			href: getPrefix()+'/s_dlist',
			modal: true,
			onLoad: function(){
				$("#iform2 :input[name='id']").val(iid);
			}
		});
	}
	// 提交创建好的入库信息
	$('#updi').bind('click',function(){
		$('#iform2').form('submit',{
			onSubmit: function(){
				var deptid = $("#iform2 #dept").val();
				var storageid = $("#iform2 #storage").val();
				$("#iform2 :input[name='deptId']").val(deptid);
		    	$("#iform2 :input[name='storageId']").val(storageid);
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
		$("#imassagetable").datagrid('load',{
			
		});
	});
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#imassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btniremove"]').linkbutton({
		    iconCls: 'icon-no'
		});
		$('[name="btniedit"]').linkbutton({
			iconCls: 'icon-ok'
		});

	}
	})

    </script>


    <div class="easyui-layout" data-options="fit:true,border:false" id="imassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">                 
			<input class="easyui-searchbox" name="searchiname"  style="width: 345px" data-options="searcher:selecti"  label='按名称搜索:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="instocklog" data-options="plain:true,iconCls:'icon-add'">资产登记</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="imassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/iselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'billNo',width:100">采购单编号</th>
				   <th data-options="field:'asset',width:100">资产名称</th>
				   <th data-options="field:'byDate',width:100">购买时间</th>
				   <th data-options="field:'totalCost',width:100">实际金额</th>
				   <th data-options="field:'sortCode',width:100">顺序号</th>
				   <th data-options="field:'amount',width:100">总数量</th>
				   <th data-options="field:'price',width:100">总金额</th>
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="ddi">	
	</div>
	<div id="bi" style="display:none">
		<a href="#" id="savei" class="easyui-linkbutton">Save</a>
		<a href="#" class="easyui-linkbutton">Close</a>
	</div>
	
	<div id="editi">
	</div>
	<!-- 添加资产控制栏 -->
	<div id="Ui" style="display:none">
		<a href="#" id="updi" class="easyui-linkbutton">Save</a>
		<a href="#" id="a" class="easyui-linkbutton">Close</a>
	</div>
	<div id="ddfdt">
		
	</div>
	<div id="bfdt" style="display:none">
		<a href="#" id="savefdt" class="easyui-linkbutton">Save</a>
		<a href="#" class="easyui-linkbutton">Close</a>
	</div>