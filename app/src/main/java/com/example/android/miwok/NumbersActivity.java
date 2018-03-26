package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

//        //Create an array of words
//        String[] words = new String[10];
//        words[0] = "one";
//        words[1] = "two";
//        words[2] = "three";
//        words[3] = "four";
//        words[4] = "five";
//        words[5] = "six";
//        words[6] = "seven";
//        words[7] = "eight";
//        words[8] = "nine";
//        words[9] = "ten";
//
//        // Verify the contents of the array by printing out each array element to the logs
//        Log.v("NumbersActivity", "Word at index 0: " + words[0]);
//        Log.v("NumbersActivity", "Word at index 1: " + words[1]);

        //Create an list of strings (words)
//        ArrayList<String> words = new ArrayList<String>();
        //We create list of words
        ArrayList<Word> words = new ArrayList<Word>();
//        words.add("one");
        //poniższy kod można zapisać krócej, jak w linii 45;
//        Word w = new Word("one", "lutti");
//        words.add(w);
        words.add(new Word("one", "lutti"));
//        words.add("two");
        words.add(new Word("two", "otiiko"));
//        words.add("three");
        words.add(new Word("three", "tolookosu"));
//        words.add("four");
        words.add(new Word("four", "oyyisa"));
//        words.add("five");
        words.add(new Word("five", "massokka"));
//        words.add("six");
        words.add(new Word("six", "temmokka"));
//        words.add("seven");
        words.add(new Word("seven", "kenekaku"));
//        words.add("eight");
        words.add(new Word("eight", "kawinta"));
//        words.add("nine");
        words.add(new Word("nine", "wo’e"));
//        words.add("ten");
        words.add(new Word("ten", "na’aacha"));



//        // Verify the contents of the ArrayList by printing out each ArrayList element to the logs
//        Log.v("NumbersActivity", "Word at index 0: " + words.get(0));
//        Log.v("NumbersActivity", "Word at index 2: " + words.get(2));

        // Find the root view so we can add child views to it
//        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

//        // Create a variable to keep track of the current index position
//        int index = 0;
//        // Keep looping until we've reached the end of the list (which means keep looping
//        // as long as the current index position is less than the length of the list)
//        while (index < words.size()){
//            // Create a new TextView
//            TextView wordView = new TextView(this);
//
//            // Set the text to be word at the current index
//            wordView.setText(words.get(index));
//
//            // Add this TextView as another child to the root view of this layout
//            rootView.addView(wordView);
//
//            //Increment the index variable by 1
//            index++;
//        }

//        for(int index = 0; index < words.size(); index++){
//            //Create a new TextView
//            TextView wordView = new TextView(this);
//
//            // Set the text to be word at the current index
//            wordView.setText(words.get(index));
//
//            // Add this TextView as another child to the root view of this layout
//            rootView.addView(wordView);
//        }

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
//        ArrayAdapter<String> itemsAdapter =
//                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
        //teraz używamy naszego layoutu;
        ArrayAdapter<Word> itemsAdapter =
                new ArrayAdapter<Word>(this, R.layout.list_item, words);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(itemsAdapter);

    }
}
