package in.mytechblog.spring.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import in.mytechblog.spring.entity.Blog;
import in.mytechblog.spring.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findByBlog(Blog blog, Pageable pageable); // Pageable is used for pagination
}
