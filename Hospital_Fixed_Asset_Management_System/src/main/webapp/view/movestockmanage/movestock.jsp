<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    
    
    
    
    
   <script type="text/javascript">
	// 查找角色信息
	function selectmove(){
		var $val =$(":input[name='searchmovename']").val();
		$("#movemassagetable").datagrid('load',{
				assetId : $val
		});
	}
	
	$('#movestocklog').bind('click',function(){
		$("#ddmove").dialog({
			title: "资产出库登记",
			width: 400,
			height: 400,
			buttons:'#bmove',
			closed: false,
			href: getPrefix()+'/movestocklog',
			modal: true
		})
	});
	// 点击保存添加资产出库登记表
	$('#savem').bind('click',function(){
		$('#mlogform').form('submit',{
			onSubmit: function(){
				var outdept = $("#mlogform #deptId").val();
				var outemp = $("#mlogform #outEmpId").val();
				var outstorage = $("#mlogform #outStorageId").val();
				var indept = $("#mlogform #inDeptId").val();
				var instorage = $("#mlogform #inStorageId").val();
				var inemp = $("#mlogform #inEmpId").val();
				$("#mlogform :input[name='deptId']").val(outdept);
				$("#mlogform :input[name='outEmpId']").val(outemp);
				$("#mlogform :input[name='outStorageId']").val(outstorage);
				$("#mlogform :input[name='inDeptId']").val(indept);
				$("#mlogform :input[name='inStorageId']").val(instorage);
				$("#mlogform :input[name='inEmpId']").val(inemp);
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
	});
	//创建修改编辑对话框
	function getm(mid){
		$.ajax({
            type : "post",
            url : getPrefix()+"/agreemovestock",
            data : {
                id : mid
            },
            async:false,
            success : function(data) {
				if(data.success){
				}else{
					alert(data.message);
				};
            	$("#movemassagetable").datagrid('load',{
    				
    			});
            },
            error : function(data) {
                alert("处理出现异常...");
            }
        });
	}
	// 为操作栏的编辑和删除按钮添加图标样式
	$("#movemassagetable").datagrid({
		onLoadSuccess:function(){
		$('[name="btnmremove"]').linkbutton({
		    iconCls: 'icon-no'
		});
		$('[name="btnmedit"]').linkbutton({
			iconCls: 'icon-ok'
		});
	}
	})
	
    </script>
    
    
    
    
    
    
    
    <div class="easyui-layout" data-options="fit:true,border:false" id="movemassage">
	<div data-options="region:'north',collapsible:false" style="height: 38px;">
		<div class="easyui-panel" data-options="border:false" id="studentEval"
			style="padding: 5px; background-color: #F2F2F2">          
			<input class="easyui-searchbox" name="searchmovename"  style="width: 400px" data-options="searcher:selectmove"  label='产品编号:' labelPosition='left' >
			<span class="btn-separator"></span>
			<a href="#" class="easyui-linkbutton" id="movestocklog" data-options="plain:true,iconCls:'icon-add'">资产出库登记</a> 
		</div>

	</div>

	<div data-options="region:'center',border:false,fit:true">
		<table id="movemassagetable" class="easyui-datagrid" style="height: 93%"
			data-options="striped:true,rownumbers:true,singleSelect:true,pagination:true,
			url:'${pageContext.request.contextPath}/moveselect',method:'get'">
			<thead>
				<tr>
				<th data-options="field:'ck',checkbox:true"></th>
				   <th data-options="field:'id',hidden:true"></th>
				   <th data-options="field:'assetId',width:100">资产名称</th>
				   <th data-options="field:'billNo',width:100">出库单据号</th>
				   <th data-options="field:'outDate',width:100">出库日期</th>
				   <th data-options="field:'totalCost',width:100">总金额</th>
				   <th data-options="field:'deptId',width:100,">转出部门</th>
				   <th data-options="field:'createEmpId',width:100">建单人</th>
				   <th data-options="field:'outEmpId',width:100">转出人</th>
				   <th data-options="field:'outStorageId',width:100">转出仓库</th>
				   <th data-options="field:'inDeptId',width:100">转入部门</th>
				   <th data-options="field:'inStorageId',width:100">转入仓库</th>
				   <th data-options="field:'inEmpId',width:100">接收人</th>
				   <th data-options="field:'outAmount',width:100">出库数量</th>
				   <th data-options="field:'price',width:100">金额</th>
				   
				   <th data-options="field:'operation',width:100">操作</th>
				</tr>
			</thead>
		</table>
	</div>
	<div id="ddmove">	
	</div>
	<div id="bmove" style="display:none">
		<a href="#" id="savem" class="easyui-linkbutton">Log</a>
		<a href="#" class="easyui-linkbutton">Close</a>
	</div>
	
	<div id="editmove">
	</div>
	<div id="Umove" style="display:none">
		<a href="#" id="updi" class="easyui-linkbutton">Save</a>
		<a href="#" id="a" class="easyui-linkbutton">Close</a>
	</div>
	</div>