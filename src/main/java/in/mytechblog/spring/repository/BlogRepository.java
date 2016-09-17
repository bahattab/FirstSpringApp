package in.mytechblog.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mytechblog.spring.entity.Blog;
import in.mytechblog.spring.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);
}
