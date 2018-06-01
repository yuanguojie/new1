package domainextand;


public class T_TakeStock2 {
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
    
    private Integer sortCode;

	private Integer depr_id;

    private Integer totalAmount;

    private Integer lostAmount;

    private Integer assetId;
    
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
    public Integer getSortCode() {
		return sortCode;
	}

	public void setSortCode(Integer sortCode) {
		this.sortCode = sortCode;
	}

	public Integer getDepr_id() {
		return depr_id;
	}

	public void setDepr_id(Integer depr_id) {
		this.depr_id = depr_id;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getLostAmount() {
		return lostAmount;
	}

	public void setLostAmount(Integer lostAmount) {
		this.lostAmount = lostAmount;
	}

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}
}