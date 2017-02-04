package org.learnteachcode.seoul.databaseclass;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "example")
public class Example {
    @Id
    @GeneratedValue
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "exampleObj", targetEntity = ExampleDetail.class)
    private ExampleDetail detail;

    public Example() {}

    Example(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExampleDetail getDetail() {
        return detail;
    }

    void setDetail(ExampleDetail detail) {
        this.detail = detail;
    }

    public String toString() {
        return "Example(id:" + id + "; name:" + name + ")";
    }
}
