package spring.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.com.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	
	CategoryEntity findOneByCode(String code);

}
