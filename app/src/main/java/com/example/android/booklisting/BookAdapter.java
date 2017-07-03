package com.example.android.booklisting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by luisp on 02/07/2017.
 */

public class BookAdapter extends ArrayAdapter<Book> {

    /**
     * Constructs a new {@link BookAdapter}.
     *
     * @param context of the app
     * @param books is the list of books, which is the data source of the adapter
     */
    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    /**
     * Returns a list item view that displays information about the books
     * in the list of books.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);
        }

        // Find the book at the given position in the list of books
        Book currentBook = getItem(position);

        // Get the title string from the Book object,
        String bookTitle = currentBook.getTitle();
        // Find the TextView for book title
        TextView titleView = (TextView) listItemView.findViewById(R.id.text_view_title);
        // Display the title in the title TextView
        titleView.setText(bookTitle);


        // Get the authors string from the Book object,
        String bookAuthors = currentBook.getAuthors();
        // Find the TextView for the book authors
        TextView authorsView = (TextView) listItemView.findViewById(R.id.text_view_authors);
        // Display the author of the current book in that TextView
        authorsView.setText(bookAuthors);

        return listItemView;
    }
}
