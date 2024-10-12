package org.OneToManyExample;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private int id;
    private String question;
    //here there is so many answers, and we have used mappedBy, so we are saying that foreign key will be created in Answer table
    //and that foreign key will point to any of the question id column.
    //means we are giving handling things to Answer table.
    //reverse also we can do i.e. we can use mappedBy in Answer table then foreign key will be created here.
    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    public Question() {
    }

    public Question(int id, String question, List<Answer> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers;
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

    public List<Answer> getAnswer() {
        return answers;
    }

    public void setAnswer(List<Answer> answer) {
        this.answers = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer=" + answers +
                '}';
    }
}
