package com.JavaTests.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topicId")
    private Topic topic;

    @OneToMany(mappedBy = "test", fetch = FetchType.LAZY)
    private List<Question> listQuestion = new ArrayList<>();

    public Test() {
    }

    public Test(String name) {
        this.name = name;
    }

    public Test(String name, String description, Topic topic, List<Question> listQuestion) {
        this.name = name;
        this.description = description;
        this.topic = topic;
        this.listQuestion = listQuestion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<Question> getListQuestion() {
        return listQuestion;
    }

    public void setListQuestion(List<Question> listQuestion) {
        this.listQuestion = listQuestion;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", topic=" + topic +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;

        Test test = (Test) o;

        if (getId() != test.getId()) return false;
        if (!getName().equals(test.getName())) return false;
        if (!getDescription().equals(test.getDescription())) return false;
        if (!getTopic().equals(test.getTopic())) return false;
        return getListQuestion() != null ? getListQuestion().equals(test.getListQuestion()) : test.getListQuestion() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getTopic().hashCode();
        result = 31 * result + (getListQuestion() != null ? getListQuestion().hashCode() : 0);
        return result;
    }
}
