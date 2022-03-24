/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cst8218.trem0354.appuser;

import java.io.Serializable;
import java.util.HashMap;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.CDI;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author tjust
 */
@Entity
@XmlRootElement
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Size(max = 255)
    @Column(name = "USERID")
    private String userid;
    
    @Size(max = 255)
    @Column(name = "PASSWORD")
    private String password;
    
    @Size(max = 255)
    @Column(name = "GROUPNAME")
    private String groupname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUserid(){
        return userid;
    }
    
    public void setUserid(String userid){
        this.userid = userid;
    }
    
    public String getPassword(){
        return "";
    }
    

    public void setPassword(String password){
        //I added the condition that if the password is empty it still creates
        if(password.isEmpty()){      
        }else{      
            // initialize a PasswordHash object which will generate password hashes
            Instance<? extends PasswordHash> instance = CDI.current().select(Pbkdf2PasswordHash.class);
            PasswordHash passwordHash = instance.get();
            passwordHash.initialize(new HashMap<String,String>());  // todo: are the defaults good enough?
            // now we can generate a password entry for a given password
            String passwordEntry = passwordHash.generate(password.toCharArray());
            //at this point, passwordEntry refers to a salted/hashed password entry corresponding to mySecretPassword

            this.password= passwordEntry;
    }
    }
    
    public String getGroupname(){
        return groupname;
    }
    
    public void setGroupname(String groupname){
        this.groupname= groupname;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AppUser)) {
            return false;
        }
        AppUser other = (AppUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.lab4.AppUser[ id=" + id + " ]";
    }
    
}
