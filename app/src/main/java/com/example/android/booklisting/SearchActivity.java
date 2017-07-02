package com.example.android.booklisting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;


public class SearchActivity extends AppCompatActivity {

    /**
     *  VARIABLE DECLARATION
     *  ********************
     */

    /* Global SeekBar Variables */
    private SeekBar seekBarNumberResults;
    private int numberResults = 0;
    private String progressString;

    /* Edit Text */
    private EditText searchText;
    private String queryText;

    /* Textedit number of results wished */
    private TextView textNumberResults;

    /* Variable for Search Button */
    private Button searchButton;

    /* Variable for returning new URL */
    private String newUrl;

    /* Constant for trasnfer newURL variable to new BookListingActivity */
    private static final String SEARCH_QUERY_URL = "com.example.android.booklisting.SEARCH_QUERY_URL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        /* Local SeekBar Variables */
        int seekBarProgress = 0;
        int maxNumberResults = 20;

        /* Capture of edition fields */
        /* ************************* */

        /* Search Text */
        searchText = (EditText) findViewById(R.id.search_text);

        /* SeekBar for Results */
        seekBarNumberResults = (SeekBar) findViewById(R.id.seekbar_numberResults);
        // seekBarNumberResults.setClickable(true);
        seekBarNumberResults.setProgress(numberResults);
        seekBarNumberResults.incrementProgressBy(seekBarProgress);
        seekBarNumberResults.setMax(maxNumberResults);

        /* Numbers of Results */
        textNumberResults = (TextView) findViewById(R.id.number_results);

        /* Search Button */
        searchButton = (Button) findViewById(R.id.search_button);

        seekBarNumberResults.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numberResults = progress;
                seekBarNumberResults.setProgress(numberResults);

                if (fromUser) {
                    if (progress >= 1 && progress <= seekBarNumberResults.getMax()) {
                        progressString = String.valueOf(progress);
                        textNumberResults.setText(progressString); // the TextView Reference
                        // seekBar.setSecondaryProgress(progress);
                    }
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                queryText = searchText.getText().toString();
                String toastText  = getString(R.string.no_input_text_message);

                /* If the input text is longer than 2 characters then continue with the app */
                if (queryText.length() > 2) {
                    // Start BookListingActivity
                    moveToBookListingActivity();
                } else {
                    // Send toast message to correct input text
                    showToastText(toastText);
                }
            }
        });
    }

    private void showToastText(String toastMessage) {
        // Toast object including a tostMessage to be defined when called
        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
        // Keep focus on Edit Text field called searchText
        searchText.requestFocus();
    }

    private void moveToBookListingActivity() {
        // Define new intent for BookListingActivity
        Intent bookListingActivity = new Intent(SearchActivity.this, BookListingActivity.class);
        // Define flag to avoid create a new intent if it is already created
        bookListingActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        // Assign new url for new activity under transfer keyword "KEY"
        bookListingActivity.putExtra(SEARCH_QUERY_URL, newUrl());
        // Start new activity
        startActivity(bookListingActivity);
    }

    private String newUrl(){
        // Define API URL with the input text and the whised number of results
        // Google Books API URL:
        // https://www.googleapis.com/books/v1/volumes?q=android&maxResults=1
        newUrl = "https://www.googleapis.com/books/v1/volumes?q=";
        newUrl += queryText;
        newUrl += "&maxResults=";
        newUrl += numberResults;

        return newUrl;
    }
}


