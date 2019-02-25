package com.example.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * CrawlResponse to map the response
 * 
 * @author RV
 *
 */
@Data
@ToString(callSuper = false)
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CrawlResponse {
	
	private String message;
	private Set<String> internalResources;
	private Set<String> externalResources;
	private Set<String> staticResources;
	private Set<String> otherResources;
	
	public CrawlResponse(String message, Set<String> internalResources, Set<String> externalResources, 
			Set<String> staticResources, Set<String> otherResources) {
		this.message = message;
		this.internalResources = internalResources;
		this.externalResources = externalResources;
		this.staticResources = staticResources;
		this.otherResources = otherResources;
	}

	public CrawlResponse(String message) {
		this.message = message;
	}
	
}
