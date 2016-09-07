package com.vsi.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vsi.boot.domain.ShopFile;
import com.vsi.boot.repository.DocumentRepository;

@Service
public class DocumentService {

	     @Autowired
	    private DocumentRepository docuemntsRepository;
	    
	    ///Client
	    
	    public List<ShopFile> findAllDocument(){
	        return (List<ShopFile>) docuemntsRepository.findAll();
	    }
	    
	    public ShopFile findDocumentById(Long shopId){
	        return  docuemntsRepository.findOne(shopId);
	    }
	    
	    public ShopFile saveDocument(ShopFile shopFile){
	        return  docuemntsRepository.save(shopFile);
	    }
	    
	    public List<ShopFile> findByFileType(String fileType)
	    {
	    	return docuemntsRepository.findByFileType(fileType);
	    }
	    
		public List<ShopFile> findByDocumentTypeAndShopId(String fileType,Long shopId){
			
			return docuemntsRepository.findByFileTypeAndShopId(fileType, shopId);
		}
		
		public int deleteImageById(ShopFile shopFile)
		{
			//return docuemntsRepository.deleteImageById(shopFile); 
			docuemntsRepository.delete(shopFile.getId());
			return 1;

		}
		
		public ShopFile findImageByFileName(String fileName)
		{
			return docuemntsRepository.findImageByFileName(fileName); 
		}

}
