package spring.com.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.com.dto.NewDTO;
import spring.com.output.newOutput;
import spring.com.service.Inewservice;



@CrossOrigin
@RestController

public class NewApi {
	
	@Autowired
	private Inewservice newservice;
	
	@GetMapping(value = "/new")
	public newOutput showNew(@RequestParam("page") int page,
							 @RequestParam("limit") int limit) {
		newOutput result = new newOutput();
		result.setPage(page);
		Pageable pageable = new PageRequest(page - 1, limit);
		result.setListResult(newservice.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (newservice.totalIteam()) / limit));
		return result;
	}

	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newservice.save(model);
	}
	
	@PutMapping(value = "/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model , @PathVariable("id")long id) {
		model.setId(id);
		return newservice.save(model);
	}
	
	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody long[] ids) {
		newservice.delete(ids);
		
	}
}
