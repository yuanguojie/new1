<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>


	<script>
	$("#tsfform :input[name='assetId']").keyup(function(){
		var assetid = $(":input[name='assetId']").val();
		$.ajax({
            type : "post",
            url : getPrefix()+"/assetname",
            data : {
               id : assetid
            },
            async:false,
            success : function(data) {
            	$("#tsfform :input[name='asset']").val(data.name);
            },
            error : function(data) {
                alert("处理出现异常...");
            }
        });
	})
	
	</script>


    
    <form id="tsfform" action="${pageContext.request.contextPath}/addtsf" method="post">
    	<div>
    		<label for="TSDate">盘点日期:</label>
    		<input class="easyui-validatebox" type="text" name="TSDate" data-options=""/>
    	</div>
    	<br/>
    	<div>
    		<label for="deptId">部门编号:</label>
    		<select id="deptId">
					${deptlist}
				</select>
    		<input type="hidden" name="deptId" />
    	</div>
    	<br/>
    	<div>
    		<input class="easyui-validatebox" type="hidden" value="${sessionScope.user.id}" name="createEmpId" data-options=""/>
    	</div>
    	<div>
    		<label for="storageId">仓库编号:</label>
    			<select id="storageId">
					${storagelist}
				</select>
    		<input  type="hidden" name="storageId" />
    	</div>
    	<br/>
    	<div>
    		<label for="assetId">资产编号:</label>
    		<input class="easyui-validatebox" type="text" name="assetId" data-options=""/>
    	</div>
    	<br/>
    	<div>
    		<label for="assetId">资产名称:</label>
    		<input class="easyui-validatebox" type="text" readonly="readonly" name="asset" data-options=""/>
    	</div>
    	<br/>
    	<div>
    		<label for="totalAmount">总数量:</label>
    		<input class="easyui-validatebox" type="text" name="totalAmount" data-options=""/>
    	</div>
    	<br/>
    	<div>
    		<label for="lostAmount">报废损失数量:</label>
    		<input class="easyui-validatebox" type="text" name="lostAmount" data-options=""/>
    	</div>
    	<div id="msgtsf" style="margin-top: -6px;color:red;"></div>
    </form>