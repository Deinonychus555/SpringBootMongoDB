package hello;

import java.util.List;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface ShopRepository extends MongoRepository<Shop, String> {

    public Shop findByName(String name);
   // public List<Customer> findByLastName(String lastName);

}
