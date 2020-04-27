package com.ilies.daily.marketproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class result extends AppCompatActivity {

    TextView id,  marque, nom, poids,  volume, id_producteur,  prix , id_search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        InitCompnent();
        Show_Result();

    }

    public void InitCompnent()
    {
        //init component :
        id = findViewById(R.id.tvid);
        marque = findViewById(R.id.tvmarque);
        nom = findViewById(R.id.tvnom);
        poids = findViewById(R.id.tvpoids);
        volume = findViewById(R.id.tvvolume);
        id_producteur = findViewById(R.id.tvid_producteur);
        prix = findViewById(R.id.tvprix);
        //initialize Database :
    }

    public void Show_Result()
    {


        String _id = getIntent().getExtras().getString("id","null");
        String _mark = getIntent().getExtras().getString("mark","null");
        String _nom = getIntent().getExtras().getString("nom","null");
        String _poids = getIntent().getExtras().getString("poids","null");
        String _volume = getIntent().getExtras().getString("volume","null");
        String _id_producteur = getIntent().getExtras().getString("id_producteur","null");
        String _prix = getIntent().getExtras().getString("prix","null");

        id.setText("id : "+_id);
        marque.setText("marque : "+_mark);
        nom.setText("nom : "+_nom);
        poids.setText("_poids : "+_poids);
        volume.setText("_volume : "+_volume);
        id_producteur.setText("id producteur : "+_id_producteur);
        prix.setText("prix : "+_prix);
    }
}
