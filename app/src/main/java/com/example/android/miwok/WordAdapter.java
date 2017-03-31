package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by vladimirfomene on 12/20/16.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    //Background color for each list view
    private int mResourceColorId;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words A List of Word objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int backgroundColor){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mResourceColorId = backgroundColor;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // Get the miwok translation from the current word object and
        // set this text on the miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID english_text_view
        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_text_view);

        // Get the english translation from the current word object and
        // set this text on the english TextView
        englishTextView.setText(currentWord.getDefaultTranslation());

        // Find the imageView in the list_item.xml layout with the ID placeholder_image_view
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.list_item_image_view);

        //Set image only if the image resource is defined.
        if(currentWord.hasImage()) {

            // Get the image resource id from the current word object and
            // set this id on the image view.
            imageView.setImageResource(currentWord.getmImageResourceId());

            //In case you are reusing a view that was set to invisible.
            imageView.setVisibility(View.VISIBLE);
        }else {
            //Make the image view GONE(invisible and does not take layout space)
            imageView.setVisibility(View.GONE);
        }

         //Set color theme for list item
         View textContainer = listItemView.findViewById(R.id.text_container);

         //Find the color that the resource id maps to
         int color = ContextCompat.getColor(getContext(), mResourceColorId);

        //Set background Color on list item
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;

    }
}
