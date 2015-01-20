package hello;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface CustomerRepository extends MongoRepository<Customer, ObjectId> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
    
    // Devuelve los customers cuyo nombre coincidan con el dado y que tengan 27 años
    @Query(value = "{ nombre:?0 ,edad: 27}")
    public List<Customer> findByFirstNameOnlyAge(String firstName);

}
