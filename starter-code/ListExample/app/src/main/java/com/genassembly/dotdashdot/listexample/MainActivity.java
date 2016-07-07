package com.genassembly.dotdashdot.listexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MadLibs> libs = new ArrayList<>();
        libs.add(new MadLibs("Horror", 100, 20));
        libs.add(new MadLibs("Fantasy", 12, 123));
        libs.add(new MadLibs("Comedy", 10001243, 35));
        libs.add(new MadLibs("Animation", 2134, 212));
        libs.add(new MadLibs("Fantasy", 22, 43));

        ListView listy = (ListView) findViewById(R.id.mainList);
        SimpleAdapter adapty = new SimpleAdapter(this, libs);
        if (listy != null) {
            listy.setAdapter(adapty);
        }
    }
}
