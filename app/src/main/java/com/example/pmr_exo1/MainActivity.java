package com.example.pmr_exo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final String CAT="PMR";

    private void alerter(String s) {
        Log.i(CAT,s);
        Toast myToast = Toast.makeText(this,s,Toast.LENGTH_SHORT);
        myToast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alerter("onCreate");

        Button btnOK = findViewById(R.id.btnOK);
        EditText edtPseudo = findViewById(R.id.edtPseudo);


        // Seconde stratégie
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerter("clic par instanciation d'un nouvel onclicklistener spécifique pour le clic sur le bouton");
            }
        });



        // Troisième stratégie
        // L'activité implémente l'interface 'onClickListener'
        // Une 'interface' est un "contrat"
        // qui définit des fonctions à implémenter
        // Ici, l'interface "onClickLister" demande que la classe
        // qui l'implémente fournisse une méthode onClick

        btnOK.setOnClickListener(this);
        edtPseudo.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        alerter("onStart");
    }

    // Première stratégie
    public void foo(View view) {
        alerter("clic par attribut onClick sur la vue dans le layout");
    }

    @Override
    public void onClick(View v) {
        alerter("clic par l'activité qui implémenter l'interface onClickListener");
        // Intérêt : permet de capturer des clics sur plusieurs éléments...
        // Démonstration :
        switch (v.getId()) {
            case R.id.btnOK :
                    alerter("Clic sur Bouton");
                break;

            case R.id.edtPseudo :
                alerter("Clic sur champ texte");
                break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
