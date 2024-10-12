package org.OneToOneExaple;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {
    @Id
    private int answerId;
    private String answer;
    //It will create on foreign key column referencing to primary key of Question table
    //And we used join column go give meaning ful name to the foreign key column.
    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    public Answer() {
    }

    public Answer(int answerId, String answer, Question question) {
        this.answerId = answerId;
        this.answer = answer;
        this.question = question;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", answer='" + answer + '\'' +
                ", question=" + question +
                '}';
    }
}
