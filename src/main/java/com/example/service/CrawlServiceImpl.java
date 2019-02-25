package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.response.CrawlResponse;
import com.example.utils.CrawlingUtils;

/**
 * CrawlServiceImpl deals with implementations and business logic
 * 
 * @author rv
 *
 */
@Service
public class CrawlServiceImpl implements ICrawlService {

	@Autowired
	CrawlingUtils crawlingUtils;
	
	@Override
	public CrawlResponse crawlResource(String link) {
		
		return crawlingUtils.crawlResource(link);
	}

}
