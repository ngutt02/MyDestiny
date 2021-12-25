package com.pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.pack.entity.Customer;
import com.pack.entity.Order;
import com.pack.repository.OrderRepository;



@SpringBootApplication
public class DataJpaOneToManyApplication implements CommandLineRunner {


	@Autowired
	ApplicationContext container;
	public static void main(String[] args) {
		SpringApplication.run(DataJpaOneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*System.out.println("From inside run method");
		 Set<Order> orders=new HashSet<Order>();
		CustomerRepository custRepo=(CustomerRepository)container.getBean("customerRepository");
		System.out.println("customerRepo object is created");
		Customer customer=new Customer(110,"NEWTON",8770371399L);
		Order order1=new Order(104,"BLUETOOTH",2000.0);
		Order order2=new Order(110,"HEADPHONE",3000.0);
		Order order3=new Order(111,"CHARGER",600.0);
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		customer.setOrders(orders);
		custRepo.save(customer);
*/
		 

		/*	Delete Operation*/

		/*OrderRepository orderRepo=(OrderRepository)container.getBean("orderRepository");		 
		orderRepo.deleteById(109);
		System.out.println("order deleted successfully");
		*/ 

		/* Select Operation*/
		/*OrderRepository orderRepo=(OrderRepository)container.getBean("orderRepository");
		Optional<Order> opt=orderRepo.findById(105);
		Order order=opt.get();
		System.out.println(order);
		 */
		/*CustomerRepository custRepo=(CustomerRepository)container.getBean("customerRepository");
		Optional<Customer> opt=custRepo.findById(102);
		Customer customer=opt.get();
		System.out.println(customer);
       */
		
		/*Insert operation*/
		/*CustomerRepository custRepo=(CustomerRepository)container.getBean("customerRepository");
		 Set<Order> orders=new HashSet<Order>();
		Customer customer=new Customer(102,"james",8770371399L);
		Order order1=new Order(101,"BAT",2000.0);
		Order order2=new Order(102,"BALL",30.0);
		Order order3=new Order(103,"STUMPS",600.0);
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		customer.setOrders(orders);
		custRepo.save(customer);
*/
                     
		
		
		
		
		
		
		
		
		
		
		


		/*---------------------------Many-TO-One---------------------------------*/

		OrderRepository orderRepo=(OrderRepository)container.getBean("orderRepository");
		/*-----------Insert Operation--------*/
		Customer customer=new Customer(101,"scott",9893787401L);
		Order order1=new Order(91911,"FREEZ",20000.0);
		Order order2=new Order(91922,"LAPTOP",30000.0);
		Order order3=new Order(91933,"BAG",600.0);
		order1.setCustomer(customer);		
		order2.setCustomer(customer);
		order3.setCustomer(customer);
		orderRepo.save(order1);
		orderRepo.save(order2);
		orderRepo.save(order3);
		System.out.println("successfully executed Many To One");
		 
		/*--------------Delete Operation-------------*/
		/* OrderRepository orderRepo=(OrderRepository)container.getBean("orderRepository");
		orderRepo.deleteById(91933);
		System.out.println("successfully child object is delete");
		 */
		/*---------------Select Operation-------------*/
		/*Optional<Order> order=orderRepo.findById(91933);
		System.out.println(order);
		 */

		/*-----------------------Bi-Directional One-To-Many------------------*/


		//OrderRepository orderRepo=(OrderRepository)container.getBean("orderRepository");
		//CustomerRepository custRepo=(CustomerRepository)container.getBean("customerRepository");
		//orderRepo.deleteById(108);
		/*Optional<Customer> opt= custRepo.findById(103);
		 Customer order=opt.get();
		  System.out.println("order:"+order);
		System.out.println("successfully child object is delete");
		 */


		/*Optional<Customer> opt=custRepo.findById(102);
		Customer customer=opt.get();
		System.out.println("customer:"+customer);
		 */





		/*Customer customer=new Customer();
		customer.setCustId(104);
		customer.setCustName("clerk");
		customer.setMobile(9301008388L);
		Order order=new Order();
		order.setOrderId(109);
		order.setItemName("Pencil");
		order.setPrice(5.0);
		System.out.println("Order and Customer Object is created");
	  boolean flag=custRepo.existsById(customer.getCustId());
	  System.out.println("after checking customer id:"+flag);
	  if(flag==true)
	  {
		  order.setCustomer(customer);
		  orderRepo.save(order);  
	  }else {
		  System.out.println("inside else part");
	  order.setCustomer(customer);
	 // System.out.println("after setting customer object to oder object");
	  orderRepo.save(order);
		order.setCustomer();

		orderRepo.save(order);

	  }
	  System.out.println("order saved successfully");

		 */	}

}
