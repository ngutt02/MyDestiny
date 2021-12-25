package com.fileupload.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fileupload.dao.IFileUploadDao;
import com.fileupload.entity.UploadFile;
@Repository
@Transactional
public class FileUploadDaoImpl implements IFileUploadDao {


	@Autowired
	HibernateTemplate hibernateTemplate;
	public void saveFile(UploadFile uploadFile) {

		hibernateTemplate.save(uploadFile);

	}

}
