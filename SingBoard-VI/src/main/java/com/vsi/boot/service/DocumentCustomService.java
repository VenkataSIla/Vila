package com.vsi.boot.service;

import java.util.List;

import com.vsi.boot.domain.ShopFile;

public interface DocumentCustomService {
	
	public List<ShopFile> findByFileType(String fileType);
	
	public List<ShopFile> findByFileTypeAndShopId(String fileType,Long shopId);
	
	public int deleteImageById(ShopFile shopFile);
	
	public ShopFile findImageByFileName(String fileName);

}
