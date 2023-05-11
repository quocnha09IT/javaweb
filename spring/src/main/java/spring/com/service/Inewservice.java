package spring.com.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import spring.com.dto.NewDTO;

public interface Inewservice {

	NewDTO save(NewDTO newDTO);
	void delete(long[] ids);
	List<NewDTO> findAll(Pageable pageable);	
	int totalIteam();
}
