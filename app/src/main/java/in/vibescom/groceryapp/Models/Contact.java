package in.vibescom.groceryapp.Models;

import java.io.Serializable;

public class Contact implements Serializable {

    String name,email,phone,pass;

    public void setName(String str1){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public void setEmail(String str2){
        this.email=email;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass(){
        return this.pass;
    }



}
