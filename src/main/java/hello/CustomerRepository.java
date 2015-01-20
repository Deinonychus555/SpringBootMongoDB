package hello;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface CustomerRepository  {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    public List<Customer> findAll();
    
    public List<Customer> findByFirstNameOnlyAge(String firstName);
    public void deleteAll();
    public void save(Customer customer);
    

}
