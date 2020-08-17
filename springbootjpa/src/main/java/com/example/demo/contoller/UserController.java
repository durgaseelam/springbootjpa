package com.example.demo.contoller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.UserRepo;
import com.example.demo.model.User;
import com.example.demo.exception.ResourceNotFoundException;

@RestController
//@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepo repo;

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("userlogin.jsp");
		return mv;
	}

	@PostMapping("/user")
	public User addUser(@Valid @RequestBody User user) {
		repo.save(user);
		return user;
	}

	@RequestMapping("/getUser")
	public ModelAndView getUser(@RequestParam int userId) {
		ModelAndView mv = new ModelAndView("showuser.jsp");
		User user = repo.findById(userId).orElse(new User());
		mv.addObject(user);
		return mv;
	}

//	@RequestMapping("/delete")
//	public ModelAndView deleteUser(@RequestParam int userId) {
//		ModelAndView mv=new ModelAndView("deletesuccess.jsp");
//		User user = repo.findById(userId).orElse(new User());
//		repo.delete(user);		
//		return mv;
//	}
//	
//	@RequestMapping("/toupdate")
//	public ModelAndView updateUser(@RequestParam int userId) {
//		ModelAndView mv=new ModelAndView("updateuser.jsp");
//		User user = repo.findById(userId).orElse(new User());		
//		mv.addObject(user);
//		return mv;
//	}

	@RequestMapping("/deleteupdate")
	public ModelAndView deleteUpdateUser(User user) {
		ModelAndView mv = new ModelAndView("updatesuccess.jsp");
		repo.save(user);
		mv.addObject(user);
		return mv;
	}

	@GetMapping(path = "/users", produces = { "application/json" })
	// @ResponseBody
	public List<User> getUsers() {

		return repo.findAll();
	}

	@RequestMapping("/user/{id}")
	@ResponseBody
	public User getUserData(@PathVariable("id") int id) {
		//return repo.findById(id);
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" User not found with given id: " + id));
	}

//	@DeleteMapping("/user/{id}")	
//	public String deleteUser(@PathVariable("id")int id) {
//		User user = repo.getOne(id);
//		repo.delete(user);
//		return "deleted";
//	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
		User existingUser = this.repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" User not found with given id: " + id));
		this.repo.delete(existingUser);
		return ResponseEntity.ok().build();

	}

	@PutMapping(path = "/user", consumes = { "application/json" })
	public User updateUser(@Valid @RequestBody User user) {
		repo.save(user);
		return user;
//		User existing=this.repo.findById(id).orElseThrow(( )-> new ResourceNotFoundException(" User not found with given id: "+id));
//		existing.setFirstName(user.getFirstName());
//		existing.setFirstName(user.getLastName());
//		existing.setFirstName(user.getMiddleName());
//		this.repo.save(existing);

	}
}
