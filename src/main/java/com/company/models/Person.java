package com.company.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;


public class Person {
    private int person_id;
    private String full_name;
    private String birthday;

    private List<Book> personBooks;
    public Person(){

    }
    public Person(int person_id, String full_name, String birthday) {
        this.person_id = person_id;
        this.full_name = full_name;
        this.birthday = birthday;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
