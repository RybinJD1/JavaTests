package com.JavaTests.entity;

import javax.persistence.*;

@Entity
@Table(name = "link")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "link")
    private String link;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "literatureId")
    private Literature literature;

    public Link() {
    }

    public Link(String link, Literature literature) {
        this.link = link;
        this.literature = literature;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Literature getLiterature() {
        return literature;
    }

    public void setLiterature(Literature literature) {
        this.literature = literature;
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", link='" + link + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Link)) return false;

        Link link1 = (Link) o;

        if (id != link1.id) return false;
        if (!getLink().equals(link1.getLink())) return false;
        return getLiterature().equals(link1.getLiterature());

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + getLink().hashCode();
        result = 31 * result + getLiterature().hashCode();
        return result;
    }
}
