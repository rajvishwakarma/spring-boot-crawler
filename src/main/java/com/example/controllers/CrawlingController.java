package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.request.CrawlRequest;
import com.example.response.CrawlResponse;
import com.example.service.ICrawlService;
import com.example.utils.LoggerMessages;
import com.example.utils.RESTEndpointMapper;
import com.example.utils.UrlValidation;

/**
 * This CrawlingController deals the REST API serve the crawling feature
 *  
 * @author rv
 *
 */
@RestController
public class CrawlingController {
	
	Logger LOG = LoggerFactory.getLogger(CrawlingController.class);
	
	@Autowired
	ICrawlService crawlService;
	
	@Autowired
	UrlValidation urlValidation;
	
	/**
	 * This end-point is used to crawl the resource and generate all the external 
	 * and internal links with static content and all the other resource
	 * 
	 * @author RV
	 * @param 
	 * @return 
	 */
	@PostMapping(value = RESTEndpointMapper.CRAWL)
	public ResponseEntity<CrawlResponse> crawlResource(@RequestBody CrawlRequest crawlRequest){
		LOG.info("In CrawlingController : gettingResourceLinks with Request- "+crawlRequest.getLink());
		
		if(urlValidation.validateUrl(crawlRequest.getLink())){
			LOG.info("In CrawlingController : Invalid url- "+crawlRequest.getLink());
			return new ResponseEntity<CrawlResponse>(new CrawlResponse(LoggerMessages.INVALID_URL), HttpStatus.OK);
		}
		
		CrawlResponse response = crawlService.crawlResource(crawlRequest.getLink());

		LOG.info("In CrawlingController : "+LoggerMessages.CRAWL_SUCCESS);
		return new ResponseEntity<CrawlResponse>(response, HttpStatus.OK);
	}
}
