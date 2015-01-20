/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="Direcciones")
public class Address {
    
    @Id
    private ObjectId id =new ObjectId();
    
    @Field("nombre")
    private String name;
    
    @Field("numero")
    private int number;
    
    public Address(String name,int number){
        
        this.name=name;
        this.number=number;
    }
    
    @Override
    public String toString() {
        return String.format(
                "Address[id=%s, name='%s', number='%s']",
                id, name, number);
    }
    
}
