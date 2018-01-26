package com.JavaTests.entity;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "correct")
    private boolean correct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    private Question question;

    public Answer() {
    }

    public Answer(String description, boolean correct, Question question) {
        this.description = description;
        this.correct = correct;
        this.question = question;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question quest) {
        this.question = quest;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", correct=" + correct +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Answer)) return false;

        Answer answer = (Answer) o;

        if (getId() != answer.getId()) return false;
        if (isCorrect() != answer.isCorrect()) return false;
        if (!getDescription().equals(answer.getDescription())) return false;
        return getQuestion().equals(answer.getQuestion());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + (isCorrect() ? 1 : 0);
        result = 31 * result + getQuestion().hashCode();
        return result;
    }
}
