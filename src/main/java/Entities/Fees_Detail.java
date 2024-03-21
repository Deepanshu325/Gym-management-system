package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Fees_Detail {
	@Id
	private String  FeesId;
	@ManyToOne
	@JoinColumn(name = "PersonId")
	private Person_Detail PersonId;
	@Column(length = 10)
	private String Total_Fees;
	@Column(length = 10)
	private String Remaining_Fees;

	public Fees_Detail() {
		super(); // TODO Auto-generated constructor stub
		}
	public Fees_Detail(String FeesId,
					 Person_Detail PersonId, String Total_Fees,
					 String Remaining_Fees) { 
			super();
					 this.FeesId = FeesId;
					 this.PersonId = PersonId;
					 this.Total_Fees = Total_Fees;
					 this.Remaining_Fees = Remaining_Fees;
					 }
		
		public String getFeesId() {
			
					 return FeesId;
					 } public void setMembershipId(String FeesId) {
					     this.FeesId = FeesId; 
					 }
					 public Person_Detail getPersonId() {
						 return PersonId;
						 }
					 public void setPersonId(Person_Detail PersonId) {
						 this.PersonId = PersonId;
						 }
					 public String getTotal_Fees() {
						 return Total_Fees;
						 }
					 public void setTotal_Fees(String Total_Fees) {
						 
		                 this.Total_Fees = Total_Fees;
		                 }

	                 public String getRemaining_Fees() {
		                return Remaining_Fees;
	                     }

	                 public void setMembership_Duration(String Remaining_Fees) {
		                 this.Remaining_Fees= Remaining_Fees;
	                     }
              
	//@Override
	//public String toString() {
	//	return "Membership [FeesId=" + FeesId + ", PersonId=" + PersonId + ", Total_Fees=" + Total_Fees
	//			+ ", Remaining_Fees=" + Remaining_Fees + "]";
	//}
}
