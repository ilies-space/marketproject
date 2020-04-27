package com.ilies.daily.marketproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference mDatabase ,reff;

    public Produit Product_Result;

    EditText id,  marque, nom, poids,  volume, id_producteur,  prix , id_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitCompnent();


    }

    public void InitCompnent()
    {
        //init component :
        id = findViewById(R.id.id);
        marque = findViewById(R.id.marque);
        nom = findViewById(R.id.nom);
        poids = findViewById(R.id.poids);
        volume = findViewById(R.id.volume);
        id_producteur = findViewById(R.id.id_producteur);
        prix = findViewById(R.id.prix);
        id_search = findViewById(R.id.id_search);
        //initialize Database :
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }


    //when click on Search Product button
    public void search(View view) {

        String id = id_search.getText().toString();
        reff =FirebaseDatabase.getInstance().getReference().child("products").child(id);
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                try {

                    String id = (String) dataSnapshot.child("id").getValue();
                    String marque = dataSnapshot.child("marque").getValue().toString();
                    String nom = dataSnapshot.child("nom").getValue().toString();
                    String poids = dataSnapshot.child("poids").getValue().toString();
                    String volume = dataSnapshot.child("volume").getValue().toString();
                    String id_producteur = dataSnapshot.child("id_producteur").getValue().toString();
                    String prix = dataSnapshot.child("prix").getValue().toString();
                    //open activity :
                    // Open Result activity page:
                    Intent myIntent = new Intent(MainActivity.this, result.class);
                    myIntent.putExtra("id", id);
                    myIntent.putExtra("mark", marque);
                    myIntent.putExtra("nom", nom);
                    myIntent.putExtra("poids", poids);
                    myIntent.putExtra("volume", volume);
                    myIntent.putExtra("id_producteur", id_producteur);
                    myIntent.putExtra("prix", prix);
                    MainActivity.this.startActivity(myIntent);
                }catch (Exception e)
                {
                    noProdect();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    public void noProdect()
    {
        //Show Result :
        new AlertDialog.Builder(this)
                .setTitle("info")
                .setMessage("aucun produit dans la base de données")

                .setNegativeButton("ok !", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    //This function to add product in the Database
    public void addProduct(View view) {

        String id_Input = id.getText().toString();
        String marque_Input = marque.getText().toString();
        String nom_Input = nom.getText().toString();
        String poids_Input = poids.getText().toString();
        String volume_Input = volume.getText().toString();
        String id_producteur_Input = id_producteur.getText().toString();
        String prix_Input = prix.getText().toString();

        writeNewProduct(id_Input,marque_Input,nom_Input,poids_Input,volume_Input,id_producteur_Input,prix_Input);

        //Show Result :
        new AlertDialog.Builder(this)
                .setTitle("info")
                .setMessage("le produit a été ajouté avec succès à la base de données")

                .setNegativeButton("ok !", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

    }
    //when click on Add Product button
    private void writeNewProduct(String id, String marque, String nom, String poids, String volume, String id_producteur, String prix) {

        Produit produit = new Produit(id,  marque, nom, poids,  volume, id_producteur,  prix);

        mDatabase.child("products").child(id).setValue(produit);

    }
}
