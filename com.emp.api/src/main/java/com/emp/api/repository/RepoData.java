package com.emp.api.repository;

import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.emp.api.dto.ImageResponse;
import com.emp.api.entity.Entty;             

public interface RepoData extends CrudRepository<Entty,Integer>  {
	
	  @Query(value = "SELECT * FROM employ where id=?1", nativeQuery = true)
	   Map<String,Object>getEmpDetailsbyid(Integer id);
	   
	  @Query(value="SELECT * FROM address where empid = ?1", nativeQuery=true)
	     Map<String,Object>getEmpAddressbyid(Integer id);
	  
//	  @Query(value="SELECT * FROM employ where id =?1", nativeQuery=true)
//	  ResponseJson getdata (Integer id);
	 
	  @Query(value="SELECT response_Json from employ where id=?1 ", nativeQuery=true)
      String getdata (Integer id );    // take String here because we have get from databse in JSON String format 
	 
	  @Query(value= "SELECT * FROM employ where first_Name= ?1", nativeQuery=true)
	  Map<String,Object>getEmpName(String firstName);
	
	  @Query(value= "SELECT * FROM employ where  id= ?1 and first_Name= ?2", nativeQuery=true)
	  Map<String,Object>getEmpIdName(Integer id, String firstName);
	
	  //Integer id=get id from employees where user name = epj.getUser_Name()
	  @Query(value="SELECT id from employ where user_Name= ?1", nativeQuery=true)
	  Integer getId(String userName);
	 
	  //To filter by first_Name
	  @Query(value="SELECT * from employ where first_Name like %?1% and last_Name like %?2",nativeQuery=true)
	  Page<Entty> gettheName(String firstName, String lastName,Pageable pageable);
	 
	 //for one to many
	  @Query(value="SELECT id from employ where user_Name= ?1", nativeQuery=true)
	   Integer getempId(String userName);

	  @Query(value="SELECT id from employ where user_Name= ?1", nativeQuery=true)
	  Integer getemp_Id(String userName);
	  
	  @Query(value="Select * from emp_image where emp_id=?1", nativeQuery=true)
	  Map<String,Object>getEmpImgById(Integer id);
	  
	  
//      @Query(value="select count(*) from employ order by ",nativeQuery=true)
//	      
//        Map<String, Object> getClass(int totalElements, int totalPages);
//	                            
	 
	 }
