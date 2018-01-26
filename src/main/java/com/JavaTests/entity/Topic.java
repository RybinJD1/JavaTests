package com.JavaTests.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "topic", fetch = FetchType.LAZY)
    private List<Test> listTest = new ArrayList<>();

    public Topic() {
    }

    public Topic(String name, String description, List<Test> listTest) {
        this.name = name;
        this.description = description;
        this.listTest = listTest;
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

    public List<Test> getListTest() {
        return listTest;
    }

    public void setListTest(List<Test> listTest) {
        this.listTest = listTest;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Topic)) return false;

        Topic topic = (Topic) o;

        if (getId() != topic.getId()) return false;
        if (!getName().equals(topic.getName())) return false;
        if (!getDescription().equals(topic.getDescription())) return false;
        return getListTest() != null ? getListTest().equals(topic.getListTest()) : topic.getListTest() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + (getListTest() != null ? getListTest().hashCode() : 0);
        return result;
    }
}
