package com.JavaTests.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
@NamedNativeQuery(name = "Question.findByUserId",query = "select q.description, s.correct, l.description, link.link from" +
        " question as q join statistic as s on q.id = s.questionId join literature as l on q.id = l.questionId join" +
        " link on l.id = link.literatureId where s.userId = ? group by q.description")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testId")
    private Test test;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Literature> listLiterature = new ArrayList<>();

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Answer> listAnswer = new ArrayList<>();

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private List<Statistic> listStatistics = new ArrayList<>();

    public Question() {
    }

    public Question(String description, Test test, List<Literature> listLiterature, List<Answer> listAnswer, List<Statistic> listStatistics) {
        this.description = description;
        this.test = test;
        this.listLiterature = listLiterature;
        this.listAnswer = listAnswer;
        this.listStatistics = listStatistics;
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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public List<Literature> getListLiterature() {
        return listLiterature;
    }

    public void setListLiterature(List<Literature> listLiterature) {
        this.listLiterature = listLiterature;
    }

    public List<Answer> getListAnswer() {
        return listAnswer;
    }

    public void setListAnswer(List<Answer> listAnswer) {
        this.listAnswer = listAnswer;
    }

    public List<Statistic> getListStatistics() {
        return listStatistics;
    }

    public void setListStatistics(List<Statistic> listStatistics) {
        this.listStatistics = listStatistics;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", test=" + test +
                ", listLiterature=" + listLiterature +
                ", listAnswer=" + listAnswer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question = (Question) o;

        if (getId() != question.getId()) return false;
        if (!getDescription().equals(question.getDescription())) return false;
        if (!getTest().equals(question.getTest())) return false;
        if (getListLiterature() != null ? !getListLiterature().equals(question.getListLiterature()) : question.getListLiterature() != null)
            return false;
        if (getListAnswer() != null ? !getListAnswer().equals(question.getListAnswer()) : question.getListAnswer() != null)
            return false;
        return getListStatistics() != null ? getListStatistics().equals(question.getListStatistics()) : question.getListStatistics() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getTest().hashCode();
        result = 31 * result + (getListLiterature() != null ? getListLiterature().hashCode() : 0);
        result = 31 * result + (getListAnswer() != null ? getListAnswer().hashCode() : 0);
        result = 31 * result + (getListStatistics() != null ? getListStatistics().hashCode() : 0);
        return result;
    }
}
