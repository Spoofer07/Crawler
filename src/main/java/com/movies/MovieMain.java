package com.movies;

import java.io.IOException;
import java.util.Date;

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

	public static void main(String[] args) {

		//System.out.println(getMovie());
		//System.out.println(spider());
		System.out.println(getProduct());
		
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
}
