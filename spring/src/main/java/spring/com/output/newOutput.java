package spring.com.output;

import java.util.ArrayList;
import java.util.List;

import spring.com.dto.NewDTO;

public class newOutput {
	private int  page;
	private int  totalPage;
	private List<NewDTO> listResult = new ArrayList<>();
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<NewDTO> getListResult() {
		return listResult;
	}
	public void setListResult(List<NewDTO> listResult) {
		this.listResult = listResult;
	}
	}
