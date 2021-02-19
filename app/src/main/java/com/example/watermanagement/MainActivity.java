package com.example.watermanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    TextView ls;
    TextView bill;
    TextView total;
    TextView freq;
    FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance("https://watermanagement1-324e3-default-rtdb.firebaseio.com/");
    DatabaseReference mRootRef=firebaseDatabase.getReference();
    DatabaseReference mtotalRef=mRootRef.child("total");
    DatabaseReference mlsRef=mRootRef.child("ls");
    DatabaseReference mbillRef=mRootRef.child("bill");
    DatabaseReference mfreqRef=mRootRef.child("Freq");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ls=findViewById(R.id.ls);
        bill=findViewById(R.id.bill);
        total=findViewById(R.id.total);
        freq=findViewById(R.id.freq);
        mfreqRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String freqs = dataSnapshot.getValue(String.class);
                freq.setText(freqs);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mlsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               String ls1 = dataSnapshot.getValue(String.class);
                ls.setText(ls1);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mtotalRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String tottal1 = dataSnapshot.getValue(String.class);
                total.setText(tottal1);
                //Log.d(pH,"pH");


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        mbillRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String bill1 = dataSnapshot.getValue(String.class);
                bill.setText(bill1);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
