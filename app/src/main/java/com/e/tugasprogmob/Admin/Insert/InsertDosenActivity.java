package com.e.tugasprogmob.Admin.Insert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
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
    DaftarDosenActivity a;
    boolean update = false;
    int id;


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

        cek_update();

        ProgressDialog progressDialog;
        dataDosenService = RetrofitClient.getRetrofitInstance()
                .create(DataDosenService.class);
        btnSimpan = findViewById(R.id.btnSimpan);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tambah_dosen();
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
    private void tambah_dosen(){
        Call<Dosen> call;
        if(update) {
            call = dataDosenService.updateDosen("72170168", id, edtNama.getText().toString(),
                    edtNidn.getText().toString(), edtAlamat.getText().toString(), edtEmail.getText().toString(),
                    edtGelar.getText().toString(), edtFoto.getText().toString());
        }
        else {
            call = dataDosenService.postDosen("72170168", edtNama.getText().toString(),
                    edtNidn.getText().toString(), edtAlamat.getText().toString(), edtEmail.getText().toString(),
                    edtGelar.getText().toString(), edtFoto.getText().toString());
        }
        call.enqueue(new Callback<Dosen>() {
            @Override
            public void onResponse(Call<Dosen> call, Response<Dosen> response) {
                Intent intent = new Intent(InsertDosenActivity.this,DaftarDosenActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<Dosen> call, Throwable t) {
                Toast.makeText(InsertDosenActivity.this,"Something wrong....",Toast.LENGTH_LONG).show();
                //System.out.println(t.get);
            }
        });
    }
    void cek_update()
    {
        Bundle extras = getIntent().getExtras();
        if (extras == null){
            return;
        }
        update = extras.getBoolean("update");
        edtNama.setText(extras.getString("nama"));
        id = extras.getInt("id");
        edtNidn.setText(extras.getString("nidn"));
        edtAlamat.setText(extras.getString("alamat"));
        edtEmail.setText(extras.getString("email"));
        edtGelar.setText(extras.getString("gelar"));
        edtFoto.setText(extras.getString("foto"));

    }
}
