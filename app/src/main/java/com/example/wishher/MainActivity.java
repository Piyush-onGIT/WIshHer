package com.example.wishher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText input = findViewById(R.id.input);
        Button save = findViewById(R.id.save);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("Data").child("data");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = input.getText().toString();
                try{
                    myRef.setValue(data);
                    Toast.makeText(getApplicationContext(),
                            "Saved",
                            Toast.LENGTH_LONG)
                            .show();
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(),
                            "Error",
                            Toast.LENGTH_LONG)
                            .show();
                }

            }
        });
    }
}