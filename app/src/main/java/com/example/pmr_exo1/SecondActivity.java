package com.example.pmr_exo1;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SecondActivity extends AppCompatActivity {

    TextView traces;

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

    }
}
