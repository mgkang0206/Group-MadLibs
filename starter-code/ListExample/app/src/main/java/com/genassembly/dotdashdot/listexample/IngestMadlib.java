package com.genassembly.dotdashdot.listexample;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class IngestMadlib extends AppCompatActivity {

    TextToSpeech textToSpeech;
    public ArrayList<String> currentTextArray;
    public String currentDisplayText;
    EditText editMadLib;
    EditText editGenre;
    Button buttonAddMadLib;
    Button buttonMadLibComplete;
    TextView textViewMadLibConstruction;

    private boolean lastWasString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastWasString = false;
        currentDisplayText = "";
        currentTextArray = new ArrayList<>();


        textViewMadLibConstruction = (TextView) findViewById(R.id.textViewMadLibConstruction);
        editMadLib = (EditText) findViewById(R.id.enterMadLibText);
        editGenre = (EditText) findViewById(R.id.enterGenreName);
        buttonAddMadLib = (Button) findViewById(R.id.buttonAddToMadLib);
        buttonMadLibComplete = (Button) findViewById(R.id.buttonMadLibComplete);

    }

    public void addMadLibText() {

        if (validateMadLibText()) {
            String extractedText = editMadLib.getText().toString();
            currentTextArray.add(extractedText);
            currentDisplayText += " " + extractedText;
            textViewMadLibConstruction.setText(currentDisplayText);
        } else {
            String message = "Please fill in all fields";
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            textToSpeech.setSpeechRate(.9f);
            if (!textToSpeech.isSpeaking()) {
                textToSpeech.speak(message, TextToSpeech.QUEUE_FLUSH, null);
            }
        }
    }

    public boolean validateMadLibText(){
        if (!lastWasString) {
            return false;
        } else if (editMadLib.getText().toString().length() == 0) {
            return false;
        } else {
            return true;
        }
    }



}
