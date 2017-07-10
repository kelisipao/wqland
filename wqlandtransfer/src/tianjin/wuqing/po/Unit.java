package tianjin.wuqing.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_unit")
public class Unit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 20, nullable = false)
	private String name;
	@Column(length = 15, nullable = false)
	private String s_province;
	@Column(length = 15, nullable = false)
	private String s_city;
	@Column(length = 15, nullable = false)
	private String s_county;
	@Column(length = 4, nullable = false)
	private int certificate;
	@Column(length = 20, nullable = false, unique = true)
	private String certnumber;
	@Column(length = 40, nullable = false)
	private String certificatePic;
	@Column(length = 20, nullable = false)
	private String business;
	@Column(nullable = false, precision = 10, scale = 3)
	private double capital;
	@Column(length = 20, nullable = false)
	private String legalPerson;
	@Column(nullable = false)
	private int identity;
	@Column(length = 20, nullable = false)
	private String idSerial;
	@Column(length = 40, nullable = false)
	private String address;
	@Column(length = 10, nullable = false)
	private String postcode;
	@Column(length = 20, nullable = false)
	private String phone;
	@Column(length = 20, nullable = false)
	private String email;
	@Column(length = 40, nullable = false)
	private String idPic;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getS_province() {
		return s_province;
	}

	public void setS_province(String sProvince) {
		s_province = sProvince;
	}

	public String getS_city() {
		return s_city;
	}

	public void setS_city(String sCity) {
		s_city = sCity;
	}

	public String getS_county() {
		return s_county;
	}

	public void setS_county(String sCounty) {
		s_county = sCounty;
	}

	public int getCertificate() {
		return certificate;
	}

	public void setCertificate(int certificate) {
		this.certificate = certificate;
	}

	public String getCertnumber() {
		return certnumber;
	}

	public void setCertnumber(String certnumber) {
		this.certnumber = certnumber;
	}

	public String getCertificatePic() {
		return certificatePic;
	}

	public void setCertificatePic(String certificatePic) {
		this.certificatePic = certificatePic;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public int getIdentity() {
		return identity;
	}

	public void setIdentity(int identity) {
		this.identity = identity;
	}

	public String getIdSerial() {
		return idSerial;
	}

	public void setIdSerial(String idSerial) {
		this.idSerial = idSerial;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdPic() {
		return idPic;
	}

	public void setIdPic(String idPic) {
		this.idPic = idPic;
	}

}
