package org.OneToOneExaple;

import jakarta.persistence.*;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private int id;
    private String question;
    //foreign key column point to primary key of answer table
    //In answer table also we have used foreign key but that is optional.
    @OneToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    public Question() {
    }

    public Question(int id, String question, Answer answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }
}
