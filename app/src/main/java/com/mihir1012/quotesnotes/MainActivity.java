package com.mihir1012.quotesnotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView quoteList = findViewById(R.id.quotesRecycler);
        quoteList.setLayoutManager(new LinearLayoutManager(this));

        try {
            quoteList.setAdapter(new QuoteRecyclerAdapter(getQuotes(),this));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> getQuotes() throws IOException {
        List<String> quotes = new ArrayList<>();
        BufferedReader bufferedReader = null;
        bufferedReader  = new BufferedReader(new InputStreamReader(this.getAssets().open("quotes.txt"),"UTF-8"));
        String line;
        while ((line = bufferedReader.readLine())!=null){
         quotes.add(line);
        }
        bufferedReader.close();
        return quotes;
    }
}
