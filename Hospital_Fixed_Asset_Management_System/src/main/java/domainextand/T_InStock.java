package domainextand;

import java.math.BigDecimal;
import java.util.Date;

public class T_InStock {
    private Integer id;

    private String billNo;

    private String buyDate;

    private BigDecimal totalCost;

    private Integer flowFlag;

    private String inDateT;
    
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
		this.billNo = billNo;
	}

	public String getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getFlowFlag() {
        return flowFlag;
    }

    public void setFlowFlag(Integer flowFlag) {
        this.flowFlag = flowFlag;
    }

    public String getInDateT() {
        return inDateT;
    }

    public void setInDateT(String inDateT) {
        this.inDateT = inDateT;
    }

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}