package com.example.menumakanan;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends BaseAdapter {

    String nama_makanan[];
    String harga_makanan[];
    int gambar_makanan[];

    Activity act;

    public CustomListAdapter(MainActivity mainActivity,String[] nama_makanan,int[] gambar_makanan,String[] harga_makanan){
        this.nama_makanan= nama_makanan;
        this.gambar_makanan=gambar_makanan;
        this.harga_makanan=harga_makanan;
        act=mainActivity;
    }

    @Override
    public int getCount() {
        return gambar_makanan.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater=(LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView= inflater.inflate(R.layout.tampilancustomlist, null);

        ImageView imgmakanan= convertView.findViewById(R.id.imgmakanan);
        TextView txtmakanan= convertView.findViewById(R.id.txtmakanan);
        TextView hargamakanan= convertView.findViewById(R.id.txtharga);

        txtmakanan.setText(nama_makanan[i]);
        hargamakanan.setText(harga_makanan[i]);
        imgmakanan.setImageResource(gambar_makanan[i]);

        return convertView;
    }
    //Override
    public CharSequence[] getAutofillOptions(){return new CharSequence[0];}
}
