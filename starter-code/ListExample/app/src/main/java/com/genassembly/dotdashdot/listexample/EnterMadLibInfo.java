package com.genassembly.dotdashdot.listexample;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class EnterMadLibInfo extends AppCompatActivity {

    TextToSpeech textToSpeech;
    EditText editAdjective1;
    EditText editAdjective2;
    EditText editNoun1;
    EditText editNoun2;
    EditText editAnimal;
    EditText editGame;
    Button setIntentResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });
        editAdjective1 = (EditText) findViewById(R.id.editAdjective1);
        editAdjective2 = (EditText) findViewById(R.id.editAdjective2);
        editNoun1 = (EditText) findViewById(R.id.editNoun1);
        editNoun2 = (EditText) findViewById(R.id.editNoun2);
        editAnimal = (EditText) findViewById(R.id.editAnimal);
        editGame = (EditText) findViewById(R.id.editGame);
        setIntentResult = (Button) findViewById(R.id.setIntentResult);
        final EditText[] editRefs = {editAdjective2, editAdjective1, editNoun1, editNoun2, editAnimal, editGame};

        for (int i = 0; i < editRefs.length; i++) {
            editRefs[i].setHintTextColor(Color.WHITE);
        }

        setIntentResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateTextFields()) {
                    Log.i("MAIN", "validateTextFields failed");
                    String message = "Please fill in all fields";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
//                    textToSpeech.setSpeechRate(.01f);
//                    textToSpeech.setPitch(5f);
//                    textToSpeech.setLanguage(Locale.UK);
                    textToSpeech.setSpeechRate(.9f);
                    if (!textToSpeech.isSpeaking()) {
                        textToSpeech.speak(message, TextToSpeech.QUEUE_FLUSH, null);
                    }
                } else {
                 Intent intent = new Intent(EnterMadLibInfo.this, ResultActivity.class);
                intent.putExtra(ResultActivity.ADJECTIVE1, editAdjective1.getText().toString());
                intent.putExtra(ResultActivity.ADJECTIVE2, editAdjective2.getText().toString());
                intent.putExtra(ResultActivity.NOUN1, editNoun1.getText().toString());
                intent.putExtra(ResultActivity.NOUN2, editNoun2.getText().toString());
                intent.putExtra(ResultActivity.ANIMALS, editAnimal.getText().toString());
                intent.putExtra(ResultActivity.GAME, editGame.getText().toString());
                startActivity(intent);
                }
            }
        });
    }

    private boolean validateTextFields() {
        EditText[] textArray = {editGame, editAnimal, editNoun2, editNoun1, editAdjective1, editAdjective2};
        String[] defaults = {"Adjective", "Noun", "Animal", "Game"};
        boolean allFilledOut = true;
        String text = "";
        for (EditText view : textArray) {
            try {
                text = view.getText().toString();
            } catch (Exception e) {
                return false;
            }
            for (String myDefault : defaults) {
                if (text.equals(myDefault) || text.equals("") || text.equals(null)){
                    return false;
                }
            }
        }
        return true;
    }

//    public void clear(EditText v) {
//        v.setText("");
//    }
}
