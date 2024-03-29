package in.mytechblog.spring.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.mytechblog.spring.entity.Blog;
import in.mytechblog.spring.entity.User;
import in.mytechblog.spring.service.BlogService;
import in.mytechblog.spring.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private BlogService blogService;

	@ModelAttribute("user")
	public User constructUser(){
		 return new User();
	}
	
	@ModelAttribute("blog")
	public Blog constructBlog(){
		 return new Blog();
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
		return "redirect:/register.html";
	}
	
	@RequestMapping(value="/account")
	public String account(Model model, Principal principal){
		String name = principal.getName();
		model.addAttribute("user",userService.findOneWithBlogs(name));
		return "user-detail";
	}
	
	@RequestMapping(value="/account", method=RequestMethod.POST )
	public String doAddBlog(@ModelAttribute("blog") Blog blog, Principal principal){
		String name = principal.getName();
		blogService.save(blog,name);
		return "redirect:/account.html";
	}

}

