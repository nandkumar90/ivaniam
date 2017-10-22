package com.arial.ivanium.dto;

import java.util.List;

public class StandardNewsDTO {

	private List<NewsDTO> data = null;

	private Integer result_count;

	private Integer page_size;

	private Integer current_page;

	private Integer total_pages;

	private Integer api_call_credits;

	public List<NewsDTO> getData() {
		return data;
	}

	public void setData(List<NewsDTO> data) {
		this.data = data;
	}

	public Integer getResult_count() {
		return result_count;
	}

	public void setResult_count(Integer result_count) {
		this.result_count = result_count;
	}

	public Integer getPage_size() {
		return page_size;
	}

	public void setPage_size(Integer page_size) {
		this.page_size = page_size;
	}

	public Integer getCurrent_page() {
		return current_page;
	}

	public void setCurrent_page(Integer current_page) {
		this.current_page = current_page;
	}

	public Integer getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}

	public Integer getApi_call_credits() {
		return api_call_credits;
	}

	public void setApi_call_credits(Integer api_call_credits) {
		this.api_call_credits = api_call_credits;
	}

}
