package tianjin.wuqing.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Financial entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_financial")
public class Financial implements java.io.Serializable {

	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 20, nullable = false)
	private String fIdSerial;

	
	private String fName;
	private String fCertificateType;
	private String fCertificateNumber;
	private String fCertificatePhoto;
	private String fBusiness;
	private String fQualifactionType;
	private String fQualifactionNumber;
	private String fQualifactionPhoto;
	private String fLegalPerson;
	private String fIdentityType;
	private String fIentityNumber;
	private String fAddress;
	private String fPostcode;
	private String fPhone;
	private String fEmail;
	private String fIdCardPhoto;

	// Constructors

	/** default constructor */
	public Financial() {
	}

	/** full constructor */
	public Financial(Integer id, String fIdSerial,
			String fName, String fCertificateType, String fCertificateNumber,
			String fCertificatePhoto, String fBusiness,
			String fQualifactionType, String fQualifactionNumber,
			String fQualifactionPhoto, String fLegalPerson,
			String fIdentityType, String fIentityNumber, String fAddress,
			String fPostcode, String fPhone, String fEmail, String fIdCardPhoto) {
		this.id = id;
		this.fIdSerial = fIdSerial;
		this.fName = fName;
		this.fCertificateType = fCertificateType;
		this.fCertificateNumber = fCertificateNumber;
		this.fCertificatePhoto = fCertificatePhoto;
		this.fBusiness = fBusiness;
		this.fQualifactionType = fQualifactionType;
		this.fQualifactionNumber = fQualifactionNumber;
		this.fQualifactionPhoto = fQualifactionPhoto;
		this.fLegalPerson = fLegalPerson;
		this.fIdentityType = fIdentityType;
		this.fIentityNumber = fIentityNumber;
		this.fAddress = fAddress;
		this.fPostcode = fPostcode;
		this.fPhone = fPhone;
		this.fEmail = fEmail;
		this.fIdCardPhoto = fIdCardPhoto;
	}

	// Property accessors

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getfIdSerial() {
		return fIdSerial;
	}

	public void setfIdSerial(String fIdSerial) {
		this.fIdSerial = fIdSerial;
	}
	
	@Column(name = "f_name", nullable = false, length = 30)
	public String getfName() {
		return this.fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	@Column(name = "f_certificateType", nullable = false, length = 16)
	public String getfCertificateType() {
		return this.fCertificateType;
	}

	public void setfCertificateType(String fCertificateType) {
		this.fCertificateType = fCertificateType;
	}

	@Column(name = "f_certificateNumber", nullable = false, length = 20)
	public String getfCertificateNumber() {
		return this.fCertificateNumber;
	}

	public void setfCertificateNumber(String fCertificateNumber) {
		this.fCertificateNumber = fCertificateNumber;
	}

	@Column(name = "f_certificatePhoto", nullable = false)
	public String getfCertificatePhoto() {
		return this.fCertificatePhoto;
	}

	public void setfCertificatePhoto(String fCertificatePhoto) {
		this.fCertificatePhoto = fCertificatePhoto;
	}

	@Column(name = "f_business", nullable = false, length = 100)
	public String getfBusiness() {
		return this.fBusiness;
	}

	public void setfBusiness(String fBusiness) {
		this.fBusiness = fBusiness;
	}

	@Column(name = "f_qualifactionType", nullable = false, length = 30)
	public String getfQualifactionType() {
		return this.fQualifactionType;
	}

	public void setfQualifactionType(String fQualifactionType) {
		this.fQualifactionType = fQualifactionType;
	}

	@Column(name = "f_qualifactionNumber", nullable = false, length = 20)
	public String getfQualifactionNumber() {
		return this.fQualifactionNumber;
	}

	public void setfQualifactionNumber(String fQualifactionNumber) {
		this.fQualifactionNumber = fQualifactionNumber;
	}

	@Column(name = "f_qualifactionPhoto", nullable = false)
	public String getfQualifactionPhoto() {
		return this.fQualifactionPhoto;
	}

	public void setfQualifactionPhoto(String fQualifactionPhoto) {
		this.fQualifactionPhoto = fQualifactionPhoto;
	}

	@Column(name = "f_legalPerson", nullable = false, length = 20)
	public String getfLegalPerson() {
		return this.fLegalPerson;
	}

	public void setfLegalPerson(String fLegalPerson) {
		this.fLegalPerson = fLegalPerson;
	}

	@Column(name = "f_identityType", nullable = false, length = 20)
	public String getfIdentityType() {
		return this.fIdentityType;
	}

	public void setfIdentityType(String fIdentityType) {
		this.fIdentityType = fIdentityType;
	}

	@Column(name = "f_ientityNumber", nullable = false, length = 20)
	public String getfIentityNumber() {
		return this.fIentityNumber;
	}

	public void setfIentityNumber(String fIentityNumber) {
		this.fIentityNumber = fIentityNumber;
	}

	@Column(name = "f_address", nullable = false, length = 50)
	public String getfAddress() {
		return this.fAddress;
	}

	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}

	@Column(name = "f_postcode", nullable = false, length = 6)
	public String getfPostcode() {
		return this.fPostcode;
	}

	public void setfPostcode(String fPostcode) {
		this.fPostcode = fPostcode;
	}

	@Column(name = "f_phone", nullable = false, length = 11)
	public String getfPhone() {
		return this.fPhone;
	}

	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	}

	@Column(name = "f_email", nullable = false, length = 30)
	public String getfEmail() {
		return this.fEmail;
	}

	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}

	@Column(name = "f_idCordPhoto", nullable = false, length = 20)
	public String getfIdCardPhoto() {
		return this.fIdCardPhoto;
	}

	public void setfIdCardPhoto(String fIdCardPhoto) {
		this.fIdCardPhoto = fIdCardPhoto;
	}

}