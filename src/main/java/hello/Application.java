// http://scaramoche.blogspot.com.es/2014/05/rocking-with-mongodb-on-spring-boot.html
// http://www.petrikainulainen.net/programming/spring-framework/creating-a-rest-api-with-spring-boot-and-mongodb/
// http://egunaytech.tumblr.com/post/83406443391/a-complete-tutorial-for-spring-boot-angularjs
package hello;

import hello.Address;
import hello.AddressRepository;
import hello.Customer;
import hello.CustomerRepository;
import hello.Shop;
import hello.ShopRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.PropertySource;

import org.springframework.data.mongodb.core.MongoTemplate;


//@ComponentScan(basePackages ="com.domain")
@ComponentScan
@Configuration
@EnableAutoConfiguration
// Indicamos el archivo con los datos de la conexiión de mongo.
@PropertySource("file:/home/juanan/NetBeansProjects/gs-accessing-data-mongodb/complete/src/main/resources/app-config.properties")
//@PropertySource(value = "classpath:application.properties")
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customer_repository;
        
        @Autowired
	private ShopService shop_service;
        
        @Autowired
	private AddressRepositoryImpl address_repository;
        
        @Autowired
        private MongoTemplate mongotemplate;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

                
            
		customer_repository.deleteAll();
                address_repository.deleteAll();
                shop_service.deleteAllShops();
                
                Customer c1=new Customer("Alice", "Smith",27);
                Customer c2=new Customer("Bob", "Smith",45);
                Customer c3=new Customer("Juan", "Sanchez",32);
                Customer c4=new Customer("Elena", "Sanchez",27);
                
                Address a1=new Address("Anacardo",7);
                Address a2=new Address("Avellana",3);
                Address a3=new Address("Almendra",25);
                
                
                Shop s1 =new Shop("Zara");
                Shop s2 =new Shop("Mango");
                
                
                c1.setAddress(a1);
                c2.setAddress(a2);
                c3.setAddress(a3);
                c4.setAddress(a2);
                
                c1.getShops().add(s2);
                c1.getShops().add(s1);
                c2.getShops().add(s1);
                c3.getShops().add(s2);
                c4.getShops().add(s1);
                c4.getShops().add(s2);
                
                
                s2.getCustomers().add(c1);
                s2.getCustomers().add(c3);
                s2.getCustomers().add(c4);
                s1.getCustomers().add(c1);
                s1.getCustomers().add(c2);
                s1.getCustomers().add(c4);
                System.out.println(c1);
                System.out.println(c2);
                System.out.println(c3);
                System.out.println("");
                
                System.out.println(a1);
                System.out.println(a2);
                System.out.println(a3);
                System.out.println("");
                
                System.out.println(s1);
                System.out.println(s2);
                System.out.println("");
                
               

		// save a couple of customers
		customer_repository.save(c1);
		customer_repository.save(c2);
                customer_repository.save(c3);
                customer_repository.save(c4);
                
                // save a couple of addresses
		address_repository.save(a1);
		address_repository.save(a2);
                address_repository.save(a3);
                
                // save a couple of shops
		shop_service.saveShop(s1);
		shop_service.saveShop(s2);
                
                // Familia Blanco/Florencia
                Customer c5=new Customer("Sandra", "Florencia",27);
                mongotemplate.save(c5);
                Customer c6=new Customer("Paco", "Florencia",67);
                mongotemplate.save(c6);
                Customer c7=new Customer("Sandra", "Florencia",15);
                mongotemplate.save(c7);
                Customer c8=new Customer("Sandra", "Blanco",63);
                mongotemplate.save(c8);
                
               
		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customer_repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(customer_repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : customer_repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
                
                System.out.println("Customers found with findByNameOnlyAge('Sandra'):");
		System.out.println("--------------------------------");
		for (Customer customer : customer_repository.findByFirstNameOnlyAge("Sandra")) {
			System.out.println(customer);
		}
                
                System.out.println("Addresse found with findByName('Anacardo'):");
		System.out.println("--------------------------------");
		System.out.println(address_repository.findByName("Anacardo"));
		

	}

}
