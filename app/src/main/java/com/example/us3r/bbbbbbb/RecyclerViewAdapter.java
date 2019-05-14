package com.example.us3r.bbbbbbb;

import android.support.v7.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.us3r.bbbbbbb.DetailActivity;
import com.example.us3r.bbbbbbb.R;


/**
 * Created by US3R on 08/05/2019.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.MyHolder>{

    String nama [] = {"Masjid Al-Azhom", "Museum Herigate", "Kelenteng ", "Wisata Kuliner", "Pantai Tanjung Pasir"};
    int gambar [] = {R.drawable.alaksa,
            R.drawable.istiqlal,
            R.drawable.mekkah,
            R.drawable.nurul,
            R.drawable.putih};
    String detail [] = {"Masjid Al-Azhom terletak di depan Pusat Pemerintahan Kota Tangerang",
            "Museum Herigate terletak di kawasan Pasar Anyar",
            "Kelenteng terletak di kawasan Pasar Lama",
            "Wisata Kuliner hanya buka pada malam hari dan terletak di Pasar Lama",
            "Pantai Tanjung Pasir terletak di kecamatan Teluk Naga"};

    Context context;
    LayoutInflater layoutInflater;

    public RecyclerViewAdapter (Context context ){

        this.context = context;
        layoutInflater = layoutInflater.from(context);

    }
    @Override
    public RecyclerViewAdapter.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.MyHolder holder, final int position) {

        // ini berfungsi untuk mengirim data ke DetailActivity
        holder.txt.setText(nama [position]);
        holder.img.setImageResource(gambar [position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirimData = new Intent(context, DetailActivity.class);
                kirimData.putExtra("Nama", nama [position]);
                kirimData.putExtra("IMG", gambar [position]);
                kirimData.putExtra("DET", detail [position]);

                context.startActivity(kirimData);

            }
        });
    }

    @Override
    public int getItemCount() {
        return nama.length;
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        // ID ini diambil dari file list_item.xml
        ImageView img;
        TextView txt;

        public MyHolder(View itemView) {

            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.imglist);
            txt = (TextView) itemView.findViewById(R.id.txtlist);
        }
    }
}
