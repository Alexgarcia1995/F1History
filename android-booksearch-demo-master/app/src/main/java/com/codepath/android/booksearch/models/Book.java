package com.codepath.android.booksearch.models;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    private String openLibraryId;
    private String author;
    private String title;
    private String permanentNumber;
    private String name;
    private String alias;
    private String datebirth;
    private String nacionalidad;
    private String link;

    public String getOpenLibraryId() {
        return openLibraryId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public String getpermanentNumber() {
        return permanentNumber;
    }
    public String getname() {
        return name;
    }
    public String getalias() {
        return alias;
    }
    public String getdatebirth() {
        return datebirth;
    }
    public String getnacionalidad() {
        return nacionalidad;
    }
    public String getlink() {
        return link;
    }
    // Get medium sized book cover from covers API


    // Returns a Book given the expected JSON
    public static Book fromJson(JSONObject jsonObject) {
        Book book = new Book();
        try {
            book.title = jsonObject.has("driverId") ? jsonObject.getString("driverId") : "";
            book.permanentNumber = jsonObject.has("permanentNumber") ? jsonObject.getString("permanentNumber") : "";
            book.name = jsonObject.has("givenName") ? jsonObject.getString("driverId") : "";
            book.alias = jsonObject.has("familyName") ? jsonObject.getString("familyName") : "";
            book.datebirth = jsonObject.has("dateOfBirth") ? jsonObject.getString("dateOfBirth") : "";
            book.nacionalidad = jsonObject.has("nationality") ? jsonObject.getString("nationality") : "";
            book.link = jsonObject.has("url") ? jsonObject.getString("url") : "";
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        // Return new object
        return book;
    }

    // Return comma separated author list when there is more than one author
    private static String getAuthor(final JSONObject jsonObject) {
        try {
          //  final JSONArray authors = jsonObject.getJSONArray("author_name");
            final JSONArray authors = jsonObject.getJSONArray("driverId");
            int numAuthors = authors.length();
            final String[] authorStrings = new String[numAuthors];
            for (int i = 0; i < numAuthors; ++i) {
                authorStrings[i] = authors.getString(i);
            }
            return TextUtils.join(", ", authorStrings);
        } catch (JSONException e) {
            return "";
        }
    }

    // Decodes array of book json results into business model objects
    public static ArrayList<Book> fromJson(JSONArray jsonArray) {
        ArrayList<Book> books = new ArrayList<Book>(jsonArray.length());
        // Process each result in json array, decode and convert to business
        // object
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject bookJson = null;
            try {
                bookJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            Book book = Book.fromJson(bookJson);
            if (book != null) {
                books.add(book);
            }
        }
        return books;
    }
}
