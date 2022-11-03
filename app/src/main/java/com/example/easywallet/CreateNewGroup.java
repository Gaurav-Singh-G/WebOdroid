package com.example.easywallet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class CreateNewGroup extends AppCompatActivity {
    Button addParticipant,create;
    EditText GName, PEmail, GDesc;
    DatabaseReference dbParticipant;
    long Gid = 0,PId=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_group);
        addParticipant = findViewById(R.id.addParticipant);
        PEmail = findViewById(R.id.PEmail);
        GName = findViewById(R.id.GName);
        GDesc = findViewById(R.id.GDesc);
        create=findViewById(R.id.create);
        dbParticipant = FirebaseDatabase.getInstance().getReference("User");
        dbParticipant.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if( snapshot.exists()){
                    Gid = (snapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        addParticipant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InsertParticipant();
            }
        });
    }
    public void InsertParticipant() {
        String Pmail = PEmail.getText().toString().trim();

        if (!(TextUtils.isEmpty(Pmail))) {
            Participants participants = new Participants(Pmail);
            dbParticipant.child(String.valueOf(Gid+1)).child("Participants").child(String.valueOf(++PId)).setValue(participants);
            PEmail.setText("");
            Toast.makeText(CreateNewGroup.this, "Participant Added", Toast.LENGTH_SHORT).show();
        }
    }
    public void createGroup(View view) {
        String Name = GName.getText().toString().trim();
        String Desc = GDesc.getText().toString().trim();
        if (!(TextUtils.isEmpty(Name))) {
            Group group = new Group(Name, Desc);
            HashMap<String, Object> result = new HashMap<>();
            result.put("GName", Name);
            result.put("GDesc", Desc);
            dbParticipant.child(String.valueOf(Gid+1)).updateChildren(result);
            startActivity(new Intent(this, MainActivity.class));
            Toast.makeText(this, "Group created", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

}