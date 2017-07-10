package tianjin.wuqing.po;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "t_landtransfersupply")
public class LandTransferSupply implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false)
	private int preparer = 0;// 0表示土地使用权人，1表示代理人
	@Column(length = 20, nullable = false)
	private String contact;
	@OneToOne(targetEntity = LandHolder.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "holder_id", nullable = true)
	private LandHolder holder;
	@Column(nullable = false)
	private double plotRadio;
	@Column(nullable = false)
	private double high;
	@Column(nullable = false)
	private double green;
	@Column(nullable = false)
	private double buildDensity;
	@OneToOne(targetEntity = PlotSituation.class, fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "situation_id", nullable = true)
	private PlotSituation situation;
	@Column
	private int heat;// 0表示已接通，1表示暂未接通，2表示难接通（下同）
	@Column
	private int supplyWater;
	@Column
	private int drainWater;
	@Column
	private int gas;
	@Column
	private int communication;
	@Column
	private int passage;
	@Column
	private int elec;
	@Column(length = 200)
	private String facilities;
	@Column(length = 100)
	private String traffic;
	@CollectionOfElements(targetElement = String.class, fetch = FetchType.EAGER)
	@JoinTable(name = "t_pic", joinColumns = @JoinColumn(name = "land_id"))
	@IndexColumn(name = "index_pic")
	@Column(name = "pic_dir", length = 50, nullable = false)
	private List<String> allFilePics;
	@Column
	private int dispute;// 0表示是，1表示否，2表示其他（下同）
	@Column
	private int pledge;
	@Column
	private int hire;
	@Column
	private int idle;
	@Column
	private int seal;
	@Column
	private int source;
	@Column
	private int store;
	@Column
	private int audit;
	@Column
	private int payProof;
	@Column
	private int consent;
	@Column(length = 20, nullable = false)
	private String supplierId;
	@Column(length = 20)
	private String demanderId = "";
	@Column(nullable = false)
	private int status;// 0表示待检查，1表示检查通过，2表示检查未通过，3表示买方缴纳保证金，意向书确认中（开启意向），4表示卖方缴纳保证金意向书生成，5表示合同确认中，6表示合同生成

	public List<String> getAllFilePics() {
		return allFilePics;
	}

	public void setAllFilePics(List<String> allFilePics) {
		this.allFilePics = allFilePics;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getDemanderId() {
		return demanderId;
	}

	public void setDemanderId(String demanderId) {
		this.demanderId = demanderId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPreparer() {
		return preparer;
	}

	public void setPreparer(int preparer) {
		this.preparer = preparer;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public LandHolder getHolder() {
		return holder;
	}

	public void setHolder(LandHolder holder) {
		this.holder = holder;
	}

	public double getPlotRadio() {
		return plotRadio;
	}

	public void setPlotRadio(double plotRadio) {
		this.plotRadio = plotRadio;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getGreen() {
		return green;
	}

	public void setGreen(double green) {
		this.green = green;
	}

	public double getBuildDensity() {
		return buildDensity;
	}

	public void setBuildDensity(double buildDensity) {
		this.buildDensity = buildDensity;
	}

	public PlotSituation getSituation() {
		return situation;
	}

	public void setSituation(PlotSituation situation) {
		this.situation = situation;
	}

	public int getHeat() {
		return heat;
	}

	public void setHeat(int heat) {
		this.heat = heat;
	}

	public int getSupplyWater() {
		return supplyWater;
	}

	public void setSupplyWater(int supplyWater) {
		this.supplyWater = supplyWater;
	}

	public int getDrainWater() {
		return drainWater;
	}

	public void setDrainWater(int drainWater) {
		this.drainWater = drainWater;
	}

	public int getGas() {
		return gas;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}

	public int getCommunication() {
		return communication;
	}

	public void setCommunication(int communication) {
		this.communication = communication;
	}

	public int getPassage() {
		return passage;
	}

	public void setPassage(int passage) {
		this.passage = passage;
	}

	public int getElec() {
		return elec;
	}

	public void setElec(int elec) {
		this.elec = elec;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getTraffic() {
		return traffic;
	}

	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}

	public int getDispute() {
		return dispute;
	}

	public void setDispute(int dispute) {
		this.dispute = dispute;
	}

	public int getPledge() {
		return pledge;
	}

	public void setPledge(int pledge) {
		this.pledge = pledge;
	}

	public int getHire() {
		return hire;
	}

	public void setHire(int hire) {
		this.hire = hire;
	}

	public int getIdle() {
		return idle;
	}

	public void setIdle(int idle) {
		this.idle = idle;
	}

	public int getSeal() {
		return seal;
	}

	public void setSeal(int seal) {
		this.seal = seal;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}

	public int getAudit() {
		return audit;
	}

	public void setAudit(int audit) {
		this.audit = audit;
	}

	public int getPayProof() {
		return payProof;
	}

	public void setPayProof(int payProof) {
		this.payProof = payProof;
	}

	public int getConsent() {
		return consent;
	}

	public void setConsent(int consent) {
		this.consent = consent;
	}
}
