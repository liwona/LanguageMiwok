package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    /*Handles playback of all the sound files*/
    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

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
        final ArrayList<Word> words = new ArrayList<Word>();
//        words.add("one");
        //poniższy kod można zapisać krócej, jak w linii 45;
//        Word w = new Word("one", "lutti");
//        words.add(w);
        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
//        words.add("two");
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
//        words.add("three");
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
//        words.add("four");
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
//        words.add("five");
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
//        words.add("six");
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
//        words.add("seven");
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
//        words.add("eight");
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
//        words.add("nine");
        words.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
//        words.add("ten");
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_nine));



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
/// /        ArrayAdapter<String> itemsAdapter =
//                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1.xml, words);


        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        //tworzymy nasz własny Adapter -> WordAdapter, aby być w stanie wyświelić nasz list_item.xml
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        //listView.setAdapter(itemsAdapter);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        //Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the {@link Word} object at the given position the user clicked on
                Word song = words.get(position);
                // Create and setup {@link MediaPlayer} for the audio resource associated with the current Word
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, song.getAudioResourceId() );
                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }
}
