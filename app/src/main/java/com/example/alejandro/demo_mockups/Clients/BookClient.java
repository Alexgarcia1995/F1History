package com.example.alejandro.demo_mockups.Clients;

import com.example.alejandro.demo_mockups.Activities.Anyo_campeonato;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class BookClient {
 // private static final String API_BASE_URL = "http://openlibrary.org/";
    private static final String API_BASE_URL = "http://ergast.com/api/f1/";
    private AsyncHttpClient client;

    public BookClient() {
        this.client = new AsyncHttpClient();
    }

    private String getApiUrl(String relativeUrl) {
        return API_BASE_URL + relativeUrl;
    }

    // Method for accessing the search API
    public void getBooks(final String query, JsonHttpResponseHandler handler) {
        String url;
        try {
            if (query==""){
                 url = getApiUrl(Anyo_campeonato.anio);

            }else {
                 url = getApiUrl(Anyo_campeonato.anio+"/");
            }
            client.get(url + URLEncoder.encode(query, "utf-8"), handler);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // Method for accessing books API to get publisher and no. of pages in a book.
    public void getExtraBookDetails(String openLibraryId, JsonHttpResponseHandler handler) {
        String url = getApiUrl("books/");
        client.get(url + openLibraryId + ".json", handler);
    }
}
