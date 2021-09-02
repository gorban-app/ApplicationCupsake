package ru.xpcom.applicationcupsake;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class QuizActivity extends AppCompatActivity {

    private Button btnTrue;
    private Button btnFalse;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        TextView textView = (TextView) findViewById(R.id.tv_hello_world);
        InputStream file = getResources().openRawResource(R.raw.readme);
        String readText = new BufferedReader(new InputStreamReader(file))
                .lines()
                .collect(Collectors.joining("\n"));
        textView.setText(readText);
        uiComponent();
        onClickButton();
    }

    private void onClickButton() {
        btnTrue.setOnClickListener(v -> showToast(R.string.correct_toast));
        btnFalse.setOnClickListener(v -> showToast(R.string.incorrect_toast));
    }

    private void uiComponent() {
        btnTrue = findViewById(R.id.true_btn);
        btnFalse = findViewById(R.id.false_btn);
    }

    private void showToast(int messageToast) {
        Toast.makeText(getApplicationContext(), messageToast , Toast.LENGTH_LONG).show();
    }
}