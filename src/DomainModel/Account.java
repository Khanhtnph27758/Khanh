/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainModel;

/**
 *
 * @author Admin
 */
public class Account {
    private String user;
    private String pass;
    private String email;
    private int role;

    public Account() {
    }

    public Account(String user, String pass,int role) {
        this.user = user;
        this.pass = pass;
        this.role = role;
    }
    
    public Account(String user, String pass, String email, int role) {
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
        
}
