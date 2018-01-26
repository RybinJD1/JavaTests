package com.JavaTests.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "literature")
public class Literature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "questionId")
    private Question question;

    @OneToMany(mappedBy = "literature", fetch = FetchType.LAZY)
    private List<Link> listLink = new ArrayList<>();

    public Literature() {
    }

    public Literature(String description, Question question, List<Link> listLink) {
        this.description = description;
        this.question = question;
        this.listLink = listLink;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Link> getListLink() {
        return listLink;
    }

    public void setListLink(List<Link> listLink) {
        this.listLink = listLink;
    }

    @Override
    public String toString() {
        return "Literature{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", question=" + question +
                ", listLink=" + listLink +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Literature)) return false;

        Literature that = (Literature) o;

        if (getId() != that.getId()) return false;
        if (!getDescription().equals(that.getDescription())) return false;
        if (!getQuestion().equals(that.getQuestion())) return false;
        return getListLink() != null ? getListLink().equals(that.getListLink()) : that.getListLink() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getQuestion().hashCode();
        result = 31 * result + (getListLink() != null ? getListLink().hashCode() : 0);
        return result;
    }
}
