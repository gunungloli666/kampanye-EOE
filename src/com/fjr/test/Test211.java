package com.fjr.test;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Test211 {
public static void main(String[] args) throws IOException {
	
		String urstrl = "https://www.prikol.ru/wp-content/gallery/march-2020/" ; 
		String main = "https://www.prikol.ru/wp-content/gallery/march-2011/" ; 
		  Document doc = Jsoup.connect("https://www.prikol.ru/wp-content/gallery/march-2011/").get();
		  int a = 1; 
	        for (Element file : doc.select("td a")) {
//	        	System.out.println(file); 
//	            System.out.println(file.attr("href"));
	        	String href = file.attr("href"); 
//////	        	System.out.println(href); 
//////	        	int m = href.lastIndexOf("/"); 
	        	String all  = main  + href ; 
////	        	System.out.println(all) ;
	        	try {
		        	URL url = new URL(all);
		        	URLConnection uc = url.openConnection(); 
		    		uc.addRequestProperty("User-Agent", 
		    				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		    		uc.connect();
		    		BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
		    		String namafile = String.valueOf(a++) + ".jpg"; 
		            FileOutputStream fis = new FileOutputStream(namafile);
		            byte[] buffer = new byte[1024];
		            int count=0;
		            while((count = bis.read(buffer,0,1024)) != -1)
		            {
		                fis.write(buffer, 0, count);
		            }
		            fis.close();
		            bis.close();

	        	}catch(Exception e) {
	        		System.out.println("eror: " + all ); 
	        		System.out.println(e.getMessage()); 
	        	}
	        }
	}
}
