package model;

import java.io.Serializable;

/**
 * Created by Admin on 12/20/2017.
 */

public class DanhBa implements Serializable{
    private int id;
    private String name;
    private String phone;

    public DanhBa() {

    }

    public DanhBa(int id, String name, String phone) {

        this.id = id;
        this.name = name;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
