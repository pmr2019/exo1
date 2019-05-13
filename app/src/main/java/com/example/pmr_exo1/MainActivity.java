package com.example.pmr_exo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

        // TODO 4 : Créer un fichier preferenceScreen
        //  permettant de définir une clé baptisée “pseudo”
        //  => Fichier dans res/xml/preferences.xml

        // TODO 4 : Créer une activité 'SettingActivity' permettant de gérer les préférences

        // TODO 4 : Lors du clic sur le menu préférences,
        //  afficher l'activité 'SettingActivity'

        // TODO 4 : Au démarrage de l’activité principale,
        //  lire les préférences et compléter le champ d’entrée texte

        // TODO 4 : Lors du clic sur le bouton OK,
        //  sauvegarder les préférences avant de passer à l’activité suivante

        // TODO 4 : Dans l’activité suivante, relire les préférences et les afficher

        // TODO 4 : Vérifier la sauvegarde des préférences lorsque l’application est détruite
        // TODO 4 : Comment réinitialiser les préférences ?



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
                String pseudo = edtPseudo.getText().toString();
                alerter("Pseudo: " + pseudo);

                // TODO 3 : Créer une nouvelle activité => assistant
                // TODO 3 : Lors du clic sur le bouton OK,
                //  afficher la nouvelle activité en lui passant
                //  le contenu du champ d’entrée texte

                Intent toSecondAct =
                        new Intent(this,SecondActivity.class);

                // Ajout d'un bundle de données
                Bundle data = new Bundle();
                data.putString("pseudo",pseudo);
                toSecondAct.putExtras(data);

                // Changement d'activité
                startActivity(toSecondAct);


                // TODO 3 : Afficher le contenu récupéré dans un toast
                // => Cf. activité Second


                break;

            case R.id.edtPseudo :
                alerter("Saisir votre pseudo");
                break;

        }
    }

    // TODO 2 : affichage d'un menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_account :
                alerter("Menu Compte");
                break;

            case R.id.action_settings :
                alerter("Menu Préférences");
                Intent toSettings = new Intent(this,SettingsActivity.class);
                startActivity(toSettings);
                break;

        }
        return super.onOptionsItemSelected(item);
    }




}
