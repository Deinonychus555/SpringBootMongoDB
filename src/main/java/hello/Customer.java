package hello;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="Clientes")
public class Customer {

    @Id
    private ObjectId id= new ObjectId();

    @Field(value="nombre")
    private String firstName;
    
    @Field("apellido")
    private String lastName;
    
    @Field("edad")
    private int age;
    
    @Field("direccion")
    @DBRef
    private Address address;
    
    @Field("tiendas")
    @DBRef
    private List<Shop> shops=new ArrayList();

  

    public Customer() {}

    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age=age;
    }

    public ObjectId getId() {
        return id;
    }

    

    public String getFirstName() {
        return firstName;
    }

   

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
    
    
  

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}

