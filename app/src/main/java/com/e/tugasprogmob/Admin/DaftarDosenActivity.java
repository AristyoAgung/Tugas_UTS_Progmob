package com.e.tugasprogmob.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.e.tugasprogmob.Adapter.DosenAdapter;
import com.e.tugasprogmob.Admin.Insert.InsertDosenActivity;
import com.e.tugasprogmob.Admin.Insert.InsertMhsActivity;
import com.e.tugasprogmob.MainActivity;
import com.e.tugasprogmob.Model.Dosen;
import com.e.tugasprogmob.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaftarDosenActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DosenAdapter mahasiswaAdapter;
    private ArrayList<Dosen> mahasiswaArrayList;
    DataDosenService dataDosenService;
    public static DaftarDosenActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_dosen);
        mahasiswaArrayList = new ArrayList<>();
        dataDosenService = RetrofitClient.getRetrofitInstance()
                .create(DataDosenService.class);
        ma=this;
        getAllDataDosen();

        //addData();

    }

    public void getAllDataDosen()
    {
        Call<List<Dosen>> call = dataDosenService.getDosenAll("72170168");
        call.enqueue(new Callback<List<Dosen>>() {
            @Override
            public void onResponse(Call<List<Dosen>> call, Response<List<Dosen>> response) {

                for(Dosen dosen:response.body())
                {
                    //mahasiswaArrayList.add(new Dosen(dosen.getNidn(),dosen.getNama(),dosen.getGelar(),dosen.getEmail(),dosen.getAlamat()));
                    mahasiswaArrayList.add(dosen);
                    /*System.out.println("Nama :"+dosen.getNama());
                    System.out.println("NIDN :"+dosen.getNidn());
                    System.out.println(mahasiswaArrayList);*/
                }
                recyclerView = findViewById(R.id.rvdd);
                mahasiswaAdapter = new DosenAdapter(mahasiswaArrayList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DaftarDosenActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(mahasiswaAdapter);
            }

            @Override
            public void onFailure(Call<List<Dosen>> call, Throwable t) {
                Toast.makeText(DaftarDosenActivity.this,"Something wrong....",Toast.LENGTH_LONG).show();
                //System.out.println(t.get);
            }
        });
    }

    private void addData() {
        //mahasiswaArrayList = new ArrayList<>();
        mahasiswaArrayList.add(new Dosen("NIDN - NAMA DOSEN","Gelar","email","alamat"));
        mahasiswaArrayList.add(new Dosen("NIDN - NAMA DOSEN","Gelar","email","alamat"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.utama,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(DaftarDosenActivity.this, InsertDosenActivity.class);
        switch (item.getItemId()){
            case R.id.item1:
                startActivity(intent);
                return true;
            case R.id.item2:
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
