package com.fileupload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fileupload.dao.IFileUploadDao;
import com.fileupload.entity.UploadFile;

@Controller
public class FileUploadDownloadController {

	@Autowired
	IFileUploadDao dao;
	
	@GetMapping("/fileUploadPage")
	public String getFileUploadPage()
	{
		return "fileUpload";
	}
	
	@PostMapping("/doUpload")
	public String handleFileUpload(@RequestParam("file1")CommonsMultipartFile[] cmf,Model model)
	{
		for(CommonsMultipartFile mfile:cmf)
		{
			UploadFile uf=new UploadFile();
			uf.setFileName(mfile.getName());
			uf.setFileData(mfile.getBytes());
			
		}
		model.addAttribute("msg","file uploaded successfully");
		return null;
		
		
	}
}
