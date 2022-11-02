package com.example.easywallet;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateNewGroup extends AppCompatActivity {
    Button addParticipant, create;
    EditText GName, email, GDesc;
    DatabaseReference dbparticipant;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_group);
        addParticipant = findViewById(R.id.addParticipant);
        email = findViewById(R.id.PEmail);
        GName = findViewById(R.id.GName);
        GDesc = findViewById(R.id.GDesc);

        dbparticipant = FirebaseDatabase.getInstance().getReference().child("Participants");

        addParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertParticipant();

            }
        });
    }
    private void InsertParticipant() {
        String PEmail = email.getText().toString();
        Participants participants =  new Participants(PEmail);

        dbparticipant.push().setValue(participants);

        Toast.makeText(this, "Participant Added", Toast.LENGTH_SHORT).show();
    }
}