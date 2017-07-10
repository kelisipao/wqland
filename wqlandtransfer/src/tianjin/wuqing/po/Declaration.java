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
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "t_declaration")
public class Declaration implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 20, nullable = false)
	private String tname;
	@Column(length = 20, nullable = false)
	private String tlegalPerson;
	@Column(length = 20, nullable = false)
	private String tid;
	@Column(length = 20, nullable = false)
	private String tphone;
	@Column(length = 20, nullable = false)
	private String tagent;
	@Column(length = 20, nullable = false)
	private String tagentId;
	@Column(length = 20, nullable = false)
	private String tagentPhone;
	@Column(length = 20, nullable = false)
	private String tagentEmail;
	@Column(length = 20, nullable = false)
	private String tagentAddr;
	@Column(length = 20, nullable = false)
	private String aname;
	@Column(length = 20, nullable = false)
	private String alegalPerson;
	@Column(length = 20, nullable = false)
	private String aid;
	@Column(length = 20, nullable = false)
	private String aphone;
	@Column(length = 20, nullable = false)
	private String aagent;
	@Column(length = 20, nullable = false)
	private String aagentId;
	@Column(length = 20, nullable = false)
	private String aagentPhone;
	@Column(length = 20, nullable = false)
	private String aagentEmail;
	@Column(length = 20, nullable = false)
	private String aagentAddr;
	@Column(length = 20, nullable = false)
	private String agentName;
	@Column(length = 20, nullable = false)
	private String agentSerial;
	@Column(length = 20, nullable = false)
	private String agentPhone;
	@Column(length = 20, nullable = false)
	private String located;
	@Column(length = 20, nullable = false)
	private String east;
	@Column(length = 20, nullable = false)
	private String west;
	@Column(length = 20, nullable = false)
	private String south;
	@Column(length = 20, nullable = false)
	private String north;
	@OneToOne(targetEntity = LandHolder.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "holder_id", nullable = true)
	private LandHolder holder;
	@Column(length = 200)
	private String other;
	@Column(nullable = false)
	private double plotRadio;
	@Column(nullable = false)
	private double high;
	@Column(nullable = false)
	private double green;
	@Column(nullable = false)
	private double buildDensity;
	@Column(length = 20, nullable = false)
	private String industryType;
	@Column(length = 20)
	private String investment;
	@Column
	private double overcome;
	@Column
	private double revenue;
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
	@Column(nullable = false)
	private double transferLandArea;
	@Column(nullable = false)
	private double transferBuildArea;
	@Column(length = 20, nullable = false)
	private String payLandType;
	@Column
	private double transferAmount;
	@Column
	private int transferYear;
	@Column(nullable = false)
	private String payType;
	@Column(length = 20, nullable = false)
	private String originalUse;
	@Column(length = 20, nullable = false)
	private String currentUse;
	@Column(length = 200, nullable = false)
	private String remark;
	@Transient
	private String promise;
	@Column(nullable = false)
	private String publisher = "00000000";
	@CollectionOfElements(targetElement = String.class, fetch = FetchType.EAGER)
	@JoinTable(name = "t_declarepic", joinColumns = @JoinColumn(name = "declaration_id"))
	@IndexColumn(name = "index_pic")
	@Column(name = "pic_dir", length = 50, nullable = false)
	private List<String> allPics;
	@Column(nullable = false)
	private int status;// 0表示等待受理，1表示受理未通过，2表示受理通过，进入审查，3表示审查未通过,等待提交补充文件，4表示审查通过，5表示审核决定书生成，等待双方缴纳交易金，6表示买方已缴纳交易金，7表示卖方已收到交易金,双方缴纳完毕，8表示公示，9表示备案（结束交易）
	@OneToOne(targetEntity = TransferDeclareTrade.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "trade_id", nullable = true)
	private TransferDeclareTrade trade;

	public TransferDeclareTrade getTrade() {
		return trade;
	}

	public void setTrade(TransferDeclareTrade trade) {
		this.trade = trade;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTlegalPerson() {
		return tlegalPerson;
	}

	public void setTlegalPerson(String tlegalPerson) {
		this.tlegalPerson = tlegalPerson;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTphone() {
		return tphone;
	}

	public void setTphone(String tphone) {
		this.tphone = tphone;
	}

	public String getTagent() {
		return tagent;
	}

	public void setTagent(String tagent) {
		this.tagent = tagent;
	}

	public String getTagentId() {
		return tagentId;
	}

	public void setTagentId(String tagentId) {
		this.tagentId = tagentId;
	}

	public String getTagentPhone() {
		return tagentPhone;
	}

	public void setTagentPhone(String tagentPhone) {
		this.tagentPhone = tagentPhone;
	}

	public String getTagentEmail() {
		return tagentEmail;
	}

	public void setTagentEmail(String tagentEmail) {
		this.tagentEmail = tagentEmail;
	}

	public String getTagentAddr() {
		return tagentAddr;
	}

	public void setTagentAddr(String tagentAddr) {
		this.tagentAddr = tagentAddr;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAlegalPerson() {
		return alegalPerson;
	}

	public void setAlegalPerson(String alegalPerson) {
		this.alegalPerson = alegalPerson;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getAphone() {
		return aphone;
	}

	public void setAphone(String aphone) {
		this.aphone = aphone;
	}

	public String getAagent() {
		return aagent;
	}

	public void setAagent(String aagent) {
		this.aagent = aagent;
	}

	public String getAagentId() {
		return aagentId;
	}

	public void setAagentId(String aagentId) {
		this.aagentId = aagentId;
	}

	public String getAagentPhone() {
		return aagentPhone;
	}

	public void setAagentPhone(String aagentPhone) {
		this.aagentPhone = aagentPhone;
	}

	public String getAagentEmail() {
		return aagentEmail;
	}

	public void setAagentEmail(String aagentEmail) {
		this.aagentEmail = aagentEmail;
	}

	public String getAagentAddr() {
		return aagentAddr;
	}

	public void setAagentAddr(String aagentAddr) {
		this.aagentAddr = aagentAddr;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAgentSerial() {
		return agentSerial;
	}

	public void setAgentSerial(String agentSerial) {
		this.agentSerial = agentSerial;
	}

	public String getAgentPhone() {
		return agentPhone;
	}

	public void setAgentPhone(String agentPhone) {
		this.agentPhone = agentPhone;
	}

	public String getLocated() {
		return located;
	}

	public void setLocated(String located) {
		this.located = located;
	}

	public String getEast() {
		return east;
	}

	public void setEast(String east) {
		this.east = east;
	}

	public String getWest() {
		return west;
	}

	public void setWest(String west) {
		this.west = west;
	}

	public String getSouth() {
		return south;
	}

	public void setSouth(String south) {
		this.south = south;
	}

	public String getNorth() {
		return north;
	}

	public void setNorth(String north) {
		this.north = north;
	}

	public LandHolder getHolder() {
		return holder;
	}

	public void setHolder(LandHolder holder) {
		this.holder = holder;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
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

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getInvestment() {
		return investment;
	}

	public void setInvestment(String investment) {
		this.investment = investment;
	}

	public double getOvercome() {
		return overcome;
	}

	public void setOvercome(double overcome) {
		this.overcome = overcome;
	}

	public double getRevenue() {
		return revenue;
	}

	public void setRevenue(double revenue) {
		this.revenue = revenue;
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

	public double getTransferLandArea() {
		return transferLandArea;
	}

	public void setTransferLandArea(double transferLandArea) {
		this.transferLandArea = transferLandArea;
	}

	public double getTransferBuildArea() {
		return transferBuildArea;
	}

	public void setTransferBuildArea(double transferBuildArea) {
		this.transferBuildArea = transferBuildArea;
	}

	public String getPayLandType() {
		return payLandType;
	}

	public void setPayLandType(String payLandType) {
		this.payLandType = payLandType;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	public int getTransferYear() {
		return transferYear;
	}

	public void setTransferYear(int transferYear) {
		this.transferYear = transferYear;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getOriginalUse() {
		return originalUse;
	}

	public void setOriginalUse(String originalUse) {
		this.originalUse = originalUse;
	}

	public String getCurrentUse() {
		return currentUse;
	}

	public void setCurrentUse(String currentUse) {
		this.currentUse = currentUse;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPromise() {
		return promise;
	}

	public void setPromise(String promise) {
		this.promise = promise;
	}

	public List<String> getAllPics() {
		return allPics;
	}

	public void setAllPics(List<String> allPics) {
		this.allPics = allPics;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

}
