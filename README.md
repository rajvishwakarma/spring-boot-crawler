# Spring Boot Crawler!

This document is entitled to list out the detailed aspects of Web based Crawler Spring boot Application. The application would deals with crawling a web URL and showing the results as a simple structured site map showing links to other pages under the same domain, links to external URLs and links to static content such as images for each respective page.


# Run the application

For the impatient...

```mermaid
  git clone https://github.com/rajvishwakarma/sprint-boot-crawler.git
  cd sprint-boot-crawler
  mvn clean compile 
  mvn package
  mvn spring-boot:run
```

# More possible solution to the problem

A more possible approach could have been to create Background Jobs to crawl the resources in background and updating the links and resources in database. Each time a link is added to crawl it will process inline for the first time but later on it can be done in background. It will crawl through the complete website and collect all the resources and links. Whenever the same link is provided to crawl, the results can be fetched directly from the database and save the time to crawl the website again and again. This can be an optimized way of doing things.    
