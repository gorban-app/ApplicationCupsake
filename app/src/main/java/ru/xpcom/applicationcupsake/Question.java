package ru.xpcom.applicationcupsake;

public class Question {

    private final int idTextResId;
    private final boolean answerTrue;

    public Question(int idTextResId, boolean answerTrue) {
        this.idTextResId = idTextResId;
        this.answerTrue = answerTrue;
    }

    public int getIdTextResId() {
        return idTextResId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }
}
