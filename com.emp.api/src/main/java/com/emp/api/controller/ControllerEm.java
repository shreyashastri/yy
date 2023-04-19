package com.emp.api.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.emp.api.dto.EmpImgResponse;
import com.emp.api.dto.EmpResponseRP;
import com.emp.api.dto.PagingContent;
import com.emp.api.dto.PagingReponse;
import com.emp.api.dto.PojoUpdate;
import com.emp.api.dto.Pojoemp;
import com.emp.api.dto.Pojogetnameid;
import com.emp.api.dto.RequestOnetoManyPojo;
import com.emp.api.dto.Response;
import com.emp.api.entity.Entty;
import com.emp.api.service.IntServiceEmp;


@RestController
@RequestMapping("/empuser")
public class ControllerEm {
	
	@Autowired
	IntServiceEmp service; 
	
	
	//CREATING DATA 
   @PostMapping("/createuser")
  public Map<String,String>postdetails(@RequestBody Pojoemp epj){
		Map<String,String> map = service.createuser(epj);
	return map;
	}
   
    //FETCH DATA BY ID
  @GetMapping("/getdata/{id}")
  public Response fetchuser(@PathVariable Integer id){	   
  Response m1 = service.getuserbyid(id);
  return m1;
   }
   
  //FETCH DATA BY NAME FROM TABLE 
  @GetMapping("/getname/{first_Name}")
  public Map<String, Object> fetchusername(@PathVariable String firstName){
  Map<String, Object> m3 = service.getuserbyname(firstName);
  return m3;
  }
  
    //FETCH DATA BY ID AND NAME
    @PostMapping("/getidname")
    public Map<String, Object> fetchidandname(@RequestBody Pojogetnameid pj){
	 Map<String,Object> m4 =service.getuserbyidandname(pj);
	 return m4;
     }
  
  
    //UPDATE DATA(employee and user) BY ID 
   @PutMapping("/update/{id}")
   public Map<String,String>updatedetails(@RequestBody PojoUpdate update, @PathVariable("id") Integer id){
   Map<String,String> m2 = service.updateuser(update, id);
        return m2;
       }
   
   //CREATE USER FOR PAGINATION
   @PostMapping("/createpage")
   public PagingContent pg (@RequestBody PagingContent pagingcontent) {
	    return  service.createContent(pagingcontent);
          }
   
   //PAGINATION  AND SORTING (asc) NOTE:  Do not use path variable since it is not a good practice by convention use requestparam
   @GetMapping("/pagination")
   public  PagingReponse getpageination(@RequestParam (value="pageNumber",defaultValue="10")Integer pageNumber,
		   @RequestParam (value="pageSize", defaultValue="1") Integer pageSize ,@RequestParam String sortBy,@RequestParam String sortDirection) {
	return  service.getalldetails(pageNumber, pageSize, sortBy, sortDirection);    
	}
   
   
   //DELETE  DATA BY ID
   @DeleteMapping("/delete/{id}")
   public Map<String,String> deletedetails(@PathVariable Integer id){
   Map<String,String> m5 = service.deleteuserbyid(id);
	return m5;
	  }
   
   
     //FILTER DATA BY first_Name
     @GetMapping("/getfirstname")
    Page<Entty>getfirstnamein(@RequestParam Integer pageNumber ,@RequestParam Integer pageSize,@RequestParam String firstName,@RequestParam String lastName){
    Page<Entty> page = service.getfirstname(firstName, lastName, pageNumber, pageSize);
      return page; 
          }
     
     
     //CREATE  FOR ONE TO MANY MAPPING
     @PostMapping("/fetchaddressemploy")
     public RequestOnetoManyPojo manyPojo(@RequestBody  RequestOnetoManyPojo requestOnetoManyPojo) {
      return service.getdetails(requestOnetoManyPojo);
     }
     
     
     //STORE EMPLOYEE DETAILS (MetaData Form)
     @PostMapping("/storedata")
     public Map<String, String> store( @RequestPart("image") MultipartFile file, @RequestPart("metadata") String data){
    	 return service.storedata(file, data);
     }
     
     
     
     @GetMapping("/getval/{id}")
     public  EmpImgResponse fetchval(@PathVariable Integer id){
    	  EmpImgResponse r1 = service.getimagebyid(id);
		return r1;
    	 }
     
//     
     
//     //STORE THE IMAGE 
//       @PostMapping("/image")
//       public Map<String,String>saveimg(@RequestParam("image") @RequestBody ImageDto idto ){
//    	 Map<String,String> mp = service.storeimage(idto);
//    		return mp;
    	   
//    }




}


