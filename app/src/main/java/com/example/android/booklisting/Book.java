package com.example.android.booklisting;

import static android.R.attr.author;

/**
 * Created by luisp on 02/07/2017.
 */

public class Book {

    /*  Book title*/
    private String mTitle;

    /* Book Authors */
    private String mAuthors;

    /* Book InfoLink */
    private String mInfoLink;

    /* Create constructor */
    public Book(String title, String authors, String infoLink) {
        mTitle = title;
        mAuthors = authors;
        mInfoLink = infoLink;
    }


    /* Methods for Book */
    /* ***************  */

    /**
     *  Get the book title
     */
    public String getTitle() {
        return mTitle;
    }

    /*
     * Get the book authors
     */
    public String getAuthors() {
        return mAuthors;
    }

    /*
     * Get the book link information
     */
    public String getUrl() {
        return mInfoLink;
    }
}
