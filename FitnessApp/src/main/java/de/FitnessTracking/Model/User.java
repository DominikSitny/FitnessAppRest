package de.FitnessTracking.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class User {

  @Id
  @GeneratedValue
  private Long id;
  

  @Column(nullable = false)
  private String email;
  
  @Column(nullable = false)
  private String name;
  
  @Column(nullable = false)
  private String password;
  

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}
 
public String toString(){
	return "id:" + this.id + ",email:" + this.email + ",name:"+this.name+",password:"+this.password+";"; 
}


}

