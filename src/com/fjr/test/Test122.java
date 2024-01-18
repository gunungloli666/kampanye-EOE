package com.fjr.test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Test122 {
	
	public static void main(String[] args) throws IOException {
		
		String urstrl = "https://filesulawesi.com/wp-content/uploads/2023/11/" ; 
		String main = "https://filesulawesi.com" ; 
		  Document doc = Jsoup.connect("https://blacksheeprestaurants.com/wp-content/uploads/2022/05/").get();
		  int a = 1; 
	        for (Element file : doc.select("td a")) {
//	            System.out.println(file.attr("href"));
	        	String href = file.attr("href"); 
//	        	System.out.println(href); 
//	        	int m = href.lastIndexOf("/"); 
	        	String all  = main  + href ; 
	        	URL url = new URL(all);
	    		BufferedInputStream bis = new BufferedInputStream(url.openStream());
	    		String namafile = String.valueOf(a++) + ".jpg"; 
	            FileOutputStream fis = new FileOutputStream(namafile) ;
	            byte[] buffer = new byte[1024];
	            int count=0;
	            while((count = bis.read(buffer,0,1024)) != -1)
	            {
	                fis.write(buffer, 0, count);
	            }
	            fis.close();
	            bis.close();
	        }
//		URL url = new URL(urstrl);  
////		url.
////		File[] ff = f.listFiles(); 
////		for(File f1 : ff) {
////			System.out.println(f1);
////		}
	}
}
