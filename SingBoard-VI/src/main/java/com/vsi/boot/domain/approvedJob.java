package com.vsi.boot.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class approvedJob implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name = "id")
	private Long id = null;
	private Long shopId = 0L;
	private String jobId = null;
	
	private String poNumber = null;
	private Date poDate = null;
	private String productionStatus = null;
	private String remarks = null;
	private String invoiceNumber = null;
	
	private String userType = null;
	private String name = null;
	
	private String createdBy = null;
	private Date createDateTime = new Date();
	private String updatedBy = null;
	private Date updateDatetime = new Date();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public Date getPoDate() {
		return poDate;
	}
	public void setPoDate(Date poDate) {
		this.poDate = poDate;
	}
	public String getProductionStatus() {
		return productionStatus;
	}
	public void setProductionStatus(String productionStatus) {
		this.productionStatus = productionStatus;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdateDatetime() {
		return updateDatetime;
	}
	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
	@Override
	public String toString() {
		return "approvedJob [id=" + id + ", shopId=" + shopId + ", jobId="
				+ jobId + ", poNumber=" + poNumber + ", poDate=" + poDate
				+ ", productionStatus=" + productionStatus + ", remarks="
				+ remarks + ", invoiceNumber=" + invoiceNumber + ", userType="
				+ userType + ", name=" + name + ", createdBy=" + createdBy
				+ ", createDateTime=" + createDateTime + ", updatedBy="
				+ updatedBy + ", updateDatetime=" + updateDatetime + "]";
	}
	
	

}
