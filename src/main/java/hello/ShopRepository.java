package hello;

import java.util.List;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Configuration
@Repository
public interface ShopRepository extends MongoRepository<Shop, String> {

    public Shop findByName(String name);
    
    // Las anotaciones de querys son para las interfaces (si no se implementa la función)
    @Query(value = "{nombre:?0, clase: 'small'}")
    // La query actua de filtro.
    // nombre:?0 indica que el campo nombre tiene que coincidir con el que se pasa como argumento.
    // clase: 'small' actua de filtro (al ser string va entre comillas simples)
    public List<Shop> findByNameOnlyType(String name);

}
