package tianjin.wuqing.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_plotsituation")
public class PlotSituation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private double transferLandArea;
	@Column
	private double transferBuildArea;
	@Column
	private double transferAmount;
	@Column
	private int transferYear;
	@Column(nullable = false)
	private int payType;// 0表示现金付款，1表示支票，2表示分期，3表示延期
	@Column(length = 20, nullable = false)
	private String east;
	@Column(length = 20, nullable = false)
	private String west;
	@Column(length = 20, nullable = false)
	private String south;
	@Column(length = 20, nullable = false)
	private String north;
	@Column(length = 100, nullable = false)
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public int getPayType() {
		return payType;
	}
	public void setPayType(int payType) {
		this.payType = payType;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
