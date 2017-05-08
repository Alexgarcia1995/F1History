package com.example.alejandro.demo_mockups.Clients;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by jordi on 06/04/2017.
 */

public class Client_Resultados {

    private static final String API_BASE_URL = "http://ergast.com/api/f1/";
    private AsyncHttpClient client;

    public Client_Resultados() {
        this.client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

    // Method for accessing the search API
    public void getCalendar(final String query, JsonHttpResponseHandler handler) {
        String url;
        try {
            if (query==""){
                url = getApiUrl("current/last/");
                //url = getApiUrl(Anyo_campeonato.anio+"/last/");

            }else {
                url = getApiUrl("current/last/");

            }
            client.get(url + URLEncoder.encode(query, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
