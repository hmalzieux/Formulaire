package com.example.hmalzieux.formulaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultatActivity extends AppCompatActivity {
    Button annuler;
    Button confirmer;
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);
        annuler = (Button) findViewById(R.id.but_annuler);
        confirmer = (Button) findViewById(R.id.but_confirmer);
        content = (TextView) findViewById(R.id.resultat_textview);
        final Bundle bundle = getIntent().getExtras();
        String res = getString(R.string.text_info_content,bundle.getString("nomUser"),bundle.getString("prenomUser"),bundle.getString("ageUser"),bundle.get("skillUser").toString(),bundle.getString("telephoneUser"));
        final String telephone = bundle.getString("telephoneUser");
        content.setText(res);
        annuler.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                Intent intent = new Intent(ResultatActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }

        });
        confirmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(ResultatActivity.this, AppelActivity.class);
                intent.putExtra("telephoneUser",telephone);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }
}
