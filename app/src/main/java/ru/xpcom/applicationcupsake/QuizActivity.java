package ru.xpcom.applicationcupsake;

import static android.content.ContentValues.TAG;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";

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
        updateQuestion();
        btnVisibleAndInvisible();
        Log.d(TAG, "onCreate(Bundle) called");
    }

    public void onClickButton(View view){
        if(view.getId() == R.id.true_btn) {
            showToast(checkAnswer(true));
        } else if(view.getId() == R.id.false_btn){
            showToast(checkAnswer(false));
        } else if(view.getId() == R.id.next_btn) {
            currentIndex = (currentIndex + 1) % questionsBank.length;
            updateQuestion();
        } else if(view.getId() == R.id.prev_btn) {
            currentIndex = (currentIndex - 1) % questionsBank.length;
            updateQuestion();
        }
        btnVisibleAndInvisible();
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

    private void btnVisibleAndInvisible() {
        if(currentIndex == 0) btnPrev.setVisibility(View.INVISIBLE);
        else if(currentIndex == 1) btnNext.setVisibility(View.INVISIBLE);
        else {
            btnPrev.setVisibility(View.VISIBLE);
            btnNext.setVisibility(View.VISIBLE);
        }
    }

    private void showToast(int messageToast) {
        Toast.makeText(getApplicationContext(), messageToast, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

}