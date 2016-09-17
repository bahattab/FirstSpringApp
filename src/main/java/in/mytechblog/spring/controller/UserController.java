package in.mytechblog.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.mytechblog.spring.entity.User;
import in.mytechblog.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User construct(){
		 return new User();
	}
	
	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String user(Model model, @PathVariable int id){
		//model.addAttribute("user", userService.findOne(id));
		model.addAttribute("user", userService.findOneWithBlogAndItem(id));
		return "user-detail";
	}
	
	@RequestMapping("/register")
	public String registerUser(Model model){
		return "user-register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST )
	public String doRegisterUser(@ModelAttribute("user") User user){
		userService.save(user);
		return "user-register";
	}
	
	
}
