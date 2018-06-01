<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    
<script type="text/javascript">

//点击添加资产类型，弹出添加资产对话框
$('#addfdt').bind('click',function(){
	$("#ddfdt").dialog({
		title: "添加新资产",
		width: 400,
		height: 320,
		buttons:'#bfdt',
		closed: false,
		href: getPrefix()+'/addfixedasset',
		modal: true,
	})
});
// 保存增添的资产类型信息
$('#savefdt').click(function(){
	$('#fdtform').form('submit',{
		onSubmit: function(){
			var assetType = $("#fdtform #assetType").val();
			var unit = $("#fdtform #unit").val();
			$("#fdtform :input[name='productTypeId']").val(assetType);
			$("#fdtform :input[name='unitId']").val(unit);
		},
		success: function(data){
			var data = eval('(' + data + ')');
			if(data.success){
				$("#ilogform :input[name='assetId']").val(data.value);
				alert(data.message);
			}else{
				alert(data.message);
			}
		}
	});
});

</script>
    
    
    
     <form id="ilogform" action="${pageContext.request.contextPath}/addilog" method="post">
    	<div>
    		<lable for="assetId">资产编号:</lable>
    		<input class="easyui-validatebox" type="text" name="assetId" data-options="required:true"/>
    		<a href="#" class="easyui-linkbutton" id="addfdt" data-options="plain:true,iconCls:'icon-add'">添加资产</a>
    	</div>
    	<br/>
    	<div>
    		<label for="buyDate">购买日期:</label>
    		<input class="easyui-validatebox" type="text" name="buyDate" data-options=""/>
    	</div>
		<br/>
    	<div>
    		<lable for="price">金&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 额:</lable>
    		<input class="easyui-validatebox" type="text" name="price" />
    	</div>
    	<br/>
    	<div>
    		<lable for="amount">数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 量:</lable>
    		<input class="easyui-validatebox" type="text" name="amount" />
    	</div>
    	<br/>
    	<div>
    		<lable for="totalCost">总金额&nbsp;&nbsp;&nbsp; :</lable>
    		<input class="easyui-validatebox" type="text" name="totalCost" />
    	</div>
    	<div id="msgi" style="margin-top: -6px;color:red;"></div>
    </form>