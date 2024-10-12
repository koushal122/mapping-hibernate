package org.OneToManyExample;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    private int answerId;
    private String answer;
    //It will create on foreign key column referencing to primary key of Question table
    //And we used join column go give meaning ful name to the foreign key column.
    @ManyToOne
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
