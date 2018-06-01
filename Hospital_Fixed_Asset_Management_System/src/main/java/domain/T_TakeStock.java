package domain;

import java.util.Date;

public class T_TakeStock {
    private Integer id;

    private String billNo;

    private String TSDate;

    private String checkDateT;

    private Integer flowFlag;

    private Integer deptId;

    private Integer createEmpId;

    private Integer takeEmpId;

    private Integer storageId;

    private Integer checkEmpId;
    
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

    public String getTSDate() {
        return TSDate;
    }

    public void setTSDate(String TSDate) {
        this.TSDate = TSDate;
    }

    public String getCheckDateT() {
        return checkDateT;
    }

    public void setCheckDateT(String checkDateT) {
        this.checkDateT = checkDateT;
    }

    public Integer getFlowFlag() {
        return flowFlag;
    }

    public void setFlowFlag(Integer flowFlag) {
        this.flowFlag = flowFlag;
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

    public Integer getTakeEmpId() {
        return takeEmpId;
    }

    public void setTakeEmpId(Integer takeEmpId) {
        this.takeEmpId = takeEmpId;
    }

    public Integer getStorageId() {
        return storageId;
    }

    public void setStorageId(Integer storageId) {
        this.storageId = storageId;
    }

    public Integer getCheckEmpId() {
        return checkEmpId;
    }

    public void setCheckEmpId(Integer checkEmpId) {
        this.checkEmpId = checkEmpId;
    }

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}