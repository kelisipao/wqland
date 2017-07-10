package tianjin.wuqing.po;
// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * Finance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_finance"
    ,catalog="db_wuqing"
)

public class Finance  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private User user;
     private String formId;
     private Integer formDate;
     private String name;
     private String certificateType;
     private String certificateNumber;
     private String certificatePhoto;
     private String business;
     private String qualifactionType;
     private String qualifactionNumber;
     private String qualifactionPhoto;
     private String legalPerson;
     private String identityType;
     private String ientityNumber;
     private String address;
     private String postcode;
     private String phone;
     private String email;
     private String idCordPhoto;
     private Set<RegisterCheck> registerChecks = new HashSet<RegisterCheck>(0);


    // Constructors

    /** default constructor */
    public Finance() {
    }

	/** minimal constructor */
    public Finance(User user, String formId, Integer formDate, String name, String certificateType, String certificateNumber, String certificatePhoto, String business, String qualifactionType, String qualifactionNumber, String qualifactionPhoto, String legalPerson, String identityType, String ientityNumber, String address, String postcode, String phone, String email, String idCordPhoto) {
        this.user = user;
        this.formId = formId;
        this.formDate = formDate;
        this.name = name;
        this.certificateType = certificateType;
        this.certificateNumber = certificateNumber;
        this.certificatePhoto = certificatePhoto;
        this.business = business;
        this.qualifactionType = qualifactionType;
        this.qualifactionNumber = qualifactionNumber;
        this.qualifactionPhoto = qualifactionPhoto;
        this.legalPerson = legalPerson;
        this.identityType = identityType;
        this.ientityNumber = ientityNumber;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
        this.email = email;
        this.idCordPhoto = idCordPhoto;
    }
    
    /** full constructor */
    public Finance(User user, String formId, Integer formDate, String name, String certificateType, String certificateNumber, String certificatePhoto, String business, String qualifactionType, String qualifactionNumber, String qualifactionPhoto, String legalPerson, String identityType, String ientityNumber, String address, String postcode, String phone, String email, String idCordPhoto, Set<RegisterCheck> registerChecks) {
        this.user = user;
        this.formId = formId;
        this.formDate = formDate;
        this.name = name;
        this.certificateType = certificateType;
        this.certificateNumber = certificateNumber;
        this.certificatePhoto = certificatePhoto;
        this.business = business;
        this.qualifactionType = qualifactionType;
        this.qualifactionNumber = qualifactionNumber;
        this.qualifactionPhoto = qualifactionPhoto;
        this.legalPerson = legalPerson;
        this.identityType = identityType;
        this.ientityNumber = ientityNumber;
        this.address = address;
        this.postcode = postcode;
        this.phone = phone;
        this.email = email;
        this.idCordPhoto = idCordPhoto;
        this.registerChecks = registerChecks;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="userId", unique=true, nullable=false)

    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
	@OneToOne(fetch=FetchType.LAZY)@PrimaryKeyJoinColumn

    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    @Column(name="formId", nullable=false, length=20)

    public String getFormId() {
        return this.formId;
    }
    
    public void setFormId(String formId) {
        this.formId = formId;
    }
    
    @Column(name="formDate", nullable=false)

    public Integer getFormDate() {
        return this.formDate;
    }
    
    public void setFormDate(Integer formDate) {
        this.formDate = formDate;
    }
    
    @Column(name="name", nullable=false, length=30)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="certificateType", nullable=false, length=16)

    public String getCertificateType() {
        return this.certificateType;
    }
    
    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }
    
    @Column(name="certificateNumber", nullable=false, length=20)

    public String getCertificateNumber() {
        return this.certificateNumber;
    }
    
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }
    
    @Column(name="certificatePhoto", nullable=false)

    public String getCertificatePhoto() {
        return this.certificatePhoto;
    }
    
    public void setCertificatePhoto(String certificatePhoto) {
        this.certificatePhoto = certificatePhoto;
    }
    
    @Column(name="business", nullable=false, length=100)

    public String getBusiness() {
        return this.business;
    }
    
    public void setBusiness(String business) {
        this.business = business;
    }
    
    @Column(name="qualifactionType", nullable=false, length=30)

    public String getQualifactionType() {
        return this.qualifactionType;
    }
    
    public void setQualifactionType(String qualifactionType) {
        this.qualifactionType = qualifactionType;
    }
    
    @Column(name="qualifactionNumber", nullable=false, length=20)

    public String getQualifactionNumber() {
        return this.qualifactionNumber;
    }
    
    public void setQualifactionNumber(String qualifactionNumber) {
        this.qualifactionNumber = qualifactionNumber;
    }
    
    @Column(name="qualifactionPhoto", nullable=false)

    public String getQualifactionPhoto() {
        return this.qualifactionPhoto;
    }
    
    public void setQualifactionPhoto(String qualifactionPhoto) {
        this.qualifactionPhoto = qualifactionPhoto;
    }
    
    @Column(name="legalPerson", nullable=false, length=20)

    public String getLegalPerson() {
        return this.legalPerson;
    }
    
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }
    
    @Column(name="identityType", nullable=false, length=20)

    public String getIdentityType() {
        return this.identityType;
    }
    
    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }
    
    @Column(name="ientityNumber", nullable=false, length=20)

    public String getIentityNumber() {
        return this.ientityNumber;
    }
    
    public void setIentityNumber(String ientityNumber) {
        this.ientityNumber = ientityNumber;
    }
    
    @Column(name="address", nullable=false, length=50)

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="postcode", nullable=false, length=6)

    public String getPostcode() {
        return this.postcode;
    }
    
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    
    @Column(name="phone", nullable=false, length=11)

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Column(name="email", nullable=false, length=30)

    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="idCordPhoto", nullable=false, length=20)

    public String getIdCordPhoto() {
        return this.idCordPhoto;
    }
    
    public void setIdCordPhoto(String idCordPhoto) {
        this.idCordPhoto = idCordPhoto;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="finance")

    public Set<RegisterCheck> getRegisterChecks() {
        return this.registerChecks;
    }
    
    public void setRegisterChecks(Set<RegisterCheck> registerChecks) {
        this.registerChecks = registerChecks;
    }
   








}