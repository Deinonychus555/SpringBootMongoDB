package hello;

import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document (collection="Tiendas")
public class Shop {

    @Id
    private ObjectId id=  new ObjectId();
   
    @Field("nombre")
    private String name;
    
    
    /*
    
    // ¡Falla al hacer referencias bidireccionales!
    
    @DBRef
    private Customer customer;
    */
    @DBRef
    private List<Customer> customers=new ArrayList();;
    

    public Shop() {}

    public Shop(String name) {
        this.name = name;
        
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    
    
    
    public List<Customer> getCustomers() {
        return customers;
    }
    
    

    @Override
    public String toString() {
        return String.format(
                "shop[id=%s, name='%s']",
                id, name);
    }

}

