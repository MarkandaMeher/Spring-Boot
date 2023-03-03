package com.springboot.jpa;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.springboot.jpa.dao.UserRepository;
import com.springboot.jpa.entities.User;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJpaApplication.class, args);
		UserRepository bean = context.getBean(UserRepository.class);
		
//		User u1 = new User();
//		u1.setId(101);
//		u1.setName("ram");
//		u1.setCity("delhi");
//		User save = bean.save(u1);
//		System.out.println(save);
		
		//Creating User Objects
//		User u1 = new User();
//		u1.setName("rakesh");
//		u1.setCity("bihar");
//		User u2 = new User();
//		u2.setName("Logan");
//		u2.setCity("punjab");
//		
//		//saving single user
//		//User save = bean.save(u2);
//		
//		List<User> users = List.of(u1,u2);
//		//save multiple users
//		Iterable<User> saveAll = bean.saveAll(users);
//		saveAll.forEach(user->{
//			System.out.println(user);
//		});
		
		//update the user
		
//		Optional<User> optional = bean.findById(3);
//		User user = optional.get();
//		user.setName("Ankit Tiwari");
//		User result = bean.save(user);
//		System.out.println(result);
//		
//		System.out.println("Done!!!");
		
		//Get the data
		//findBId(id) - return Optional Containing your data
		//findall , more ..
//		Iterable<User> findAll = bean.findAll();
//		Iterator<User> iterator = findAll.iterator();
////		while (iterator.hasNext()) {
////			User user=iterator.next();
////			System.out.println(user);
////		}
//		findAll.forEach(user->{
//			System.out.println(user);
//		});
		
//		//Delete the user
//		bean.deleteById(2);
//		System.out.println("Deleted!!!");
//		
//		//Custom Querry not even have to write the Querry
//		List<User> findByName = bean.findByName("ram");
//		findByName.forEach(user->System.out.println(user));
//		
		
		List<User> allUser = bean.getAllUser();
		allUser.forEach(user->System.out.println(user));
		
		List<User> userByName = bean.getUserByName("ram");
		userByName.forEach(user->System.out.println(user));
		
	}

}
