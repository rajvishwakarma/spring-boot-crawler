package com.example.service;

import com.example.response.CrawlResponse;

public interface ICrawlService {

	CrawlResponse crawlResource(String link);

}
