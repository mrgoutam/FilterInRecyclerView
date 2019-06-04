package com.example.filterinrecyclerview;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Model> list = new ArrayList<>();
        list.add(new Model(R.drawable.ironman, "Iron Man", "This guy change my life. This guy change my life. This guy change my life. This guy change my life. This guy change my life. This guy change my life."));
        list.add(new Model(R.drawable.sherlok, "Sherlok Holmes", "He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. "));
        list.add(new Model(R.drawable.mentalist, "The Mentalist", "He is the best mind reader. He is the best mind reader. He is the best mind reader. He is the best mind reader. He is the best mind reader."));
        list.add(new Model(R.drawable.ironman, "Iron Man", "This guy change my life. This guy change my life. This guy change my life. This guy change my life. This guy change my life. This guy change my life."));
        list.add(new Model(R.drawable.sherlok, "Shherlok Holmes", "He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. "));
        list.add(new Model(R.drawable.mentalist, "The Mentalist", "He is the best mind reader. He is the best mind reader. He is the best mind reader. He is the best mind reader. He is the best mind reader."));
        list.add(new Model(R.drawable.ironman, "Iron Man", "This guy change my life. This guy change my life. This guy change my life. This guy change my life. This guy change my life. This guy change my life."));
        list.add(new Model(R.drawable.sherlok, "Sherlok Holmes", "He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. "));
        list.add(new Model(R.drawable.mentalist, "The Mentalist", "He is the best mind reader. He is the best mind reader. He is the best mind reader. He is the best mind reader. He is the best mind reader."));
        list.add(new Model(R.drawable.ironman, "Iron Man", "This guy change my life. This guy change my life. This guy change my life. This guy change my life. This guy change my life. This guy change my life."));
        list.add(new Model(R.drawable.sherlok, "Shherlok Holmes", "He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. "));
        list.add(new Model(R.drawable.mentalist, "The Mentalist", "He is the best mind reader. He is the best mind reader. He is the best mind reader. He is the best mind reader. He is the best mind reader."));
        list.add(new Model(R.drawable.ironman, "Iron Man", "This guy change my life. This guy change my life. This guy change my life. This guy change my life. This guy change my life. This guy change my life."));
        list.add(new Model(R.drawable.sherlok, "Sherlok Holmes", "He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. He is very intelligent. "));
        list.add(new Model(R.drawable.mentalist, "The Mentalist", "He is the best mind reader. He is the best mind reader. He is the best mind reader. He is the best mind reader. He is the best mind reader."));


        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //Without this layout manager the recycler item will not be set.
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        final RecyclerAdapter adapter = new RecyclerAdapter(list);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        SearchView searchView = findViewById(R.id.search_view);
        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        // listening to search query text change
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                adapter.getFilter().filter(query);
                return false;
            }
        });
    }
}
