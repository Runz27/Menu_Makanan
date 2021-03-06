package com.example.menumakanan;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //declarasi Variable
    ListView listmakanan;
    //membuat Array
    String nama_makanan[] = {"bakso","gado-gado","Gorengan","Gudeg","Opor-Ayam","Pempek",
            "Rawon","Rendang","Soto","Nasi Kuning","Otak-otak","Sate","Pecel Lele","Ketoprak"};
    String harga_makanan[] = {"Rp. 15.000","Rp. 10.000","Rp. 4.000","Rp. 30.000","Rp. 55.000","Rp. 30.000",
            "Rp. 20.000","Rp. 65.000","Rp. 18.000","Rp. 8.000","Rp. 7.000","Rp. 25.000","Rp. 15.000","Rp. 12.000"};
    int gambar_makanan[]={R.drawable.bakso,R.drawable.gadogado,R.drawable.gorengan,R.drawable.gudeg,
            R.drawable.oporyam,R.drawable.pempek,R.drawable.rawon,R.drawable.rendang,R.drawable.soto,R.drawable.nasikuning,
            R.drawable.otakotak,R.drawable.sate,R.drawable.pecellele,R.drawable.ketoprak};
    int detail_makanan[]={R.string.bakso,R.string.gadogado,R.string.gorengan,R.string.gudeg,
            R.string.oporyam,R.string.pempek,R.string.rawon,R.string.rendang,R.string.soto,R.string.nasikuning,R.string.otakotak,R.string.sate,R.string.pecellele,R.string.ketoprak};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //inisialisasi
        listmakanan = (ListView)findViewById(R.id.listmakanan);

        CustomListAdapter adapter= new CustomListAdapter(this,nama_makanan,gambar_makanan,harga_makanan);

        //untuk mengisi data ke widget list view
        listmakanan.setAdapter(adapter);
        //aksi atau event listener dari widget list view

        listmakanan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Item Dipilih", Toast.LENGTH_SHORT).show();
                Intent kirimdata = new Intent(MainActivity.this,activity_detail_makanan.class);
                kirimdata.putExtra("gbrM",gambar_makanan[i]);
                kirimdata.putExtra("namaM",nama_makanan[i]);
                kirimdata.putExtra("hargaM",harga_makanan[i]);
                kirimdata.putExtra("detailM",detail_makanan[i]);

                startActivity(kirimdata);
            }
        });

    }
    protected void exitByBackKey(){
        AlertDialog.Builder tutup = new AlertDialog.Builder(this);
        tutup.setTitle("Alert!!");
        tutup.setIcon(R.drawable.ic_baseline_warning_amber);
        tutup.setMessage("Apakah Kamu Yakin Ingin Keluar?");
        tutup.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });
        tutup.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).show();
    }
    @Override
    public void onBackPressed(){
        exitByBackKey();
    }
}