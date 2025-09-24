package com.example.lab3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {

    Button addNoteButton;
    Button subMitButton;
    EditText title,textContent;
    TextView display;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        addNoteButton = findViewById(R.id.button4); //event source
        //event listener
        addNoteButton.setOnClickListener(view -> {  //event handler
            //do some thing : change to "about me "page
            System.out.println("Clickkkkkkkk");
            Intent aboutMeAct = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(aboutMeAct);


        });

        subMitButton = findViewById(R.id.button);
        title = findViewById(R.id.editTextText);
        textContent = findViewById(R.id.editTextText2);
        display = findViewById(R.id.textView);


        //event listener
        subMitButton.setOnClickListener(view -> {
            //get data from user (EditText)
            String stringOfTitle =  title.getText().toString();
            String stringOfContext = textContent.getText().toString();
            Date currentDate = new Date();

            //create data in TextNote class
            TextNote note = new TextNote();
            note.setTexContent(stringOfTitle);
            note.setTexContent(stringOfContext);
            note.createdDate = currentDate;

            //show data
            display.setText(Note.display);

        });
    }
}