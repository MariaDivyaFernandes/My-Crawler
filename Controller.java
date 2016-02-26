import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Controller {

	public static void main(String[] args) {
		int maxDepthofCrawling = 9;
		int maxPagesToFetch = 5000;
		int politenessDelay = 200;
	//	String userAgentString = "crawler";
		
		// TODO Auto-generated method stub
		 String crawlStorageFolder = "H:\\Semester 2\\Information Retrieval\\Assignment2\\IR\\crawl";
		 int numberOfCrawlers = 15;
		 CrawlConfig config = new CrawlConfig();
		 config.setCrawlStorageFolder(crawlStorageFolder);
		 config.setMaxDepthOfCrawling(maxDepthofCrawling);
		 config.setMaxPagesToFetch(maxPagesToFetch);
		 config.setPolitenessDelay(politenessDelay);
		 config.setIncludeBinaryContentInCrawling(true);
		 config.setIncludeHttpsPages(true);
		// config.setUserAgentString(userAgentString);
		 /*
		 * Instantiate the controller for this crawl.
		 */
		 PageFetcher pageFetcher = new PageFetcher(config);
		 RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
		 RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
		 CrawlController controller = null;
		try {
			controller = new CrawlController(config, pageFetcher, robotstxtServer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 /*
		 * For each crawl, you need to add some seed urls. These are the first
		 * URLs that are fetched and then the crawler starts following links
		 * which are found in these pages
		 */
		controller.addSeed("http://dornsife.usc.edu/");
		 //controller.addSeed("http://dornsife.usc.edu/assets/sites/1/docs/admission/Major_Flyers/Philosophy_Politics_and_Law.pdf");
		 
		 /*
		 * Start the crawl. This is a blocking operation, meaning that your code
		 * will reach the line after this only when crawling is finished.
		 */
		 controller.start(MyCrawler.class, numberOfCrawlers);
		 System.out.println("fetches attempted:"+MyCrawler.attemptedFetch);
		 System.out.println("fetches succeeded:"+MyCrawler.successfulFetch);
		 System.out.println("fetches aborted:"+MyCrawler.abortedFetches);
		 System.out.println("fetches failed:"+MyCrawler.failedFetches);
		 System.out.println("Total URLs extracted:"+MyCrawler.totalUrlList.size());
		 System.out.println("unique URLs extracted:"+MyCrawler.uniqueUrlList.size());
		 System.out.println("unique URLs within school:"+MyCrawler.uniqueUrlListWithinSchool.size());
		 System.out.println("unique USC URLs outside school:"+MyCrawler.uniqueUrlListInUSC.size());
		 System.out.println("unique URLs outside USC:"+(MyCrawler.uniqueUrlList.size()- MyCrawler.uniqueUrlListWithinSchool.size()-MyCrawler.uniqueUrlListInUSC.size()));
		 System.out.println("Status Codes" + MyCrawler.statusCodeList);
		 System.out.println("File Size" + MyCrawler.sizeTypeMap);
		 System.out.println("Content Type" + MyCrawler.contentTypeList);
	}

}
