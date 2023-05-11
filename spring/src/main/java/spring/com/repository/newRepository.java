package spring.com.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import spring.com.entity.NewEntity;

public interface newRepository extends JpaRepository<NewEntity, Long> {

	
}
