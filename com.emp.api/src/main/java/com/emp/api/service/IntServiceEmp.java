package com.emp.api.service;

import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.emp.api.dto.EmpImgResponse;
import com.emp.api.dto.ImageResponse;
import com.emp.api.dto.PagingContent;
import com.emp.api.dto.PagingReponse;
import com.emp.api.dto.PojoUpdate;
import com.emp.api.dto.Pojoemp;
import com.emp.api.dto.Pojogetnameid;
import com.emp.api.dto.RequestOnetoManyPojo;
import com.emp.api.dto.Response;

import com.emp.api.entity.Entty;

public interface IntServiceEmp  {
	
	    Map<String,String>createuser(Pojoemp epj);
	
	    Map<String,String>updateuser(PojoUpdate update,Integer id);
	   
	    Map<String,Object>getuserbyname(String firstName);
	    
		Map<String,Object>getuserbyidandname(Pojogetnameid pj); 
		
		Response getuserbyid(Integer id);

		Map<String,String> deleteuserbyid(Integer id);
	
		PagingContent createContent(PagingContent  pagingcontent);
		
		PagingReponse getalldetails(Integer pageNumber, Integer pageSize, String sortBy, String sortDirection); 
        
        Page<Entty> getfirstname(String firstName, String lastName, Integer pageNumber, Integer pageSize);

        RequestOnetoManyPojo getdetails(RequestOnetoManyPojo requestOnetoManyPojo);
     
       // Map<String,String>storedata(MultipartFile file,String data); 
        
        Map<String,String>storedata(MultipartFile file,String data); 
        
        EmpImgResponse getimagebyid(Integer id); 
        
        
        
        }

