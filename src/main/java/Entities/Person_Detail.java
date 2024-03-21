package Entities;

import java.time.LocalDate;
import Entities.*;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@Entity 
public class Person_Detail { 
@Id @Column(name = "PersonId", length = 10)
private String PersonId;
@Column(name = "PersonName", length = 50) 
private String PersonName;
@Column(name = "Gender", length = 25)
private String gender;
@Column(name = "Email", length = 30) 
private String email;
@Column(name = "Phone", length = 25)
private String phone;
@Column(name = "Address", length = 50)
private String Address;


@OneToMany(mappedBy = "PersonId")
private List<Membership> memberships;
public List<Membership> getMemberships() {
	return memberships;
	}
public void setMembership(List<Membership> memberships) {
	this.memberships = memberships;
	}
@OneToMany(mappedBy = "PersonId")
private List<Fees_Detail> fees;
public List<Fees_Detail> getfees() {
	return fees;
	}
public void setfees(List<Fees_Detail> fees)
{
	this.fees = fees;
	}
//Setter And Getter
public String getPersonId()
{
return PersonId;
}
public void setPersonId(String PersonId) { 
	this.PersonId = PersonId;
	}
public String getPersonName() {
	return PersonName; 
	}
public void setPersonName(String PersonName) { 
	this.PersonName = PersonName; 
	}


public String getGender() { return gender; }
public void setGender(String gender) { 
	this.gender = gender; }
public String getEmail() {
return email;
}
public void setEmail(String email) { 
	this.email = email; }
public String getPhone() {
	return phone; }
public void setPhone(String phone) { 
	this.phone = phone; }
public String getAddress() { 
	return Address;
	}
public void setAddress(String Address) {
	this.Address = Address; 
	}
//Default Constructor 
public Person_Detail() {
	super(); // TODO Auto-generated constructor stub }
}
//All argument Constructor
public Person_Detail(String PersonId, String PersonName,  String gender, String email, String phone ,String Address)
{ super();
this.PersonId = PersonId; this.PersonName = PersonName;  this.gender = gender; this.email = email; this.phone = phone;this.Address = Address; }
//ToString method 
//@Override
//public String toString() { return "Person_Detail [PersonId=" + PersonId + ", PersonName=" + PersonName  + ", gender=" + gender + ", email=" + email + ", phone=" + phone +  ", Address=" + Address +"]"; }
}
