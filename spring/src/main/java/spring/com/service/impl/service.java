package spring.com.service.impl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import spring.com.converter.newConverter;
import spring.com.dto.NewDTO;
import spring.com.entity.CategoryEntity;
import spring.com.entity.NewEntity;
import spring.com.repository.CategoryRepository;
import spring.com.repository.newRepository;
import spring.com.service.Inewservice;

@Service
public class service implements Inewservice{

	@Autowired
	private newRepository NewRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired
	private newConverter NewConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId() != null) {
			NewEntity oldnew = NewRepository.findOne(newDTO.getId());
			newEntity = NewConverter.toEntity(newDTO, oldnew);
		}else {
			newEntity = NewConverter.toEntity(newDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		
		newEntity.setCategory(categoryEntity);
		newEntity = NewRepository.save(newEntity);
		return newConverter.toDTO(newEntity);	
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			NewRepository.delete(item);
		}
	}
/*	@Override
	public NewDTO update(NewDTO newDTO) {
		NewEntity oldnew = NewRepository.findOne(newDTO.getId());
		NewEntity newEntity = NewConverter.toEntity(newDTO, oldnew);
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = NewRepository.save(newEntity);
		
		return newConverter.toDTO(newEntity);
	}*/

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> result = new ArrayList();
		List<NewEntity> entities = NewRepository.findAll(pageable).getContent();
		for(NewEntity item: entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			result.add(newDTO);
		}
		return result;
	}

	@Override
	public int totalIteam() {
		
		return (int) NewRepository.count();
	}
}
