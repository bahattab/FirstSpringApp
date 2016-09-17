package in.mytechblog.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mytechblog.spring.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	
}
