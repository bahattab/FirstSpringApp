package in.mytechblog.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mytechblog.spring.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	
}
