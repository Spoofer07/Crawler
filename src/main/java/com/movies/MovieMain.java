package com.movies;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.movies.model.Movie;
import com.movies.model.Product;

public class MovieMain {
	
	public static final String THE_URL_DEFAULT = "https://www.sat24.com/h-image.ashx?region=eu&time=202104290915&ir=False";
	public static final String THE_PATH = "C:\\Users\\MihaiDesktop\\Desktop\\nori\\java\\poza";
	
	public static final String URL_START = "https://www.sat24.com/h-image.ashx?region=eu&time=20210428";
	public static final String URL_END = "&ir=False";
	
	public static final String[] TIMES = {"0600", "0615", "0630", "0645", "0700", "0715", "0730", "0745", "0800", "0815", "0830", "0845",
			"0900", "0915", "0930", "0945", "1000", "1015", "1030", "1045", "1100", "1115", "1130", "1145", "1200", "1215", "1230", "1245"
			, "1300", "1315", "1330", "1345", "1400", "1415", "1430", "1445", "1500", "1515", "1530", "1545", "1600", "1615", "1630", 
			"1645", "1700", "1715", "1730", "1745", "1800", "1815", "1830", "1845", "1900", "1915", "1930", "1945"};
	

	public static void main(String[] args) {

		//System.out.println(getMovie());
		//System.out.println(spider());
	//	System.out.println(getProduct());
//		getPrices();
//		getDigi();
		retrievePhoto();
		
	}
	
	public static void retrievePhoto () {
		List<String> hours = Arrays.asList(TIMES);
		try {
			for(String hour : hours) {
				String url = URL_START + hour + URL_END;
				ReadableByteChannel readableByteChannel = Channels.newChannel(new URL(url).openStream());
				FileOutputStream out = new FileOutputStream(THE_PATH + hour + ".jpg");
				out.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*List<String> list = new ArrayList<String>();
		int i = 0;
		Integer start = 545;
		while(i < 30) {
			start.
		}*/
	}
	
	public static String getMovie() {
		
		ObjectMapper mapper = new ObjectMapper();
		HttpResponse<JsonNode> jsonResponse = null;
		Movie movie = new Movie();
		try {
			jsonResponse = Unirest.get("http://www.omdbapi.com/?i=tt3501632")
					.header("accept", "application/json").queryString("apiKey", "fd69c375").asJson();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
		try {
			movie = mapper.readValue(jsonResponse.getBody().toString(), Movie.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return movie.getTitle();
	}
	
	public static String spider(){
		Document doc = null;
		try {
			//doc = Jsoup.connect("https://en.wikipedia.org/wiki/Main_Page").get();
			doc = Jsoup.connect("https://www.pcgarage.ro/placi-video/").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Elements links = doc.getElementById("content").getElementsByTag("a");
		Elements boxes = doc.getElementsByClass("product_box");
		for(Element e : boxes) {
			Elements links = e.getElementsByTag("a");
			for(Element link : links) {
				System.out.println(link.attr("href"));
			}
		}
		
		return doc.title();
	}

	public static Product getProduct() {
		Document prodResponse = null;
		Product product = new Product();
		String url = "https://www.pcgarage.ro/placi-video/gigabyte/geforce-rtx-2070-super-windforce-oc-3x-8gb-gddr6-256-bit/";
		try {
			prodResponse = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		product.setName(prodResponse.getElementById("product_name").ownText());
		product.setLink(url);
		product.setPrice(prodResponse.getElementById("psbx").getElementsByClass("price_num").get(0).ownText());
		product.setCurrentDate(new Date());
		if(!prodResponse.getElementById("psbx").getElementsByClass("ps_price_msg").isEmpty()) {
			product.setDiscount(prodResponse.getElementById("psbx").getElementsByClass("ps_price_msg").get(0).ownText());
		}
		if(!prodResponse.getElementById("psbx").getElementsByClass("ps_price_old").isEmpty() &&
				!prodResponse.getElementById("psbx").getElementsByClass("ps_price_old").get(0).getElementsByTag("span").isEmpty()) {
			product.setPriceOld(prodResponse.getElementById("psbx").getElementsByClass("ps_price_old").get(0).getElementsByTag("span").get(0).ownText());
		}
		
		return product;
	}
	
	public static List<String> getPrices(){
		Document response = null;
		List<String> prices = new ArrayList<>();
		String url = "https://coinmarketcap.com/";
		try {
			response = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		List<Element> priceElements = response.getElementsByTag("table").get(0)
				.getElementsByTag("tbody").get(0)
				.getElementsByTag("tr");
		System.out.println(priceElements.size());
		for(Element e : priceElements) {
			if(e.getElementsByTag("td").size()>2) {
				System.out.println(e.getElementsByTag("td").get(2).getElementsByTag("a").get(0).attr("href"));
			}
		}
		return null;
	}
	
	public static void getDigi() {
		Document response = null;
		String url = "https://www.digi24.ro/";
		try {
			response = Jsoup.connect(url).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Element> articles = response.getElementsByClass("section").get(0).getElementsByClass("article-title");
		printTheSize(articles);
		if(articles.size() > 0) {
			printTextFromListElem(articles);
		}
	}
	
	public static void printTheList(List<?> list) {
		list.forEach(x -> {
			System.out.println(x);
			System.out.println("===============================================================================");
		});
	}
	
	public static void printTheSize(List<?> list) {
		System.out.println(list.size());
	}
	
	public static void printFirstTextFromListElem(List<Element> list) {
		//System.out.println(list.get(0).ownText());
		System.out.println(list.get(0).ownText());
	}
	public static void printTextFromListElem(List<Element> list) {
		list.forEach(x -> System.out.println(x.text()));
	}
	
}
