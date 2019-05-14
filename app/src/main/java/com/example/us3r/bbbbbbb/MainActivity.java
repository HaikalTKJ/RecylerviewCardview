package com.example.us3r.bbbbbbb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.us3r.bbbbbbb.RecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inisiasi ID dan pemanggilan dari layout
        list = (RecyclerView) findViewById(R.id.recyclerview);

        // mengatur jenis layoutnya, bisa vertical kebawah atau horizontal kesamping
        list.setLayoutManager(new LinearLayoutManager(this));

        // kita membuat variabel baru untuk memanggil dari file RecyclerViewAdapter agar bisa mengambil konten darinya
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(MainActivity.this);
        list.setAdapter(adapter);

    }
}
