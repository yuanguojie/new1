package domain;

public class T_TakeStockDtl {
    private Integer id;

    private Integer sortCode;

    private Integer depr_id;

    private Integer totalAmount;

    private Integer lostAmount;

    private Integer takeStockId;

    private Integer assetId;
    
    private String operation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getTakeStockId() {
        return takeStockId;
    }

    public void setTakeStockId(Integer takeStockId) {
        this.takeStockId = takeStockId;
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
}