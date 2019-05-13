package com.example.pmr_exo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// L'activité implémente l'interface 'onClickListener'
// Une 'interface' est un "contrat"
// qui définit des fonctions à implémenter
// Ici, l'interface "onClickLister" demande que la classe
// qui l'implémente fournisse une méthode onClick

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final String CAT="PMR";
    private Button btnOK = null;
    private EditText edtPseudo = null;

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

        btnOK = findViewById(R.id.btnOK);
        edtPseudo = findViewById(R.id.edtPseudo);

        btnOK.setOnClickListener(this);
        edtPseudo.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        alerter("onStart");
    }

    @Override
    public void onClick(View v) {
        alerter("clic par l'activité qui implémenter l'interface onClickListener");
        // Intérêt : permet de capturer des clics sur plusieurs éléments...
        // Démonstration :
        switch (v.getId()) {
            case R.id.btnOK :
                // TODO 1 : afficher le contenu du champ d'entrée texte
                // TODO 1 : refactoriser la classe pour que les références
                //  deviennent des membres privés
                // TODO 1 : supprimer les morceaux de code inutiles
                alerter("Pseudo: " + edtPseudo.getText().toString());
                break;

            case R.id.edtPseudo :
                alerter("Saisir votre pseudo");
                break;

        }
    }


}
