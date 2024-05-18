package com.example.creme_project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButtonToggleGroup;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        MaterialButtonToggleGroup toggleButton = findViewById(R.id.toggleButton);
        TextView textView = findViewById(R.id.valueText);
        Button increase = findViewById(R.id.increaseButton);
        Button decrease = findViewById(R.id.decreaseButton);
        Button back = findViewById(R.id.backButton);
        Button share = findViewById(R.id.shareButton);
        toggleButton.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean b) {
                if (b) {
                    Button button = findViewById(i);
                    button.setBackgroundColor(0xffBD8456);
                } else {
                    Button button = findViewById(i);
                    button.setBackgroundColor(00000000);
                }
            }
        });
        // function to update the value of the text view
        increase.setOnClickListener(v -> {
            int value = Integer.parseInt(textView.getText().toString());
            value++;
            textView.setText(String.valueOf(value));
        });
        // function to update the value of the text view
        decrease.setOnClickListener(v -> {
            int value = Integer.parseInt(textView.getText().toString());
            // value should not be less than 0
            if (value == 0) {
                return;
            }
            value--;
            textView.setText(String.valueOf(value));
        });

        // function to go back to the previous page
        back.setOnClickListener(v -> {
            finish();
        });

        // function to share the current value of the text view
        share.setOnClickListener(v -> {
            String shareTitle = "Share Product";
            String shareDescription = "I have shared the product with you";
            String shareLink = "https://www.example.com";

            String shareMessage = shareTitle + "\n" + shareDescription + "\n" + shareLink;
           Intent shareIntent = new Intent(Intent.ACTION_SEND);
              shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareTitle);
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(shareIntent, "Share using"));
        });
    }

}