package com.vsi.boot.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.vsi.boot.config.AppConstant;
import com.vsi.boot.domain.Client;
import com.vsi.boot.domain.LoginUser;
import com.vsi.boot.domain.ShopFile;
import com.vsi.boot.service.ClientService;
import com.vsi.boot.service.DocumentService;
import com.vsi.boot.util.CommonUtils;
import com.vsi.boot.util.FileUtil;
import com.vsi.boot.util.ImageUtil;

@Controller
public class ClientController {

		private static final Logger log = LoggerFactory.getLogger(ClientController.class);

	    @Autowired
	    private ClientService clientService;
	    
	    @Autowired
	    private DocumentService documentService;
	
	 @RequestMapping(value = "clientView")
	    public String clientView(Model model,HttpServletRequest request,HttpServletResponse response){
	    	
	        List<Client> clientJobs = clientService.findAllClient();	    	
	    	model.addAttribute("clientJobs", clientJobs);
	    	log.info("");
	        return "client/clientView";
	    }
	    
	    @RequestMapping(value = "clientNewJob")
	    public String clientNewJob( HttpServletRequest request,Model model){
	    	
	    	List<MultipartFile> isbFiles = new ArrayList<MultipartFile>();
	    	List<MultipartFile> gsbFiles = new ArrayList<MultipartFile>();
	    	model.addAttribute("isbFiles", isbFiles);
	    	model.addAttribute("gsbFiles", gsbFiles);
	        return "client/clientNewJob";
	    }
	        
	    @RequestMapping(value = "saveClient", method = RequestMethod.POST)
	    public String save(HttpServletRequest request,Client client,String actionFlag, Model model){
	    	LoginUser loginUser = (LoginUser) WebUtils.getSessionAttribute(request,AppConstant.LOGIN_USER_SESSION);
	    	client.setCreatedBy(loginUser.getUsername());
	    	client.setUpdatedBy(loginUser.getUsername());
	    	
	    	if(actionFlag.equalsIgnoreCase("Save"))
	    	{
	    		WebUtils.setSessionAttribute(request, AppConstant.CLIENT_SAVE_SESSION_OBJ, client);
	    	}
	    	if(actionFlag.equalsIgnoreCase("Client new Job"))
	    	{
	    		clientService.saveClient(client);
		        
	    	}
	    	if(actionFlag.equalsIgnoreCase("Send to Dealer"))
	    	{
	    	}
	    	
	        return "redirect:clientView";
	    }

	    @RequestMapping(value = "editClient/{shopId}")
	    public String edit(HttpServletRequest request,@PathVariable Long shopId, Model model){
	    	
	    	
	    	
	    	Client client = clientService.findClientById(shopId);
	    	List<String> isbFileNames = new ArrayList<String>();
	    	List<String> gsbFileNames = new ArrayList<String>();
	    	getLocalPhotsByIds(client,AppConstant.FILE_ISB_DOCS,isbFileNames);
	    	getLocalPhotsByIds(client,AppConstant.FILE_GBS_DOCS,gsbFileNames);
	    	
            File imgFile = new File(AppConstant.PATH_TO_SERVER_IMAGE_UPLOAD_DIRECTORY);
            imgFile.getAbsoluteFile().canExecute();
	    	
	    	model.addAttribute("isbFileNames", isbFileNames);
	    	model.addAttribute("gsbFileNames", gsbFileNames);
	    	
	        model.addAttribute("client",clientService.findClientById(shopId));
	        
	        List<MultipartFile> isbFiles = new ArrayList<MultipartFile>();
	    	List<MultipartFile> gsbFiles = new ArrayList<MultipartFile>();
	    	model.addAttribute("isbFiles", isbFiles);
	    	model.addAttribute("gsbFiles", gsbFiles);
	    	
	        List<String> isbClarifications = new ArrayList<String>();
	        isbClarifications.add(0, "");
	        isbClarifications.add(1, "Vinyl");
	        isbClarifications.add(2, "PVC+Vinyl");
	        isbClarifications.add(3, "One Way Vision");
	        isbClarifications.add(4, "Others");
	        model.addAttribute("isbClarification",isbClarifications);
	        
	        
	        List<String> gbsClarifications = new ArrayList<String>();
	        gbsClarifications.add(0, "");
	        gbsClarifications.add(1, "Flexy Glow");
	        gbsClarifications.add(2, "ACP");
	        gbsClarifications.add(3, "Others");
	        model.addAttribute("gbsClarifications",gbsClarifications);
	        
	        
	        
	        return "client/clientReviewJob";
	    }


