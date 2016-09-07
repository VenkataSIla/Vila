package com.vsi.boot.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.vsi.boot.domain.ShopFile;

public class DocumentCustomServiceImpl implements DocumentCustomService{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<ShopFile> findByFileType(String fileType)
	{
		return  entityManager.createQuery("select e from shop_file e where e.file_type like '"+fileType+"'").getResultList();

	}
	
	@SuppressWarnings("unchecked")
	public List<ShopFile> findByFileTypeAndShopId(String fileType,Long shopId)
	{
		return  entityManager.createQuery("select e from shop_file e where e.file_type like '"+fileType+"' and e.shopId ="+shopId+"").getResultList();
	}
   
	public int deleteImageById(ShopFile shopFile)
	{
		Query query =  entityManager.createQuery("delete e from shop_file e where e.id = "+shopFile.getId()+" ");
		query.executeUpdate();
		return query.executeUpdate();
	}

	public ShopFile findImageByFileName(String fileName) {
		return (ShopFile) entityManager.createQuery("select e from shop_file e where e.file_name like '"+fileName+"'").getResultList();
	}
	
	

}
