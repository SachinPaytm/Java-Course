package com.semanticsquare.concurrency.indexer;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpConnect {

    public static String download(String sourceUrl) throws MalformedURLException, URISyntaxException {
        System.out.println("Downloading: " + sourceUrl);
        try {
            URL url = new URL(sourceUrl);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setInstanceFollowRedirects(false);

            int responseCode = con.getResponseCode();
//            System.out.println(con);
//            System.out.println(responseCode);
//            if(responseCode==HttpURLConnection.HTTP_OK){
//                return IOUtil.read(con.getInputStream());
//            }
            if(responseCode >= 300 && responseCode < 400) {

                String redirectHeader = con.getHeaderField("Location");
                return download(redirectHeader);
            }
            if(responseCode >= 200 && responseCode < 300) { // ok
                return IOUtil.read(con.getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String download(InputStream in) throws URISyntaxException, IOException {
        return IOUtil.read(in);
    }

    public static InputStream getInputStream(String sourceUrl) throws MalformedURLException, URISyntaxException {
        System.out.println("Downloading: " + sourceUrl);
        URL url = new URI(sourceUrl).toURL();
        InputStream in = null;

        try {
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            int responseCode = con.getResponseCode();

            if(responseCode >= 200 && responseCode < 300) { // ok
                in = con.getInputStream();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return in;
    }

    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        String webpage = download("http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html");
        System.out.println(webpage);
    }
}