	    private void getLocalPhotsByIds(Client client,String fileType, List<String> fileNames) {
	    	
	    	List<ShopFile> shopFiles = documentService.findByDocumentTypeAndShopId(fileType, client.getShopId());
	    	
	    	for (int i=0; i<shopFiles.size(); i++){
	    		ShopFile shopFile =  (ShopFile) shopFiles.get(i);            
	             String fName = checkForImageFile(shopFile);  
	            
	             if (fName.equals("NO_PHOTO")){
	                 continue;
	             }             
	             fileNames.add(fName);  
	             
	             //Photos physical folder location 
	             // required height and width
	             File imgFile = new File(AppConstant.PATH_TO_SERVER_IMAGE_UPLOAD_DIRECTORY+fName);
	             int imgHeight = 75; 
	             int imgWidth = 75;
	             
	             try{
	                 BufferedImage input = ImageIO.read(imgFile);
	 
	                 int srcHeight = input.getHeight();
	                 int srcWidth = input.getWidth();                 
	                 if (srcHeight > srcWidth) {
	                     imgWidth = (int) (((float) imgHeight / (float) srcHeight) * (float) srcWidth);
	                 } else if (srcWidth > srcHeight) {
	                     imgHeight = (int) (((float) imgWidth / (float) srcWidth) * (float) srcHeight);
	                 }
	             }catch(Exception e){
	                 e.printStackTrace();
	             }             
			 } 
			
		}

