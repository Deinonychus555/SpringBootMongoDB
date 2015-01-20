/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import org.bson.types.ObjectId;
import org.springframework.context.annotation.Configuration;

@Repository
public interface AddressRepository {
    
    public Address findByName(String name);
    public List<Address> findByNumber(int number);
    public Address findByNameAndNumber(String name, int number);
    public void deleteAll();
    public void save(Address address);
    
}
