package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Membership {
	@Id
	private String  MembershipId;
	@ManyToOne
	@JoinColumn(name = "PersonId")
	private Person_Detail PersonId;
	@Column(length = 10)
	private String Membership;
	@Column(length = 10)
	private String Membership_Duration;

	public Membership() {
		super(); // TODO Auto-generated constructor stub
		} public Membership(String MembershipId,
					 Person_Detail PersonId, String Membership,
					 String Membership_Duration) { 
			super();
					 this.MembershipId = MembershipId;
					 this.PersonId = PersonId;
					 this.Membership =Membership;
					 this.Membership_Duration = Membership_Duration;
					 }
		public String getMembershipId() {
					 return MembershipId;
					 } 
		public void setMembershipId(String MembershipId) {
					     this.MembershipId = MembershipId; 
					 }
					 public Person_Detail getPersonId() {
						 return PersonId;
						 }
					 public void setPersonId(Person_Detail studentId) {
						 this.PersonId = studentId;
						 }
					 public String getMembership_Status() {
						 return Membership;
						 }
					 public void setMembership_Status(String Membership) {
						 
		                 this.Membership = Membership;
		                 }

	                 public String getMembership_Duration() {
		                return Membership_Duration;
	                     }

	                 public void setMembership_Duration(String Membership_Duration) {
		                 this.Membership_Duration= Membership_Duration;
	                     }
              
	//@Override
	//public String toString() {
	//	return "Membership [MembershipId=" + MembershipId + ", PersonId=" + PersonId + ", Membership=" + Membership
		//		+ ", Membership_Duration=" + Membership_Duration + "]";
	//}
}
