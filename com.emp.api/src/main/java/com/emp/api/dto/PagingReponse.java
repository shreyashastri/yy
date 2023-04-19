package com.emp.api.dto;

import java.util.List;

public class PagingReponse {
	
	private List<PagingContent> content;
	private int totalPages;
    private int totalElements;

    List<PagingContent> getContent() {
		return content;
	}
    
	public void setContent(List<PagingContent> content) {
		this.content = content;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	public int getTotalElements() {
		return totalElements;
	}
	
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

	
	
}
