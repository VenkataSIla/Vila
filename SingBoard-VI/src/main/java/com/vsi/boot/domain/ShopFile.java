package com.vsi.boot.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShopFile implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue
    @Column(name = "id")
	private Long id = 0l;
	private Long shopId = 0l;
	private String shopName = null;
	private String shopNumber = null;
	private String fileType = null;
	@Column(columnDefinition = "LONGBLOB")
	private byte[] multipartFile = null;
	private String fileName = null;
	private String userType = null;
  /*  private String name = null;*/
	private String createdBy = null;
	private Date createDateTime = null;
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
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopNumber() {
		return shopNumber;
	}
	public void setShopNumber(String shopNumber) {
		this.shopNumber = shopNumber;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getMultipartFile() {
		return multipartFile;
	}
	public void setMultipartFile(byte[] multipartFile) {
		this.multipartFile = multipartFile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/*public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}*/
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
		return "ShopFile [id=" + id + ", shopId=" + shopId + ", shopName="
				+ shopName + ", shopNumber=" + shopNumber + ", fileType="
				+ fileType + ", multipartFile="
				+ Arrays.toString(multipartFile) + ", fileName=" + fileName
				+ ", userType=" + userType + ", createdBy="
				+ createdBy + ", createDateTime=" + createDateTime
				+ ", updatedBy=" + updatedBy + ", updateDatetime="
				+ updateDatetime + "]";
	}
	
}
