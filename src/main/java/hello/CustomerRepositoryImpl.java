/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;



@Configuration
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    
    @Autowired
    MongoTemplate mongoTemplate;
    
 
    
    @Override
    public Customer findByFirstName(String name){
       
        Criteria criteria = Criteria.where("name").is(name);
        return mongoTemplate.findOne(Query.query(criteria), Customer.class);
    }
    
    @Override
    public List<Customer> findByLastName(String lastName){
        
        Criteria criteria=Criteria.where("lastName").is(lastName);
        return mongoTemplate.find(Query.query(criteria), Customer.class);
    }    
    
    @Override
    public List<Customer> findAll(){
        return mongoTemplate.findAll(Customer.class);
    }
    
   @Override
   // Devuelve los customers cuyo nombre coincidan con el dado y que tengan 27 años
   public List<Customer> findByFirstNameOnlyAge(String firstName){
       
       Criteria criteria = Criteria.where("firstName").is(firstName);
       return mongoTemplate.find(Query.query(criteria), Customer.class);
   }
   
    @Override
    public void deleteAll(){
        
        mongoTemplate.dropCollection(Customer.class);
    }
    
    @Override
    public void save(Customer customer){
        
        mongoTemplate.save(customer);
    }
    
  
}
