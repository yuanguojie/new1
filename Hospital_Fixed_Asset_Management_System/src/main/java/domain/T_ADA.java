package domain;

import java.util.Date;

public class T_ADA {
    private Integer id;

    private String name;

    private String OAddr;

    private String NAddr;

    private Integer outDeptid;

    private Integer inDeptid;

    private Integer outEmpid;

    private Integer inEmpid;

    private Date allocateDate;
    
    private String operation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOAddr() {
        return OAddr;
    }

    public void setOAddr(String OAddr) {
        this.OAddr = OAddr == null ? null : OAddr.trim();
    }

    public String getNAddr() {
        return NAddr;
    }

    public void setNAddr(String NAddr) {
        this.NAddr = NAddr == null ? null : NAddr.trim();
    }

    public Integer getOutDeptid() {
        return outDeptid;
    }

    public void setOutDeptid(Integer outDeptid) {
        this.outDeptid = outDeptid;
    }

    public Integer getInDeptid() {
        return inDeptid;
    }

    public void setInDeptid(Integer inDeptid) {
        this.inDeptid = inDeptid;
    }

    public Integer getOutEmpid() {
        return outEmpid;
    }

    public void setOutEmpid(Integer outEmpid) {
        this.outEmpid = outEmpid;
    }

    public Integer getInEmpid() {
        return inEmpid;
    }

    public void setInEmpid(Integer inEmpid) {
        this.inEmpid = inEmpid;
    }

    public Date getAllocateDate() {
        return allocateDate;
    }

    public void setAllocateDate(Date allocateDate) {
        this.allocateDate = allocateDate;
    }

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
}