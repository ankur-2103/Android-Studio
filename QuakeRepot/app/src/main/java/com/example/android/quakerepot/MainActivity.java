package com.example.android.quakerepot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthqaukes();


        ListView listView = (ListView)findViewById(R.id.list_view);
        EarthqaukeAdapter adapter = new EarthqaukeAdapter(this, earthquakes);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Earthquake currentEarthquake = adapter.getItem(position);
                Uri earthQuakeUri = Uri.parse(currentEarthquake.getUrl());
                Intent website = new Intent(Intent.ACTION_VIEW, earthQuakeUri);
                startActivity(website);
            }
        });

    }
}