package in.mytechblog.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mytechblog.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
}
