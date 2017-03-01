package com.example.hmalzieux.formulaire;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AppelActivity extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appel);

        btn = (Button) findViewById(R.id.but_appel);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                final Bundle bundle = getIntent().getExtras();
                callIntent.setData(Uri.parse(getString(R.string.telephone_dial,bundle.getString("telephoneUser"))));
                if (ActivityCompat.checkSelfPermission(AppelActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
         }
      });

    }
}
