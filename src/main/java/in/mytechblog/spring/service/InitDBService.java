package in.mytechblog.spring.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mytechblog.spring.entity.Blog;
import in.mytechblog.spring.entity.Item;
import in.mytechblog.spring.entity.Role;
import in.mytechblog.spring.entity.User;
import in.mytechblog.spring.repository.BlogRepository;
import in.mytechblog.spring.repository.ItemRepository;
import in.mytechblog.spring.repository.RoleRepository;
import in.mytechblog.spring.repository.UserRepository;

@Transactional
@Service
public class InitDBService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private ItemRepository itemRepository;

	@PostConstruct
	public void init() {

		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		roleRepository.save(userRole);
		
		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);
		
		User admin = new User();
		admin.setName("admin");
		admin.setPassword("admin");
		List<Role> roles = new ArrayList<Role>();
		roles.add(adminRole);
		roles.add(userRole);
		admin.setRoles(roles);
		userRepository.save(admin);
		
		Blog blogJavaVids = new Blog();
		blogJavaVids.setName("JavaVids");
		blogJavaVids.setUrl("http://feed.feedburner.com/javavids?format=xml");
		blogJavaVids.setUser(admin);
		blogRepository.save(blogJavaVids);
		
		Item item1 = new Item();
		item1.setBlog(blogJavaVids);
		item1.setTitle("First");
		item1.setLink("http://javavids.com");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogJavaVids);
		item2.setTitle("Second");
		item2.setLink("http://javavids.com");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
	}

}
