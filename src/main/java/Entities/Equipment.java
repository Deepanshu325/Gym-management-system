package Entities;


import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipment {
	@Id
	@Column(name = "EquipmentId", length = 10)
	private String EquipmentId;
	@Column(name ="EquipmentType",length = 20)
	private String EquipmentType;
	@Column(name = "EquipmentName", length = 50)
	private String EquipmentName;
	@Column(name = "EquipmentUse", length = 25)
	private String EquipmentUse;
	
	
	public String getEquipmentId() {
		return EquipmentId;
	}

	public void setEquipmentId(String EquipmentId) {
		this.EquipmentId = EquipmentId;
	}

	public String getEquipmentType() {
		return EquipmentType;
	}

	public void setEquipmentType(String EquipmentType) {
		this.EquipmentType = EquipmentType;
	}

	public String getEquipmentName() {
		return EquipmentName;
	}

	public void setEquipmentName(String EquipmentName) {
		this.EquipmentName = EquipmentName;
	}

	public String getPassword() {
		return EquipmentUse;
	}

	public void setDateOfBirth(String EquipmentUse) {
		this.EquipmentUse = EquipmentUse;
	}

	
//All argument Construct 
public Equipment(String EquipmentId,
		String EquipmentType, 
		String EquipmentName,
		String EquipmentUse) 
{ 
	super();
this.EquipmentId = EquipmentId;
this.EquipmentType = EquipmentType;
this.EquipmentName = EquipmentName; 
this.EquipmentUse = EquipmentUse; 

}
@Override public String toString()
{ return 
		"Equipment [EquipmentId=" + EquipmentId + ", EquipmentType=" + EquipmentType + ", EquipmentName=" + EquipmentName + ", EquipmentUse=" +  EquipmentUse+"]";
} 
}

