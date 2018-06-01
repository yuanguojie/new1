package domainextand;

import java.math.BigDecimal;

public class movestockview {
	private Integer id;

	private String assetId;
	
    private String billNo;

    private String outDate;

    private BigDecimal totalCost;
    
    private String deptId;

    private String createEmpId;

    private String outEmpId;

    private String outStorageId;

    private String inDeptId;

    private String inStorageId;
    
    private String inEmpId;
    
    private Integer outAmount;

    private BigDecimal price;
    
    private String operation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAssetId() {
		return assetId;
	}

	public void setAssetId(String assetId) {
		this.assetId = assetId;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getCreateEmpId() {
		return createEmpId;
	}

	public void setCreateEmpId(String createEmpId) {
		this.createEmpId = createEmpId;
	}

	public String getOutEmpId() {
		return outEmpId;
	}

	public void setOutEmpId(String outEmpId) {
		this.outEmpId = outEmpId;
	}

	public String getOutStorageId() {
		return outStorageId;
	}

	public void setOutStorageId(String outStorageId) {
		this.outStorageId = outStorageId;
	}

	public String getInDeptId() {
		return inDeptId;
	}

	public void setInDeptId(String inDeptId) {
		this.inDeptId = inDeptId;
	}

	public String getInStorageId() {
		return inStorageId;
	}

	public void setInStorageId(String inStorageId) {
		this.inStorageId = inStorageId;
	}

	public String getInEmpId() {
		return inEmpId;
	}

	public void setInEmpId(String inEmpId) {
		this.inEmpId = inEmpId;
	}

	public Integer getOutAmount() {
		return outAmount;
	}

	public void setOutAmount(Integer outAmount) {
		this.outAmount = outAmount;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

    
}
