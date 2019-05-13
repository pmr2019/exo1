package com.example.pmr_exo1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    private final String CAT = "PMR_Logs";
    private TextView traces;
    private String json_chaine = "{\"promo\":\"2018-2019\",\"label\":\"Programmation Mobile et Réalité Augmentée\",\"enseignants\":[{\"prenom\":\"Isabelle\",\"nom\":\"Le Glaz\"},{\"prenom\":\"Thomas\",\"nom\":\"Bourdeaud'huy\"}],\"effectifs\":[\"G1\",\"G2\"]}";

    private void afficherChaineJson(String chaine) {
        int i;

        try {
            JSONObject json_objet = new JSONObject(chaine);
            JSONArray profs = json_objet.getJSONArray("enseignants");
            for(i=0;i<profs.length();i++) {
                String prenom = ((JSONObject)profs.get(i)).getString("prenom");
                String nom = ((JSONObject) profs.get(i)).getString("nom");
                Log.i(CAT,prenom + " " + nom);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        traces = findViewById(R.id.tracesSecondeApp);

        // Récupération des données passées à l'activité dans un un bundle
        Bundle data = this.getIntent().getExtras();

        // Affichage (utiliser la méthode alerter ou afficher dans un TextView)
        traces.append("\nPseudo : ");
        traces.append(data.getString("pseudo","inconnu"));

        // TODO 4.5 : Dans l’activité suivante, relire les préférences et les afficher

        SharedPreferences settings  = PreferenceManager.getDefaultSharedPreferences(this);
        // heure de connexion
        String dateLogin = settings.getString("dateLogin","");
        String pseudo= settings.getString("pseudo","");
        traces.append("\nContenu des préférences :");
        traces.append("\ndateLogin : " + dateLogin);
        traces.append("\npseudo : " + pseudo);

        // Affichage d'un objet JSON
        afficherChaineJson(json_chaine);

    }
}
