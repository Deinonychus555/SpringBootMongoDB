package hello;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class ShopService  {

    @Autowired
    ShopRepository shop_repository;
    
    public Shop getShop (String name){
        return shop_repository.findOne(name);
    }
    
    public List<Shop> getShopsOnlyType(String name){
        
        return shop_repository.findByNameOnlyType(name);
    }
    
    public void deleteAllShops (){
        shop_repository.deleteAll();
    } 
    
    public void saveShop (Shop shop){
        shop_repository.save(shop);
    }
   

}
