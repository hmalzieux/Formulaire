package com.example.hmalzieux.formulaire;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button ButValider;
    EditText nom;
    EditText prenom;
    EditText age;
    EditText skill;
    EditText telephone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButValider = (Button) findViewById(R.id.but_val);
        nom   = (EditText)findViewById(R.id.user_name);
        prenom   = (EditText)findViewById(R.id.user_firstname);
        age   = (EditText)findViewById(R.id.user_age);
        skill   = (EditText)findViewById(R.id.user_domaine);
        telephone   = (EditText)findViewById(R.id.user_telephone);

        ButValider.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(arg0.getContext());
                builder.setTitle(getString(R.string.title_alert_dialog));
                builder.setMessage(getString(R.string.mess_confirmation));
                builder.setCancelable(false);
                builder.setPositiveButton(getString(R.string.oui), new Dialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(MainActivity.this, ResultatActivity.class);
                        intent.putExtra("nomUser",nom.getText().toString());
                        intent.putExtra("prenomUser",prenom.getText().toString());
                        intent.putExtra("ageUser",age.getText().toString());
                        intent.putExtra("skillUser",skill.getText().toString());
                        intent.putExtra("telephoneUser",telephone.getText().toString());
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    }
                });
                builder.setNegativeButton(getString(R.string.retour), new Dialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }
}
