package com.emergingit.bot.apiquery;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class APIParser {

public String sendRequest(String url_to_be_parsed) throws IOException
{
    URL url = new URL(url_to_be_parsed);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    con.setConnectTimeout(5000);
    con.setReadTimeout(5000);
    int status = con.getResponseCode();
    BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer content = new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
        content.append(inputLine);
    }
    in.close();
    return content.toString();

}

}
