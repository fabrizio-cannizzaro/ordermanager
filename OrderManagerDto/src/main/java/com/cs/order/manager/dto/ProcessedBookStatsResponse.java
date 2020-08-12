package com.cs.order.manager.dto;

import com.cs.order.manager.dto.inner.ProcessedBookStatsDto;

import java.util.List;

/**
 * @author fabrix
 */
public class ProcessedBookStatsResponse {

	private List<ProcessedBookStatsDto> processedBookStatDtos;

	public ProcessedBookStatsResponse() {
	}

	public ProcessedBookStatsResponse(List<ProcessedBookStatsDto> processedBookStatDtos) {
		this.processedBookStatDtos = processedBookStatDtos;
	}

	public List<ProcessedBookStatsDto> getProcessedBookStatDtos() {
		return processedBookStatDtos;
	}

	public void setProcessedBookStatDtos(List<ProcessedBookStatsDto> processedBookStatDtos) {
		this.processedBookStatDtos = processedBookStatDtos;
	}

	@Override
	public String toString() {
		return "ProcessedBookStatsResponse{" +
			"processedBookStatDtos=" + processedBookStatDtos +
			'}';
	}
}
