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
    private Button btnNext;
    private Question[] questionsBank = {
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_america, true),
            new Question(R.string.question_asia, true)
    };
    private int currentIndex = 0;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        TextView textView = (TextView) findViewById(R.id.tv_hello_world);
        int question = questionsBank[currentIndex].getIdTextResId();
        textView.setText(question);
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
        btnNext = findViewById(R.id.next_btn);
    }

    private void showToast(int messageToast) {
        Toast.makeText(getApplicationContext(), messageToast , Toast.LENGTH_LONG).show();
    }
}