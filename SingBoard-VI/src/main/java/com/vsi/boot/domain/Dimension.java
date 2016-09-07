package com.vsi.boot.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Dimension implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name = "id")
	private Long shopId = 0l;
	private String shopName = null;
	private String shopNumber = null;
	
	private String isbClarification = null;
	private String isbBoardSizeLength = null;
	private String isbBoardSizeHeight = null;	
	private String isbPhotoFile = null;
    private Boolean[] isbPhotoFlag = new Boolean[5];
	private String gbsClarification = null;
    private String gbsBoardSizeLength = null;
    private String gbsBoardSizeHeight = null;
    private String gbsPhotoFile = null;
    private Boolean[] gbsPhotoFlag = new Boolean[5];
    private String representativeRemark = null;
	
    private String userType = null;
    private String name = null;
	private String createdBy = null;
	private Date createDateTime = new Date();
	private String updatedBy = null;
	private Date updateDatetime = new Date();
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
	public String getIsbClarification() {
		return isbClarification;
	}
	public void setIsbClarification(String isbClarification) {
		this.isbClarification = isbClarification;
	}
	public String getIsbBoardSizeLength() {
		return isbBoardSizeLength;
	}
	public void setIsbBoardSizeLength(String isbBoardSizeLength) {
		this.isbBoardSizeLength = isbBoardSizeLength;
	}
	public String getIsbBoardSizeHeight() {
		return isbBoardSizeHeight;
	}
	public void setIsbBoardSizeHeight(String isbBoardSizeHeight) {
		this.isbBoardSizeHeight = isbBoardSizeHeight;
	}
	public String getIsbPhotoFile() {
		return isbPhotoFile;
	}
	public void setIsbPhotoFile(String isbPhotoFile) {
		this.isbPhotoFile = isbPhotoFile;
	}
	public Boolean[] getIsbPhotoFlag() {
		return isbPhotoFlag;
	}
	public void setIsbPhotoFlag(Boolean[] isbPhotoFlag) {
		this.isbPhotoFlag = isbPhotoFlag;
	}
	public String getGbsClarification() {
		return gbsClarification;
	}
	public void setGbsClarification(String gbsClarification) {
		this.gbsClarification = gbsClarification;
	}
	public String getGbsBoardSizeLength() {
		return gbsBoardSizeLength;
	}
	public void setGbsBoardSizeLength(String gbsBoardSizeLength) {
		this.gbsBoardSizeLength = gbsBoardSizeLength;
	}
	public String getGbsBoardSizeHeight() {
		return gbsBoardSizeHeight;
	}
	public void setGbsBoardSizeHeight(String gbsBoardSizeHeight) {
		this.gbsBoardSizeHeight = gbsBoardSizeHeight;
	}
	public String getGbsPhotoFile() {
		return gbsPhotoFile;
	}
	public void setGbsPhotoFile(String gbsPhotoFile) {
		this.gbsPhotoFile = gbsPhotoFile;
	}
	public Boolean[] getGbsPhotoFlag() {
		return gbsPhotoFlag;
	}
	public void setGbsPhotoFlag(Boolean[] gbsPhotoFlag) {
		this.gbsPhotoFlag = gbsPhotoFlag;
	}
	public String getRepresentativeRemark() {
		return representativeRemark;
	}
	public void setRepresentativeRemark(String representativeRemark) {
		this.representativeRemark = representativeRemark;
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
		return "Dimension [shopId=" + shopId + ", shopName=" + shopName
				+ ", shopNumber=" + shopNumber + ", isbClarification="
				+ isbClarification + ", isbBoardSizeLength="
				+ isbBoardSizeLength + ", isbBoardSizeHeight="
				+ isbBoardSizeHeight + ", isbPhotoFile=" + isbPhotoFile
				+ ", isbPhotoFlag=" + Arrays.toString(isbPhotoFlag)
				+ ", gbsClarification=" + gbsClarification
				+ ", gbsBoardSizeLength=" + gbsBoardSizeLength
				+ ", gbsBoardSizeHeight=" + gbsBoardSizeHeight
				+ ", gbsPhotoFile=" + gbsPhotoFile + ", gbsPhotoFlag="
				+ Arrays.toString(gbsPhotoFlag) + ", representativeRemark="
				+ representativeRemark + ", userType=" + userType + ", name="
				+ name + ", createdBy=" + createdBy + ", createDateTime="
				+ createDateTime + ", updatedBy=" + updatedBy
				+ ", updateDatetime=" + updateDatetime + "]";
	}
	
}
