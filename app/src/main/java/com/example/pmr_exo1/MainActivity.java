package com.example.pmr_exo1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

// L'activité implémente l'interface 'onClickListener'
// Une 'interface' est un "contrat"
// qui définit des fonctions à implémenter
// Ici, l'interface "onClickLister" demande que la classe
// qui l'implémente fournisse une méthode onClick

// TODO 4.1 : Créer un fichier preferenceScreen
//  permettant de définir une clé baptisée “pseudo”
//  => Fichier dans res/xml/preferences.xml

// TODO 4.2 : Créer une activité 'SettingActivity' permettant de gérer les préférences


// TODO 4 : Dans l’activité suivante, relire les préférences et les afficher

// TODO 4 : Vérifier la sauvegarde des préférences lorsque l’application est détruite
//  Paramètres de l'application => Stop Application
//  On la relance => Les données sont toujours là

// TODO 4 : Comment réinitialiser les préférences ?
//   Paramètres de l'application => Stop => Local Storage => Clear


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


    // TODO 4.4 : Au démarrage de l’activité principale,
    //  lire les préférences et compléter le champ d’entrée texte
    //  => On choisit de le faire dans la méthode onStart
    //  SharedPreferences PreferenceManager.getDefaultSharedPreferences(Context)

    @Override
    protected void onStart() {
        super.onStart();
        alerter("onStart");

        // récupération des préférences au niveau Application
        SharedPreferences settings =
                PreferenceManager.getDefaultSharedPreferences(this);

        edtPseudo.setText(settings.getString("pseudo",""));

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

                // TODO 4.4 : Lors du clic sur le bouton OK,
                //  sauvegarder les préférences avant de passer à l’activité suivante
                SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = settings.edit();
                editor.clear();
                // pseudo
                editor.putString("pseudo",pseudo);

                // heure de connexion
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String dateLogin = sdf.format(new Date());
                editor.putString("dateLogin",dateLogin);

                editor.commit();


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

                // TODO 4.3 : Lors du clic sur le menu préférences,
                //  afficher l'activité 'SettingActivity'

                alerter("Menu Préférences");
                Intent toSettings = new Intent(this,SettingsActivity.class);
                startActivity(toSettings);
                break;

        }
        return super.onOptionsItemSelected(item);
    }




}
