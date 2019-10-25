package com.e.tugasprogmob.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.e.tugasprogmob.R;

public class HCAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hcadmin);

        View.OnClickListener a = new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HCAdminActivity.this, DaftarDosenActivity.class);
                startActivity(intent);
            }
        };
        Button dd = (Button)findViewById(R.id.button2);
        dd.setOnClickListener(a);

        View.OnClickListener b = new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HCAdminActivity.this, DaftarMahasiswaActivity.class);
                startActivity(intent);
            }
        };
        Button dm = (Button)findViewById(R.id.button5);
        dm.setOnClickListener(b);

        View.OnClickListener c = new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HCAdminActivity.this, MatkulAdminActivity.class);
                startActivity(intent);
            }
        };
        Button dma = (Button)findViewById(R.id.button3);
        dma.setOnClickListener(c);

        View.OnClickListener d = new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HCAdminActivity.this, KrsAdminActivity.class);
                startActivity(intent);
            }
        };
        Button kk = (Button)findViewById(R.id.button4);
        kk.setOnClickListener(d);
    }
}
