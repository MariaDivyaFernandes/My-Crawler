# My-Crawler
A crawler created by enhancing the crawler4j to crawl a particular seed website and print statistics about the crawled result.

==>crawler4j is an open source web crawler for Java which provides a simple interface for crawling the Web. Using it, we can setup a multi-threaded web crawler in few minutes.
1. Download the latest crawler4j-x.x.zip file (contains crawler4j-x.x.jar) where x represents the current revision major
and minor numbers from https://github.com/yasserg/crawler4j
2. The Download Zip button will download the crawler4j-master; unpacking the zip file provides the complete source.
You may also need the crawler4j dependencies, which can be found at
https://github.com/JamesOravec/SocialSpider/tree/master/lib/crawler4j-3.x-dependencies
3. Extract the contents of both zip files to a convenient folder. There are lots of jars in the dependency file, so you'll
probably want to put the extracted files into the same folder.



Following details are printed by the crawler output:

1. the URLs it attempts to fetch,in  a two column spreadsheet called fetch.csv.

2. the files it successfully downloads,in a four column spreadsheet called visit.csv

3. all of the URLs that were discovered and processed in some way; in a two column spreadsheet called url.csv.