package com.fjr.test;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
public class Test123 {
	
	public static void main(String[] args) throws IOException {
		String urlstr = args[0]; 
		String file = args[1]; 
		URL url = new URL(urlstr);
		URLConnection uc = url.openConnection(); 
		uc.addRequestProperty("User-Agent", 
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
		uc.connect();
//		uc.getInputStream();
		BufferedInputStream bis = new BufferedInputStream(uc.getInputStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
	}

}
