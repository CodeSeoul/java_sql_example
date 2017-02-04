package org.learnteachcode.seoul.mysqlprep;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "example")
public class Example {
    @Id
    @GeneratedValue
    @GenericGenerator(name = "increment", strategy = "increment")
    private int id;

    private String name;

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

    public String toString() {
        return "Example(id:" + id + "; name:" + name + ")";
    }
}
