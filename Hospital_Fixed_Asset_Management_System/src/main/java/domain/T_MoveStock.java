package domain;

import java.math.BigDecimal;
import java.util.Date;

public class T_MoveStock {
    private Integer id;

    private String billNo;

    private String outDate;

    private Integer flowFlag;

    private double totalCost;

    private String inDate;

    private Integer deptId;

    private Integer createEmpId;

    private Integer outEmpId;

    private Integer outStorageId;

    private Integer inDeptId;

    private Integer inStorageId;

    private Integer inEmpId;
    
    private String operation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public Integer getFlowFlag() {
        return flowFlag;
    }

    public void setFlowFlag(Integer flowFlag) {
        this.flowFlag = flowFlag;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double d) {
        this.totalCost = d;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String string) {
        this.inDate = string;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getCreateEmpId() {
        return createEmpId;
    }

    public void setCreateEmpId(Integer createEmpId) {
        this.createEmpId = createEmpId;
    }

    public Integer getOutEmpId() {
        return outEmpId;
    }

    public void setOutEmpId(Integer outEmpId) {
        this.outEmpId = outEmpId;
    }

    public Integer getOutStorageId() {
        return outStorageId;
    }

    public void setOutStorageId(Integer outStorageId) {
        this.outStorageId = outStorageId;
    }

    public Integer getInDeptId() {
        return inDeptId;
    }

    public void setInDeptId(Integer inDeptId) {
        this.inDeptId = inDeptId;
    }

    public Integer getInStorageId() {
        return inStorageId;
    }

    public void setInStorageId(Integer inStorageId) {
        this.inStorageId = inStorageId;
    }

    public Integer getInEmpId() {
        return inEmpId;
    }

    public void setInEmpId(Integer inEmpId) {
        this.inEmpId = inEmpId;
    }

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}