package com.example.creme_project;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        ImageView imageView = findViewById(R.id.logo1);

        try {
            InputStream inputStream = getAssets().open("logo.png");

            Bitmap bitmapImage = BitmapFactory.decodeStream(inputStream);

            imageView.setImageBitmap(bitmapImage);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}