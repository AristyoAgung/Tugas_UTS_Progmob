package com.e.tugasprogmob.Admin.Insert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.e.tugasprogmob.Adapter.DosenAdapter;
import com.e.tugasprogmob.Admin.DaftarDosenActivity;
import com.e.tugasprogmob.Admin.DataDosenService;
import com.e.tugasprogmob.Admin.RetrofitClient;
import com.e.tugasprogmob.MainActivity;
import com.e.tugasprogmob.Model.Dosen;
import com.e.tugasprogmob.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertDosenActivity extends AppCompatActivity {
    EditText edtNama, edtNidn, edtAlamat, edtEmail, edtGelar, edtFoto;
    Button btnSimpan, btnBack;
    DataDosenService dataDosenService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_dosen);
        edtNama = findViewById(R.id.txtNama);
        edtNidn = findViewById(R.id.txtNidn);
        edtAlamat = findViewById(R.id.txtAlamat);
        edtEmail = findViewById(R.id.txtEmail);
        edtGelar = findViewById(R.id.txtGelar);
        edtFoto = findViewById(R.id.txtFoto);
        dataDosenService = RetrofitClient.getRetrofitInstance()
                .create(DataDosenService.class);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Dosen> call = dataDosenService.postDosen("1","2",edtNama.getText().toString(),
                        edtNidn.getText().toString(), edtAlamat.getText().toString(), edtEmail.getText().toString(),
                        edtGelar.getText().toString(), edtFoto.getText().toString());
                call.enqueue(new Callback<Dosen>() {
                    @Override
                    public void onResponse(Call<Dosen> call, Response<Dosen> response) {
                        DaftarDosenActivity.ma.getAllDataDosen();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<Dosen> call, Throwable t) {
                        Toast.makeText(InsertDosenActivity.this,"Something wrong....",Toast.LENGTH_LONG).show();
                        //System.out.println(t.get);
                    }
                });
            }
        });
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DaftarDosenActivity.ma.getAllDataDosen();
                finish();
            }
        });
    }
}
