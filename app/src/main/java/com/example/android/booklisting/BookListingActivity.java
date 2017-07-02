package com.example.android.booklisting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class BookListingActivity extends AppCompatActivity {

    /* Tag for Log Messaages */
    private static final String LOG_TAG = BookListingActivity.class.getName();

    /* Constant for trasnfer newURL variable to new BookListingActivity */
    static final String SEARCH_QUERY_URL = "com.example.android.booklisting.SEARCH_QUERY_URL";

    /* Constant for retriving URL from Search Activity */
    // private static final String searchQueryUrl = getIntent().getExtras(SEARCH_QUERY_URL);


    private String newQueryUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        newQueryUrl = intent.getStringExtra(SEARCH_QUERY_URL);

        Log.i(LOG_TAG, newQueryUrl);
    }
}
