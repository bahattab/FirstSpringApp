package in.mytechblog.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mytechblog.spring.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	
}
