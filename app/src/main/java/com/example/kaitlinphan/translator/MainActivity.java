package com.example.kaitlinphan.translator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.cloud.translate.Detection;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class MainActivity extends AppCompatActivity {

    // todo API_KEY should not be stored in plain sight
    private static final String API_KEY = "AIzaSyCwyrgzyrW2BG0BClwtHXX8_96UsGmwnSM";
    private static final String TAG = "MainActivity";

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView input_tv = (TextView) findViewById(R.id.input_text_view);
        final TextView output_tv = (TextView) findViewById(R.id.output_text_view);
        final Handler textViewHandler = new Handler();

        Translate translate = (Translate) TranslateOptions.getDefaultInstance();

        Detection detection = translate.detect("Hola");
        String detectedLanguage = detection.getLanguage();
        Log.i(TAG, detectedLanguage);

        Translation translation = translate.translate(
                "World",
                Translate.TranslateOption.sourceLanguage("en"),
                Translate.TranslateOption.targetLanguage(detectedLanguage));

        output_tv.setText("Translation: %s%n" + translation);

    }

    String translate(String sourcLanguage, String textToTranslate) {

    }
}