package tianjin.wuqing.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Person entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_person")
public class Person implements java.io.Serializable {

	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 20, nullable = false)
	private String pIdSerial;
	
	
	private String pName;
	private String pPhone;
	private String pIdentityType;
	private String pIentityNumber;
	private String pAddress;
	private String pPostcode;
	private String pIdCardPhoto;

	// Constructors

	/** default constructor */
	public Person() {
	}

	/** full constructor */
	public Person(Integer id, String pIdSerial,String pName,
			String pPhone, String pIdentityType, String pIentityNumber,
			String pAddress, String pPostcode, String pIdCardPhoto) {
		this.id = id;
		this.pIdSerial = pIdSerial;
		this.pName = pName;
		this.pPhone = pPhone;
		this.pIdentityType = pIdentityType;
		this.pIentityNumber = pIentityNumber;
		this.pAddress = pAddress;
		this.pPostcode = pPostcode;
		this.pIdCardPhoto = pIdCardPhoto;
	}

	// Property accessors


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getpIdSerial() {
		return pIdSerial;
	}

	public void setpIdSerial(String pIdSerial) {
		this.pIdSerial = pIdSerial;
	}

	@Column(name = "p_name", nullable = false, length = 20)
	public String getpName() {
		return this.pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@Column(name = "p_phone", nullable = false, length = 11)
	public String getpPhone() {
		return this.pPhone;
	}

	public void setpPhone(String pPhone) {
		this.pPhone = pPhone;
	}

	@Column(name = "p_identityType", nullable = false, length = 20)
	public String getpIdentityType() {
		return this.pIdentityType;
	}

	public void setpIdentityType(String pIdentityType) {
		this.pIdentityType = pIdentityType;
	}

	@Column(name = "p_ientityNumber", nullable = false, length = 20)
	public String getpIentityNumber() {
		return this.pIentityNumber;
	}

	public void setpIentityNumber(String pIentityNumber) {
		this.pIentityNumber = pIentityNumber;
	}

	@Column(name = "p_address", nullable = false, length = 20)
	public String getpAddress() {
		return this.pAddress;
	}

	public void setpAddress(String pAddress) {
		this.pAddress = pAddress;
	}

	@Column(name = "p_postcode", nullable = false, length = 6)
	public String getpPostcode() {
		return this.pPostcode;
	}

	public void setpPostcode(String pPostcode) {
		this.pPostcode = pPostcode;
	}

	@Column(name = "p_idCardPhoto", nullable = false, length = 20)
	public String getpIdCardPhoto() {
		return this.pIdCardPhoto;
	}

	public void setpIdCardPhoto(String pIdCardPhoto) {
		this.pIdCardPhoto = pIdCardPhoto;
	}

}