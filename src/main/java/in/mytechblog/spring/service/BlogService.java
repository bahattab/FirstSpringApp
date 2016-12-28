package in.mytechblog.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mytechblog.spring.entity.Blog;
import in.mytechblog.spring.entity.User;
import in.mytechblog.spring.repository.BlogRepository;
import in.mytechblog.spring.repository.UserRepository;

@Service
public class BlogService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;

	public void save(Blog blog, String name) {
		User user = userRepository.findByname(name);
		blog.setUser(user);
		blogRepository.save(blog);
	}
}
