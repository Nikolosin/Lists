package com.example.Lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    static final String heading = "heading";
    static final String subtitle = "subtitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = findViewById(R.id.list);
        String[] values = getString(R.string.large_text).split("\n\n");

        List<Map<String, String>> data = new ArrayList<>();
        
        for (String s: values) {
            Map<String, String> str = new HashMap<>();
            str.put(heading, s);
            str.put(subtitle, Integer.toString(s.length()));
            data.add(str);
        }

        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.twin_item,
                new String [] {heading, subtitle}, new int[] {R.id.heading, R.id.subtitle});
        list.setAdapter(sAdapter);
    }
}
