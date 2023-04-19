package com.emp.api.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.emp.api.dto.EmpImgResponse;
import com.emp.api.dto.EmpResponseRP;
import com.emp.api.dto.ImageResponse;
import com.emp.api.dto.PagingContent;
import com.emp.api.dto.PagingReponse;
import com.emp.api.dto.PojoAddress;
import com.emp.api.dto.PojoAddressUpdate;
import com.emp.api.dto.PojoUpdate;
import com.emp.api.dto.Pojoemp;
import com.emp.api.dto.Pojogetnameid;
import com.emp.api.dto.RequestOnetoManyPojo;
import com.emp.api.dto.Response;
import com.emp.api.dto.ResponseJson;

import com.emp.api.entity.AddressEntity;
import com.emp.api.entity.EmpImg;
import com.emp.api.entity.Entty;
import com.emp.api.entity.ImageEntity;
//import com.emp.api.exception.AgeinvalidException
import com.emp.api.repository.AddressRepo;
import com.emp.api.repository.EmpImgRepository;
import com.emp.api.repository.EnttyPaging;
import com.emp.api.repository.ImageRepository;
import com.emp.api.repository.RepoData;
import com.emp.api.util.ImageUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;


    @Service
    public class ServiceImpl implements IntServiceEmp {
    	 
	@Autowired
	private RepoData rep;
	
	@Autowired
	private AddressRepo arep;
	
	@Autowired
	private EnttyPaging prep; 
	
	@Autowired 
	private ImageRepository irep; 
	
	@Autowired 
	private EmpImgRepository imgRepository; 
	
	
	ObjectMapper mapper; 
	@PostConstruct
	  public void init() {
	     mapper = new ObjectMapper();
	  }
	
	
 //CREATE EMPLOYEE AND EMPLOYEE ADDRESS DETAILS along with ObjectMapper 
	@Override
	public Map<String, String>createuser(Pojoemp epj) {
		
		Map<String,String> map = new HashMap<String,String>();
		 
		ResponseJson jsonData =  epj.getResponseJson();
		
		
//	    if(epj.getAge()>=18) {
//			 map.put("message","age is valid");
//		 }
//		 else {
//			 try {
//			 throw new AgeinvalidException("age not valid");
//				}
//		catch(Exception e){
//			System.out.println(e.getMessage());
//		}
			
		// }
		 
		 try {
				Entty emp  = new Entty();
				String data = mapper.writeValueAsString(jsonData);
				 
        //			ObjectMapper objectMapper = new ObjectMapper();
        //
        //		    String responseJsonJSON = "{\"designation\":\"\",\"hireDate\":\" \"}";
        //
        //		     ResponseJson responseJson = objectMapper.readValue(responseJsonJSON , ResponseJson.class);
 
				   emp.setAge(epj.getAge()); 
				   emp.setFirstName(epj.getFirstName()); 
				   emp.setUserName(epj.getUserName());
				   emp.setLastName(epj.getLastName());
				   emp.setPhno(epj.getPhno());
				   emp.setEmail(epj.getEmail());
				   emp.setDetails(data); 
				  
				 PojoAddress address= (PojoAddress) epj.getAddress(); 
		            
				 rep.save(emp);
		            
                 Integer id = rep.getId(epj.getUserName());
		           
        		           
		        //Integer id=get id from employees where user name = epj.getUserName()
		       
		         AddressEntity en = new AddressEntity();	
		           
		         en.setCountry(address.getCountry());
				 en.setState(address.getState());
				 en.setPostalCode( address.getPostalCode());
			     en.setEmpId(id);
		     
                  arep.save(en);
                  
                    map.put("Message","Success");
				}
		 catch (Exception e) {
					      System.out.print(e.getMessage());
			 		    map.put("Message","Failure");
				    }
				           
	                  return map;
	}
	
	//UPDATE USER Address  BY ID
     @Override
	public Map<String, String>updateuser(PojoUpdate update,Integer id) {
		Map<String,String>val = new HashMap<String,String>();
		
		 try {
		       Entty em = new Entty();
		       
		      em.setId(update.getId());   // we get the id and set it accordingly and alter the values based on the id in the table
	          em.setUserName(update.getUserName());
	          em.setFirstName(update.getFirstName());
		      em.setLastName(update.getLastName());
              em.setEmail(update.setEmail(update.getEmail()));
			  em.setAge(update.getAge());
			  em.setPhno(update.getPhno());  
			  
		       PojoAddressUpdate updateaddress = update.getAddressupdate();
			   
			   rep.save(em);
			  
			   AddressEntity addn = new AddressEntity();	  
	           
			   addn.setId(updateaddress.getId());
			   addn.setCity(updateaddress.getCity());
			   addn.setCountry(updateaddress.getCountry());
			   addn.setPostalCode(updateaddress.getPostalCode());
			   addn.setState(updateaddress.getState());
			   addn.setEmpId(updateaddress.getEmpid());
			  
			   arep.save(addn);
			   
			   val.put("Message","Success");
	     
			   
		} catch (Exception e) {
			System.out.println(e.getMessage());
			val.put("Message","Failure");
		}
	      return val;
	      }
     
     
    // FETCH USER BY NAME 
	@Override
	public Map<String, Object> getuserbyname(String firstName) {
		   Map<String,Object> m = rep.getEmpName(firstName);
		   return m;
	}
	
	// FETCH USER address BY ID
	@Override
	public Response getuserbyid(Integer id){
		
		   Response res = new Response(); 
		    
		 //  ResponseJson responseJson = new ResponseJson();  
		
		   Map<String,Object>dataEmp =rep.getEmpDetailsbyid(id);     
		  
		   // to fetch only employee details 
		  
		   Map<String,Object>dataAddr =rep.getEmpAddressbyid(id); 
		  
		
		   String datajson = rep.getdata(id);
		  
		   //  sql query to fetch the json data

    
				try {
					
					 ResponseJson str = mapper.readValue(datajson,  ResponseJson.class);
					  
					 
					  res.setFirstName(String.valueOf(dataEmp.get("first_Name")));   
					  res.setUserName(String.valueOf(dataEmp.get("user_Name")));
					  res.setLastName(String.valueOf(dataEmp.get("last_Name")));
					  res.setEmail(String.valueOf(dataEmp.get("email")));
					  res.setPhno(String.valueOf(dataEmp.get("phno")));
					  res.setId(Integer.parseInt(String.valueOf(dataEmp.get("id"))));
					  res.setAge(Integer.parseInt(String.valueOf(dataEmp.get("age"))));
					  
					  res.setResponseJson(str);
			        
					  res.setAddress(dataAddr);
					  
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

		 // created to 
//		  res.setFirstName(String.valueOf(dataEmp.get("first_Name")));   
//		  res.setUserName(String.valueOf(dataEmp.get("user_Name")));
//		  res.setLastName(String.valueOf(dataEmp.get("last_Name")));
//		  res.setEmail(String.valueOf(dataEmp.get("email")));
//		  res.setPhno(String.valueOf(dataEmp.get("phno")));
//		  res.setId(Integer.parseInt(String.valueOf(dataEmp.get("id"))));
//		  res.setAge(Integer.parseInt(String.valueOf(dataEmp.get("age"))));
//		  
//		  res.setResponseJson(str);
//        res.setAddress(dataAddr);

	  
	  		     return res;
		  
		  	}
	                     
	    // FETCH USER BY ID AND NAME 
		@Override
		public Map<String, Object> getuserbyidandname(Pojogetnameid pj) {
			Map<String,Object> data= rep.getEmpIdName(pj.getId(), pj.getFirstName());
			Entty e = new Entty();
			e.setId(pj.getId());
			e.setFirstName(pj.getFirstName());
			
			return data;
			}
		
	
	     // DELETE USER BY ID 
	    @Override
	    public Map<String,String> deleteuserbyid(Integer id) {
		Map<String,String> map= new HashMap<String,String>();
		
		 try {
				Entty emp  = new Entty();
			      emp.getId();
			      rep.deleteById(id);
				  map.put("Message","success");
				  
				  } 
		 catch (Exception e) {
				System.out.print(e.getMessage());
				map.put("Message","failure");
				        }
	          return map;
			}
	
      //CREATING USER DATA USING PAGINATION 
	@Override
	public PagingContent createContent(PagingContent pagingcontent)
	    {
		     // convert DTO to entity
		   Entty en = mapToEntity(pagingcontent);
		   Entty newentty  = rep.save(en);

	        // convert entity to DTO 
	        PagingContent postResponse = mapToDTO(newentty);
	        
	        return postResponse;
	        }
	
	
	private Entty mapToEntity(PagingContent pagingContent) {
		
		   Entty ent = new Entty();
		   
		    ent.setFirstName(pagingContent.getFirstName());
			ent.setLastName(pagingContent.getLastName());
			ent.setEmail(pagingContent.getEmail());
			ent.setPhno(pagingContent.getPhno());
			ent.setAge(pagingContent.getAge());
			ent.setUserName(pagingContent.getUserName());
			ent.setFlag(false);
	        
	        return ent; 
	}

	 private PagingContent mapToDTO(Entty newentty) {
			// TODO Auto-generated method stub
			PagingContent pagingcontent = new PagingContent();
			
			pagingcontent.setId(newentty.getId());
			pagingcontent.setFirstName(newentty.getFirstName());
			pagingcontent.setLastName(newentty.getLastName());
			pagingcontent.setEmail(newentty.getEmail());
			pagingcontent.setAge(newentty.getAge());
			pagingcontent.setPhno(newentty.getPhno());
			pagingcontent.setUserName(newentty.getUserName());
			pagingcontent.setFlag(false);
			return pagingcontent;
			
		}

     //PAGINATION and sorting (TO DISPLAY ONLY CONTENT,TOTAL_NO_ELEMENTS,TOTAL_NO_PAGES)
	   @Override
	   public PagingReponse getalldetails (Integer pageNumber, Integer pageSize, String sortBy, String sortDirection){
		
		//Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
	                //: Sort.by(sortBy).descending();   since value of local variable is not used
           
			
		Pageable pageable = PageRequest.of(pageNumber, pageSize,Sort.by(sortBy));

        Page<Entty> posts = prep.findAll(pageable);
		// TODO Auto-generated method stub
        
         List<Entty>getdata=posts.getContent();
         
         //CHECK
         List<PagingContent> content= getdata.stream().map( en-> mapToDTO(en)).collect(Collectors.toList());
         
         PagingReponse pagingreponse = new PagingReponse();
         
         pagingreponse.setTotalElements(posts.getNumberOfElements());
         pagingreponse.setTotalPages(posts.getTotalPages());
         pagingreponse.setContent(content);
         
         return pagingreponse;

         }
	
              //FILTER BY FIRSTNAME  AND LASTNAME USING PAGINATION
	            @Override
				public Page<Entty> getfirstname(String firstName, String lastName, Integer pageNumber,Integer pageSize) {
					Pageable pageable= PageRequest.of(pageNumber, pageSize);
					Page<Entty> page= rep.gettheName(firstName, lastName, pageable);
					return page;
				}

	            
	            
	         //CREATING ONE TO MANY 
			 @Override
			  public RequestOnetoManyPojo getdetails(RequestOnetoManyPojo requestOnetoManyPojo) {
				try {
				 Entty entty = new Entty(); 
				 entty.setFirstName(requestOnetoManyPojo.getFirstName());
				 entty.setLastName(requestOnetoManyPojo.getLastName());
				 entty.setEmail(requestOnetoManyPojo.getEmail());
				 entty.setAge(requestOnetoManyPojo.getAge());
				 entty.setUserName(requestOnetoManyPojo.getUserName());
				 entty.setPhno(requestOnetoManyPojo.getPhno());
				
				
				 // List<PojoAddress> list = requestOnetoManyPojo.getAddress();
				    
				
				 // List<PojoAddress> list = requestOnetoManyPojo.getAddress();  since value of local variable is not used
            
								 
				  PojoAddress addre = new PojoAddress ();
				
				  rep.save(entty); 
				
				  Integer id = rep.getempId(requestOnetoManyPojo.getUserName());

				  AddressEntity add1 = new AddressEntity();	  // 1st data for address
				
				  add1.setCity(addre.getCity());
				  add1.setCountry(addre.getCountry());
			      add1.setState(addre.getState());
			      add1.setPostalCode(addre.getPostalCode());
			      add1.setEmpId(id);
			     
			      AddressEntity add2 = new AddressEntity();	  //2nd data for address
					
				  add2.setCity(addre.getCity());
				  add2.setCountry(addre.getCountry());
			      add2.setState(addre.getState());
			      add2.setPostalCode(addre.getPostalCode());
			      add2.setEmpId(id);

			      List<AddressEntity>address = new ArrayList<AddressEntity>();
			      address.add(add1);
			      address.add(add2);

			      arep.saveAll(address); 
			      
			      System.out.println("message:success");
				}
				 catch (Exception e) {
				      System.out.print("message:failure");
				    
			    }

			 return requestOnetoManyPojo;
				
				}


//			@Override
//			public Map<String, String> Storedata(MultipartFile file) {
//			Map<String,String>m1 = new HashMap<String,String>(); 
//			try {
//				
//				EmpImg img = new EmpImg();
//				
//				 img.setName(file.getOriginalFilename());
//                 img.setType(file.getContentType());
//                 img.setImage(ImageUtil.compressedbyte(file.getBytes()));
//                     
//                 imgRepository.save(img);
//               
//               m1.put("Message","Success");
//				
//			}
//				
//				
//			 catch (Exception e) {
//	                System.out.print(e.getMessage());
//		           m1.put("Message","Failure");
//                   }
//				
//				return m1;
//			}
//
//
//			@Override
//			public Map<String, Object> getimagebyid(Integer id) {
//				Map<String,Object> m2 =  imgRepository.getdata(id);
//				return m2; 
//			}
//
//
//			@Override
//			public Map<String, String> Storedata(MultipartFile file, String data) {
//				// TODO Auto-generated method stub
//				return null;
//			}


			
			 
			 
		@Override
		public Map<String, String> storedata(MultipartFile file,String data) {
			
			Map<String,String> map = new HashMap<String,String>();
			
			try {
				Entty emp = new Entty();
				Entty courseEntity = mapper.readValue(data, Entty.class);
				
				         emp.setAge( courseEntity.getAge());
				         emp.setFirstName( courseEntity.getFirstName());
						 emp.setLastName( courseEntity.getLastName());
						 emp.setEmail( courseEntity.getEmail());
		                 emp.setUserName( courseEntity.getUserName());
						 emp.setPhno( courseEntity.getPhno());
						
						 rep.save(emp); 
						 
				  Integer id = rep.getemp_Id(emp.getUserName());
				  
					
		          ImageEntity imageEntity = new ImageEntity ();
                  
                  imageEntity.setName(file.getOriginalFilename());
                  imageEntity.setType(file.getContentType());
                  imageEntity.setImage(ImageUtil.compressedbyte(file.getBytes()));
                  imageEntity.setEmpId(id);
                  
                  irep.save(imageEntity);
                  
                  map.put("Message","Success");
                  
                  }
                    catch (Exception e) {
	                System.out.print(e.getMessage());
		           map.put("Message","Failure");
                      }
				return map;
						}


@Override
public EmpImgResponse getimagebyid(Integer id) {
	 EmpImgResponse imgResponse = new  EmpImgResponse();
	 
	 Map<String,Object>dataEmp =rep.getEmpDetailsbyid(id);    
	 
	 Map<String,Object>dataImg =rep.getEmpImgById(id);
	  
	 try {
		 
		  imgResponse.setFirstName(String.valueOf(dataEmp.get("first_Name")));   
		  imgResponse.setUserName(String.valueOf(dataEmp.get("user_Name")));
		  imgResponse.setLastName(String.valueOf(dataEmp.get("last_Name")));
		  imgResponse.setEmail(String.valueOf(dataEmp.get("email")));
		  imgResponse.setPhno(String.valueOf(dataEmp.get("phno")));
		  imgResponse.setId(Integer.parseInt(String.valueOf(dataEmp.get("id"))));
		  imgResponse.setAge(Integer.parseInt(String.valueOf(dataEmp.get("age"))));
		  
		  imgResponse.setImadegata(dataImg);
	 
	 }
	 
	 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 return imgResponse ;
}


	
			}
    
//Storing the image 
//			@Override
//			public Map<String, String> storeimage(ImageDto idto) {
//				Map<String,String> map = new HashMap<String,String>();
//				
//				try {
//					ImageEntity img = new ImageEntity(); 
//					
//					
//					img.setId(idto.getId());
//					img.setName(idto.getName());
//					img.setType(idto.getType());
//					img.setImage(idto.getImage());
//					
//					irep.save(img);
//					
//					map.put("message", "image saved");
//				}
//				
//				catch (Exception e) {
//				      System.out.print(e.getMessage());
//		 		    map.put("Message","image saving failed");
//				}
//				return map;
//			 
//	          @Override
//				public List<Entty> getfirstname(String first_Name) {
//				List<Entty> l = rep.gettheName(first_Name);
//					return l;
//				}


			
