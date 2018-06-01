package domain;

import java.math.BigDecimal;

public class T_MoveStockDtl {
    private String id;

    private Integer sortCode;

    private Integer outAmount;

    private Double price;

    private Integer inAmount;

    private Integer moveStockId;

    private Integer assetId;
    
    private String operation;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double double1) {
        this.price = double1;
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
}