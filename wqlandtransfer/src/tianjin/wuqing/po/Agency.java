package tianjin.wuqing.po;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Agency entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_agency")
public class Agency implements Serializable {

	// Fields

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String aName;
	private String aCertificateType;
	private String aCertificateNumber;
	private String aCertificatePhoto;
	private String aBusiness;
	private String aQualifactionType;
	private String aQualifactionNumber;
	private String aQualifactionPhoto;
	private String aLegalPerson;
	private String aIdentityType;
	private String aIentityNumber;
	private String aaddress;
	private String aPostcode;
	private String aPhone;
	private String aEmail;
	private String aIdCardPhoto;
	private String aIdSerial;

	// Constructors

	/** default constructor */
	public Agency() {
	}

	/** full constructor */
	public Agency( Integer id,  String aName,
			String aCertificateType, String aCertificateNumber,
			String aCertificatePhoto, String aBusiness,
			String aQualifactionType, String aQualifactionNumber,
			String aQualifactionPhoto, String aLegalPerson,
			String aIdentityType, String aIentityNumber, String aaddress,
			String aPostcode, String aPhone, String aEmail, String aIdCardPhoto,String aIdSerial) {
		
		this.id = id;
	
		this.aName = aName;
		this.aCertificateType = aCertificateType;
		this.aCertificateNumber = aCertificateNumber;
		this.aCertificatePhoto = aCertificatePhoto;
		this.aBusiness = aBusiness;
		this.aQualifactionType = aQualifactionType;
		this.aQualifactionNumber = aQualifactionNumber;
		this.aQualifactionPhoto = aQualifactionPhoto;
		this.aLegalPerson = aLegalPerson;
		this.aIdentityType = aIdentityType;
		this.aIentityNumber = aIentityNumber;
		this.aaddress = aaddress;
		this.aPostcode = aPostcode;
		this.aPhone = aPhone;
		this.aEmail = aEmail;
		this.aIdCardPhoto = aIdCardPhoto;
		this.aIdSerial = aIdSerial;
	}

	// Property accessors
	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	

	

	@Column(name = "a_name", nullable = false, length = 30)
	public String getaName() {
		return this.aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	@Column(name = "a_certificateType", nullable = false, length = 16)
	public String getaCertificateType() {
		return this.aCertificateType;
	}

	public void setaCertificateType(String aCertificateType) {
		this.aCertificateType = aCertificateType;
	}

	@Column(name = "a_certificateNumber", nullable = false, length = 20)
	public String getaCertificateNumber() {
		return this.aCertificateNumber;
	}

	public void setaCertificateNumber(String aCertificateNumber) {
		this.aCertificateNumber = aCertificateNumber;
	}

	@Column(name = "a_certificatePhoto", nullable = false)
	public String getaCertificatePhoto() {
		return this.aCertificatePhoto;
	}

	public void setaCertificatePhoto(String aCertificatePhoto) {
		this.aCertificatePhoto = aCertificatePhoto;
	}

	@Column(name = "a_business", nullable = false, length = 100)
	public String getaBusiness() {
		return this.aBusiness;
	}

	public void setaBusiness(String aBusiness) {
		this.aBusiness = aBusiness;
	}

	@Column(name = "a_qualifactionType", nullable = false, length = 30)
	public String getaQualifactionType() {
		return this.aQualifactionType;
	}

	public void setaQualifactionType(String aQualifactionType) {
		this.aQualifactionType = aQualifactionType;
	}

	@Column(name = "a_qualifactionNumber", nullable = false, length = 20)
	public String getaQualifactionNumber() {
		return this.aQualifactionNumber;
	}

	public void setaQualifactionNumber(String aQualifactionNumber) {
		this.aQualifactionNumber = aQualifactionNumber;
	}

	@Column(name = "a_qualifactionPhoto", nullable = false)
	public String getaQualifactionPhoto() {
		return this.aQualifactionPhoto;
	}

	public void setaQualifactionPhoto(String aQualifactionPhoto) {
		this.aQualifactionPhoto = aQualifactionPhoto;
	}

	@Column(name = "a_legalPerson", nullable = false, length = 20)
	public String getaLegalPerson() {
		return this.aLegalPerson;
	}

	public void setaLegalPerson(String aLegalPerson) {
		this.aLegalPerson = aLegalPerson;
	}

	@Column(name = "a_identityType", nullable = false, length = 20)
	public String getaIdentityType() {
		return this.aIdentityType;
	}

	public void setaIdentityType(String aIdentityType) {
		this.aIdentityType = aIdentityType;
	}

	@Column(name = "a_ientityNumber", nullable = false, length = 20)
	public String getaIentityNumber() {
		return this.aIentityNumber;
	}

	public void setaIentityNumber(String aIentityNumber) {
		this.aIentityNumber = aIentityNumber;
	}

	@Column(name = "a_address", nullable = false, length = 50)
	public String getaaddress() {
		return this.aaddress;
	}

	public void setaaddress(String aaddress) {
		this.aaddress = aaddress;
	}

	@Column(name = "a_postcode", nullable = false, length = 6)
	public String getaPostcode() {
		return this.aPostcode;
	}

	public void setaPostcode(String aPostcode) {
		this.aPostcode = aPostcode;
	}

	@Column(name = "a_phone", nullable = false, length = 11)
	public String getaPhone() {
		return this.aPhone;
	}

	public void setaPhone(String aPhone) {
		this.aPhone = aPhone;
	}

	@Column(name = "a_email", nullable = false, length = 30)
	public String getaEmail() {
		return this.aEmail;
	}

	public void setaEmail(String aEmail) {
		this.aEmail = aEmail;
	}

	@Column(name = "a_idCardPhoto", nullable = false, length = 30)
	public String getaIdCardPhoto() {
		return this.aIdCardPhoto;
	}

	public void setaIdCardPhoto(String aIdCardPhoto) {
		this.aIdCardPhoto = aIdCardPhoto;
	}
	@Column(name = "a_idSerial",length = 20, nullable = false)
	public String getaIdSerial() {
		return aIdSerial;
	}

	public void setaIdSerial(String aIdSerial) {
		this.aIdSerial = aIdSerial;
	}
	

}