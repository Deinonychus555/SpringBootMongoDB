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
public class AddressRepositoryImpl implements AddressRepository {
    
    @Autowired
    MongoTemplate mongoTemplate;
    
    @Override
    public Address findByName(String name){
       
        Criteria criteria = Criteria.where("name").is(name);
        return mongoTemplate.findOne(Query.query(criteria), Address.class);
    }
    
    @Override
    public List<Address> findByNumber(int number){
        
        Criteria criteria=Criteria.where("number").is(number);
        return mongoTemplate.find(Query.query(criteria), Address.class);
    }    
    
    
    @Override
    public Address findByNameAndNumber(String name, int number){
        
        Criteria criteria = Criteria.where("name").is(name).andOperator(Criteria.where("number").is(number));
	return mongoTemplate.findOne(Query.query(criteria), Address.class);
    }
    
    @Override
    public void deleteAll(){
        
        mongoTemplate.dropCollection(Address.class);
    }
    
    @Override
    public void save(Address address){
        
        mongoTemplate.save(address);
    }
}
