package ru.xpcom.applicationcupsake;

import static android.content.ContentValues.TAG;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button btnTrue;
    private Button btnFalse;
    private ImageButton btnNext;
    private ImageButton btnPrev;
    private TextView txtQuestion;
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
        uiComponent();
        onClickButton();
        updateQuestion();
    }

    private void onClickButton() {
        btnTrue.setOnClickListener(v -> showToast(checkAnswer(true)));
        btnFalse.setOnClickListener(v -> showToast(checkAnswer(false)));
        btnNext.setOnClickListener(v -> {
            currentIndex = (currentIndex + 1) % questionsBank.length;
            updateQuestion();
        });
        btnPrev.setOnClickListener(v -> {
            if(currentIndex == 0) return;
            currentIndex = (currentIndex - 1) % questionsBank.length;
            updateQuestion();
        });
    }

    private int checkAnswer(boolean userPressedTrue) {
        boolean isAnswerTrue = questionsBank[currentIndex].isAnswerTrue();
        if (userPressedTrue == isAnswerTrue) return R.string.correct_toast;
        return R.string.incorrect_toast;
    }

    private void updateQuestion() {
        int question = questionsBank[currentIndex].getIdTextResId();
        txtQuestion.setText(question);
    }

    private void uiComponent() {
        btnTrue = findViewById(R.id.true_btn);
        btnFalse = findViewById(R.id.false_btn);
        btnNext = findViewById(R.id.next_btn);
        btnPrev = findViewById(R.id.prev_btn);
        txtQuestion = findViewById(R.id.question_text);
    }

    private void showToast(int messageToast) {
        Toast.makeText(getApplicationContext(), messageToast, Toast.LENGTH_LONG).show();
    }
}