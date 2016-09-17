package in.mytechblog.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import in.mytechblog.spring.entity.Blog;
import in.mytechblog.spring.entity.Item;
import in.mytechblog.spring.entity.User;
import in.mytechblog.spring.repository.BlogRepository;
import in.mytechblog.spring.repository.ItemRepository;
import in.mytechblog.spring.repository.UserRepository;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private ItemRepository itemRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}

	public User findOneWithBlogAndItem(int id) {
		User user = userRepository.findOne(id);
		List<Blog> blogs = blogRepository.findByUser(user);
		for(Blog blog: blogs){
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}

	public void save(User user) {
		userRepository.save(user);
	}
}