		@RequestMapping(value = "updateClient",method = RequestMethod.POST)
	    public String update(HttpServletRequest request,Client client, Model model,@RequestParam @PathVariable List<MultipartFile> isbFiles, @RequestParam @PathVariable List<MultipartFile> gsbFiles){
	    	LoginUser loginUser = (LoginUser) WebUtils.getSessionAttribute(request,AppConstant.LOGIN_USER_SESSION);
	    	client.setUpdatedBy(loginUser.getUsername());
	    	
	    	System.out.println(request.getContextPath());
	    	
	    	List<ShopFile> shopFiles = new ArrayList<ShopFile>();
	    	
	    	if(gsbFiles.size()>0)
	    	{
	    	int count = 0;
	    	for (MultipartFile multipartFile : gsbFiles) {
	    		try {
	    			if(multipartFile.getBytes().length>0)
	    			{
	    			ShopFile shopFile = new ShopFile();
	    			shopFile.setMultipartFile(multipartFile.getBytes());
	    			shopFile.setFileName(String.valueOf(System.currentTimeMillis())+"_"+multipartFile.getOriginalFilename());
	    			
	    			try {
						createPhotoInPhysicalFolder(shopFile, ImageUtil.IMAGE_SMALL_WIDTH, ImageUtil.IMAGE_SMALL_HEIGHT);
					} catch (InterruptedException e) {
						log.error("Photo Resize error");
						e.printStackTrace();
					}
	    			shopFile.setShopId(client.getShopId());
	    			shopFile.setShopName(client.getShopName());
	    			shopFile.setUserType(loginUser.getUserType());
	    			shopFile.setCreatedBy(loginUser.getUsername());
	    			shopFile.setCreateDateTime(new Date());
	    			shopFile.setUpdatedBy(loginUser.getUsername());
	    			shopFile.setShopNumber(client.getShopNumber());
	    			shopFile.setFileType(AppConstant.FILE_GBS_DOCS);
	    			documentService.saveDocument(shopFile);
					shopFiles.add(shopFile);
	    			}
					count++;
	    			
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    	}
	    	
	    	if(isbFiles.size()>0)
	    	{
	    	int countsb = 0;
	    	for (MultipartFile multipartFile : isbFiles) {
	    		try {
   			
	    			if(multipartFile.getBytes().length>0)
	    			{
					ShopFile shopFile = new ShopFile();
	    			shopFile.setMultipartFile(multipartFile.getBytes());
	    			shopFile.setMultipartFile(multipartFile.getBytes());
	    			shopFile.setFileName(String.valueOf(System.currentTimeMillis())+"_"+multipartFile.getOriginalFilename());
	    			
	    			try {
						createPhotoInPhysicalFolder(shopFile, ImageUtil.IMAGE_SMALL_WIDTH, ImageUtil.IMAGE_SMALL_HEIGHT);
					} catch (InterruptedException e) {
						log.error("Photo Resize error");
						e.printStackTrace();
					}
	    			shopFile.setShopId(client.getShopId());
	    			shopFile.setShopName(client.getShopName());
	    			shopFile.setUserType(loginUser.getUserType());
	    			shopFile.setCreatedBy(loginUser.getUsername());
	    			shopFile.setCreateDateTime(new Date());
	    			shopFile.setUpdatedBy(loginUser.getUsername());
	    			shopFile.setShopNumber(client.getShopNumber());
	    			shopFile.setFileType(AppConstant.FILE_ISB_DOCS);
	    			documentService.saveDocument(shopFile);
					shopFiles.add(shopFile);
	    			}
					countsb++;
	    			
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	    	}
	    	
	        clientService.saveClient(client);
	        return "redirect:clientView";
	    }
	    
	    
	    public boolean createPhotoInPhysicalFolder(ShopFile photoBean,String imageSmallWidth, String imageSmallHeight) throws IOException, InterruptedException 	
		{
	    	photoBean.getMultipartFile();
	        String filePath = AppConstant.PATH_TO_SERVER_IMAGE_UPLOAD_DIRECTORY + photoBean.getFileName();
	
			int maxWidth = Integer.parseInt(imageSmallWidth);
			int maxHeight= Integer.parseInt(imageSmallHeight);
	
			boolean fileCreated = false;
			 if( photoBean.getMultipartFile() != null )
			{
				byte[]  fileByteData = ImageUtil.resizeImage(photoBean.getMultipartFile(), maxWidth, maxHeight);
				// Create the image file if it does not exist.
				
				fileCreated = FileUtil.createFileIfDoesnotExist(fileByteData, filePath);
				//We can remove heavy image byte from Bean as we already have image created on file system.
			}
			return fileCreated;
		}
	    
	   
	    @RequestMapping(value = "deleteImage/{fileName}/{shopId}")
	    public String delteImage(HttpServletRequest request,Client client, Model model, @PathVariable(value="fileName") String fileName,@PathVariable(value="shopId") Long shopId){
	    	LoginUser loginUser = (LoginUser) WebUtils.getSessionAttribute(request,AppConstant.LOGIN_USER_SESSION);
	    	client.setUpdatedBy(loginUser.getUsername());
	    	ShopFile shopFile = documentService.findImageByFileName(fileName);
	    	
	    	if(shopFile != null)
	    	{
	    		String filePath = AppConstant.PATH_TO_SERVER_IMAGE_UPLOAD_DIRECTORY + fileName;
	    		File file = new File(filePath);

	    		if(file.delete()){
	    			System.out.println(file.getName() + " is deleted!");
	    		}else{
	    			System.out.println("Delete operation is failed.");
	    		}
	    	  documentService.deleteImageById(shopFile);
	    	}
	    	
			return "redirect:/editClient/"+shopId;//"redirect:editClient/"+shopId;
	    	
	    }
	    
	    @RequestMapping(value = "exportFile")
	    public void exportFile(HttpServletRequest request,HttpServletResponse response,Client client, Model model)
	    {
	    	List<Client> clients = new ArrayList<Client>();
	    	clients.add(client);
	    	CommonUtils.ConverObjectToCSVFilWitheHeaderAndObjectMapping(response, clients);
	    }
	      

	    public String checkForImageFile(ShopFile photo)
		{
			
		    FileOutputStream fileOutPut = null;
		    try{	    	  
		    	 /*check to see if image exists in file system
		         if yes, then return image name
		         if no, then get image from database
		         if image is not in database, return "image not available"
		         else, get image from database, and create in file system, then return image name*/
				
		        if (StringUtils.isBlank(photo.getFileName())|| photo.getFileName().trim().length() < 1)
		            return "NO_PHOTO";
		        
		        File imageFile = new File(AppConstant.PATH_TO_SERVER_IMAGE_UPLOAD_DIRECTORY + photo.getFileName());
		
		        if (imageFile.exists()){
		            return photo.getFileName();
		        } else {	        	
		            byte[] imageBytes = photo.getMultipartFile();
		            if (imageBytes == null || imageBytes.length < 1)
		            {
		                return "NO_PHOTO";
		            }
		
		            fileOutPut = new FileOutputStream(AppConstant.PATH_TO_SERVER_IMAGE_UPLOAD_DIRECTORY + photo.getFileName());
		            for (int i = 0; i < imageBytes.length; i++)
		            {
		            	fileOutPut.write(imageBytes[i]);
		            }
		            fileOutPut.close();
		        }    
		        
		    }
		    catch (Exception e)
		    {
		    	e.printStackTrace();
		    }   
		    finally {
		
		    	fileOutPut = null;            
		    }     
		    return photo.getFileName();       
		    }
		
}
