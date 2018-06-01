<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    
    
    <style>

        #mlogform label {
    	width:80px;
    	display: inline-block;
    	}

	</style>
<script>
	$("#mlogform :input[name='assetId']").keyup(function(){
		var assetid = $(":input[name='assetId']").val();
		$.ajax({
            type : "post",
            url : getPrefix()+"/assetname",
            data : {
               id : assetid
            },
            async:false,
            success : function(data) {
            	$("#mlogform :input[name='asset']").val(data.name);
            },
            error : function(data) {
                alert("处理出现异常...");
            }
        });
	})
	
	</script>
    
    
    
    
    
    <form id="mlogform" action="${pageContext.request.contextPath}/addmlog" method="post">
		<div>
			<input type="hidden" name="createEmpId" value="${sessionScope.user.id}"/>
		</div>
    	<div>
    		<label for="deptId">转出部门</label>
    			<select id="deptId">
					${outdeptlist}
				</select>
    		<input type="hidden" name="deptId" data-options=""/>
    	</div>
		<br/>
		<div>
    		<label for="outEmpId">转出人</label>
    			<select id="outEmpId">
					${outemplist}
				</select>
    		<input type="hidden" name="outEmpId" />
    	</div>
    	<br/>
		<div>
    		<label for="outStorageId">转出仓库</label>
    			<select id="outStorageId">
					${outstoragelist}
				</select>
    		<input type="hidden" name="outStorageId" />
    	</div>
    	<br/>
    	<div>
    		<label for="inDeptId">转入部门</label>
    			<select id="inDeptId">
					${indeptlist}
				</select>
    		<input type="hidden" name="inDeptId" />
    	</div>
    	<br/>
    	<div>
    		<label for="inStorageId">转入仓库</label>
    			<select id="inStorageId">
					${instoragelist}
				</select>
    		<input type="hidden" name="inStorageId" />
    	</div>
    	<br/>
    	<div>
    		<label for="inEmpId">接收人&nbsp;&nbsp;&nbsp; :</label>
    			<select id="inEmpId">
					${inemplist}
				</select>
    		<input type="hidden" name="inEmpId" />
    	</div>
    	<br/>
    	<div>
    		<label for="assetId">资产编号:</label>
    		<input class="easyui-validatebox" type="text" name="assetId" />
    	</div>
    	<br/>
    	<div>
    		<label for="assetId">资产名称:</label>
    		<input class="easyui-validatebox" type="text" readonly="readonly" name="asset" data-options=""/>
    	</div>
    	<br/>
    	<div>
    		<label for="OutAmount">出库数量:</label>
    		<input class="easyui-validatebox" type="text" name="OutAmount" />
    	</div>
    	<br/>
    	<div id="msgm" style="margin-top: -6px;color:red;"></div>
    </form>