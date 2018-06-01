package domainextand;

import java.math.BigDecimal;
import java.util.Date;

public class T_MoveStock {
	private Integer id;

    private String billNo;

    private String outDate;

    private Integer flowFlag;

    private BigDecimal totalCost;

    private String inDate;

    private Integer deptId;

    private Integer createEmpId;

    private Integer outEmpId;

    private Integer outStorageId;

    private Integer inDeptId;

    private Integer inStorageId;

    private Integer inEmpId;
    
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
		this.billNo = billNo;
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

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
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

	public Integer getSortCode() {
		return sortCode;
	}

	public void setSortCode(Integer sortCode) {
		this.sortCode = sortCode;
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

	public Integer getInAmount() {
		return inAmount;
	}

	public void setInAmount(Integer inAmount) {
		this.inAmount = inAmount;
	}

	public Integer getMoveStockId() {
		return moveStockId;
	}

	public void setMoveStockId(Integer moveStockId) {
		this.moveStockId = moveStockId;
	}

	public Integer getAssetId() {
		return assetId;
	}

	public void setAssetId(Integer assetId) {
		this.assetId = assetId;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	private Integer sortCode;

    private Integer outAmount;

    private BigDecimal price;

    private Integer inAmount;

    private Integer moveStockId;

    private Integer assetId;
    
    private String operation;
}
