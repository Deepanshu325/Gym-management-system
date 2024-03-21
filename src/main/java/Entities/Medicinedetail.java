package Entities;


import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Medicinedetail {
	@Id
	@Column(name = "MedicineId", length = 10)
	private String MedicineId;
	@Column(name = "MedicineName", length = 50)
	private String MedicineName;
	@Column(name = "MedicineUse", length = 25)
	private String MedicineUse;
	
	//@OneToMany(mappedBy = "UserId")
	//private List<Enrollment> enrollments;

	//public List<Enrollment> getEnrollments() {
	//	return enrollments;
	//}

	//public void setEnrollments(List<Enrollment> enrollments) {
	//	this.enrollments = enrollments;
	//} // Setter And Getter

	public String getMedicineId() {
		return MedicineId;
	}

	public void setEquipmentId(String MedicineId) {
		this.MedicineId = MedicineId;
	}

	

	
	public String getMedicineName() {
		return MedicineName;
	}

	public void setMedicineName(String MedicineName) {
		this.MedicineName = MedicineName;
	}

	public String getMedicineUse() {
		return MedicineUse;
	}

	public void setMedicineUse(String MedicineUse) {
		this.MedicineUse = MedicineUse;
	}

	
//All argument Construct 
public Medicinedetail(String MedicineId, 
		String MedicineName,
		String MedicineUse) 
{ 
	super();
this.MedicineId = MedicineId;
this.MedicineName = MedicineName; 
this.MedicineUse = MedicineUse; 

}

@Override public String toString()
{ return 
		"Student [MedicineId=" + MedicineId  + ", MedicineName=" + MedicineName + ", MedicineUse=" +  MedicineUse+"]";
} 
}

