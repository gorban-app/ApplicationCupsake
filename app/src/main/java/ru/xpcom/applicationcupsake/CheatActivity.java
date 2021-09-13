package ru.xpcom.applicationcupsake;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "applicationcupsake_answer_is_true";
    private static final String EXTRA_ANSWER_SHOW = "applicationcupsake_answer_show";
    private boolean answerIsTrue;
    private TextView answerTextView;
    private Button showAnswerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        answerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, true);
        uiComponent();

    }

    private void uiComponent() {
        answerTextView = findViewById(R.id.answer_text_view);
        showAnswerButton = findViewById(R.id.show_answer_button);
        showAnswerButton.setOnClickListener( v -> {
            if(answerIsTrue) answerTextView.setText(R.string.true_btn);
            else  answerTextView.setText(R.string.false_btn);
            setAnswerShowResult(true);
        });
    }

    private void setAnswerShowResult(boolean isAnswerShow) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_IS_TRUE, isAnswerShow);
        setResult(RESULT_OK, data);
    }

    public static Intent newIntent(Context context, boolean answerIsTrue) {
        Intent intent = new Intent(context, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }
}