package com.example.alejandro.demo_mockups;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Serializable {
    private int idDrawable;
    private String nombre;
    private String openLibraryId;
    private String author;
    private String title;
    private String permanentNumber;
    private String name;
    private String alias;
    private String datebirth;
    private String nacionalidad;
    private String link;
    public Book( int idDrawable) {
        this.idDrawable = idDrawable;
    }
    public Book() {

    }
    public int getIdDrawable() {
        return idDrawable;
    }
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
    public static Book[] ITEMS = {
            new Book(R.drawable.jaguar_f_type_2015),
            new Book(R.drawable.mercedes_benz_amg_gt),
            new Book(R.drawable.mazda_mx5_2015),
            new Book(R.drawable.porsche_911_gts),
            new Book(R.drawable.bmw_serie6_cabrio_2015),
            new Book( R.drawable.ford_mondeo),
            new Book( R.drawable.volvo_v60_crosscountry),
            new Book( R.drawable.jaguar_xe),
            new Book(R.drawable.volkswagen_golf_r_variant_2015),
            new Book(R.drawable.seat_leon_st_cupra),
    };

    // Returns a Book given the expected JSON
    public static Book fromJson(JSONObject jsonObject) {
        Book book = new Book();
        try {
            book.title = jsonObject.has("driverId") ? jsonObject.getString("driverId") : "";
            book.permanentNumber = jsonObject.has("permanentNumber") ? jsonObject.getString("permanentNumber") : "";
            book.name = jsonObject.has("givenName") ? jsonObject.getString("givenName") : "";
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

    public int getId() {
        return nombre.hashCode();
    }

    /**
     * Obtiene item basado en su identificador
     *
     * @param id identificador
     * @return Coche
     */
    public static Book getItem(int id) {
        for (Book item : ITEMS) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
