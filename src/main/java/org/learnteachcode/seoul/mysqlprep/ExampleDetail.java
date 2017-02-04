package org.learnteachcode.seoul.mysqlprep;

import javax.persistence.*;

@Entity
@Table(name = "example_detail")
public class ExampleDetail {
    @Id
    private int id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToOne(optional=false)
    @JoinColumn(name = "example_id")
    private Example exampleObj;

    ExampleDetail(String phoneNumber, Example example) {
        this.phoneNumber = phoneNumber;
        this.exampleObj = example;
    }

    public String toString() {
        return exampleObj.toString() + " - ExampleDetail(phoneNumber:" + phoneNumber + ")";
    }
}
