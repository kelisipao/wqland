package tianjin.wuqing.land.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import tianjin.wuqing.interfaces.LandTransferSupplyServiceInterface;
import tianjin.wuqing.interfaces.RegisterServiceInterface;
import tianjin.wuqing.po.LandHolder;
import tianjin.wuqing.po.LandTransferSupply;
import tianjin.wuqing.po.PlotSituation;
import tianjin.wuqing.po.Unit;
import tianjin.wuqing.po.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("landTransferSupplyController")
@ParentPackage("struts-default")
@Namespace("/market")
public class LandTransferSupplyAction extends ActionSupport {
	@Resource(name = "landTransferService")
	private LandTransferSupplyServiceInterface landService;
	@Resource(name = "registerService")
	private RegisterServiceInterface registerService;
	//供给土地
	private LandTransferSupply land;
	//土地所有人
	private LandHolder holder;
	//土地情况
	private PlotSituation situation;
	//上传图片文件集合
	private List<File> allFiles;
	//上床文件名集合
	private List<String> allFilesFileName;
	//供给土地在session中的索引
	private int index;
	//供给土地的发布者Id
	private String supplierId;
	//供给土地的求购者Id
	private String demanderId;

	public List<File> getAllFiles() {
		return allFiles;
	}

	public void setAllFiles(List<File> allFiles) {
		this.allFiles = allFiles;
	}

	public List<String> getAllFilesFileName() {
		return allFilesFileName;
	}

	public void setAllFilesFileName(List<String> allFilesFileName) {
		this.allFilesFileName = allFilesFileName;
	}

	public PlotSituation getSituation() {
		return situation;
	}

	public void setSituation(PlotSituation situation) {
		this.situation = situation;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public LandHolder getHolder() {
		return holder;
	}

	public void setHolder(LandHolder holder) {
		this.holder = holder;
	}

	public LandTransferSupply getLand() {
		return land;
	}

	public void setLand(LandTransferSupply land) {
		this.land = land;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getDemanderId() {
		return demanderId;
	}

	public void setDemanderId(String demanderId) {
		this.demanderId = demanderId;
	}

	/**
	 * 方法supply()完成土地信息向Service中方法addLand（..）的提交，需完成五个操作：
	 * （1）获取上传文件的存储目录——upload文件夹位置
	 * （2）从session中获取登录的user对象，获得其serial值（注册时生成的注册对象标识），并将其填入land对象的supplierId
	 * （3）holder对象和situation对象分别填入land对象
	 * （4）调用addLand(..)方法，完成土地信息的提交
	 * （5）根据addLand(..)方法的返回值——flag完成页面跳转
	 * 
	 * @return "success"表示添加成功，在main.jsp中显示所有土地信息
	 *         "failure"表示添加失败，回到landtransfersupply.html页面
	 */
	@Action(value = "transferSupplyInputAction", results = {
			@Result(name = "success", location = "main.jsp?flag=0", type = "redirect"),
			@Result(name = "failure", location = "transfersupply.html", type = "redirect") })
	public String input() {
		String upload = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		User user = (User) session.get("user");
		land.setSupplierId(user.getSerial());
		land.setHolder(holder);
		land.setSituation(situation);
		boolean flag = landService.addLand(land, upload, allFiles,
				allFilesFileName);
		if (flag) {
			return "success";
		} else {
			return "failure";
		}
	}
	
	/**
	 * showMyTransferSupplyLands()方法由供给者/需求者使用，表示获得自己发布的供给信息
	 * @return
	 */
	@Action(value = "showMyTransferSupplyLandsAction", results = { @Result(name = "success", location = "mytransfersupplyinfo.jsp", type = "redirect") })
	public String showMyTransferSupplyLands() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		User user = (User) session.get("user");
		String id = user.getSerial();
		List<LandTransferSupply> myLands = landService.showMyLands(id);
		session.put("myLands", myLands);
		return "success";
	}
	
	/**
	 * showAll()方法由管理机构检查人员使用，用于查看上传的全部土地信息
	 * @return	String 完成向landtransferinfo.jsp的跳转
	 */

	@Action(value = "transferSupplyShowAllAction", results = { @Result(name = "showAll", location = "transferinfo.jsp", type = "redirect") })
	public String showAll() {
		List<LandTransferSupply> allLands = landService.showLands();
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.put("allLands", allLands);
		return "showAll";
	}

	/**
	 * pass()方法由管理机构检查人员使用，用于将一个土地信息状态改为检查通过的请求，需要完成三个操作:
	 * （1）从session中获得在页面中已经放入session的一个land对象
	 * （2）将land对象传递给Service
	 * （3）将返回值List对象存储于session对象
	 * 
	 * @return String 跟据List中的结果，完成向transferinfo.jsp页面的跳转，flag=0表示状态修改成功，flag=1表示状态修改失败
	 */
	@Action(value = "transferSupplyPassAction", results = {
			@Result(name = "success", location = "transferinfo.jsp?flag=0", type = "redirect"),
			@Result(name = "failure", location = "transferinfo.jsp?flag=1", type = "redirect") })
	public String pass() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		//在页面中已经完成从session中获得一个land对象并将其放入session的操作
		land = (LandTransferSupply) session.get("land");
		List<LandTransferSupply> result = landService.passLand(land);
		if (result != null) {
			session.put("lands", result);
			return "success";
		} else {
			return "failure";
		}
	}
	
	/**
	 * reject()方法用于接收将一个土地信息状态改为检查未通过的请求，并将状态的更改交给Service方法完成，需要完成三个操作：
	 * （1）利用接收的index值，从session中获得land对象 （2）将land对象传递给Service
	 * （3）将返回值List对象存储于session对象
	 * 
	 * @return
	 */
	@Action(value = "transferSupplyrejectAction", results = {})
	public String reject() {
		return "";
	}
	
	/**
	 * showConformTransferLands()方法由供给者/需求者调用，用于获取所有符合期望的土地信息
	 * @return
	 */
	@Action(value = "showConformTransferLandsAction", results = { @Result(name = "showMyConformLands", location = "transferconforminfo.jsp", type = "redirect") })
	public String showConformTransferLands() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		User user = (User) session.get("user");
		String id = user.getSerial();
		List<LandTransferSupply> myConformLands = landService
				.showMyConformLands(id);
		session.put("myConformLands", myConformLands);
		return "showMyConformLands";
	}
	
	/**
	 * transferIntentionOpen()方法由需求者调用，用于提交请求，将土地信息状态更改为“意向书确认中”，需要完成三个操作：
	 * （1）利用接收的index值，从session中获得land对象
	 * （2）将demanderId存储至land对象中，将land对象传递给Service （3）将返回值List对象存储于session对象
	 * 
	 * @return
	 */
	@Action(value = "transferIntentionOpenAction", results = { @Result(name = "success", location = "transferintentioninfo.jsp", type = "redirect") })
	public String transferIntentionOpen() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		land = (LandTransferSupply) session.get("land");
		User user = (User) session.get("user");
		String id = user.getSerial();
		land.setDemanderId(id);
		landService.generateIntention(land);
		return "success";
	}
	
	/**
	 * showIntetion()方法由供给者/需求者调用，用于获取所有意向交易，需要完成两个操作：
	 * （1）将接收的supplierId值传递给Service （2）将返回值List对象存储于session对象
	 * 
	 * @return
	 */
	@Action(value = "showMyTransferIntentionAction", results = { @Result(name = "success", location = "transferintentioninfo.jsp", type = "redirect") })
	public String showMyTransferIntention() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		User user = (User) session.get("user");
		String id = user.getSerial();
		List<LandTransferSupply> intentionLands = landService
				.getAllIntention(id);
		session.put("intentionLands", intentionLands);
		return "success";
	}
	
	/**
	 * transferIntentionDetail()方法由供给者使用（后期需加入需求者的调用），用于查看某个意向的详细信息（看看要卖给谁）
	 * @return
	 */
	@Action(value = "transferIntentionDetailAction", results = { @Result(name = "success", location = "transferintentiondetail.jsp", type = "redirect") })
	public String transferIntentionDetail() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		Object o = registerService.getRegister(demanderId);
		char c = demanderId.charAt(0);
		switch (c) {
		case '0':
			session.put("register", (Unit) o);
			break;
		}
		session.put("index", index);
		return "success";
	}

	/**
	 * confirmIntetion()方法由供给发布者调用，用于提交请求，将土地信息状态更改为“意向书生成”，需要完成三个操作：
	 * （1）利用接收的index值，从session中获得land对象 （2）将land对象传递给Service
	 * （3）将返回值List对象存储于session对象
	 * 
	 * @return
	 */
	@Action(value = "transferIntentionConfirmAction", results = { @Result(name = "success", location = "transferintentionletter.jsp", type = "redirect") })
	public String transferIntentionConfirm() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		int index = (Integer) session.get("index");
		List<LandTransferSupply> lands = (List<LandTransferSupply>) session
				.get("intentionLands");
		land = lands.get(index);
		landService.confirmIntention(land);
		String[] names = registerService.getBuyerAndSaler(land.getSupplierId(),
				land.getDemanderId());
		session.put("buyer", names[0]);
		session.put("saler", names[1]);
		session.put("land", land);
		return "success";
	}
	
	/**
	 * showTransferContract()方法由供给发布者/需求发布者调用，用于获取所有正在进行合同确认的交易，需要完成两个操作：
	 * （1）将接收的id值传递给Service （2）将返回值List对象存储于session对象
	 * 
	 * @return
	 */
	@Action(value = "showMyTransferContractAction", results = { @Result(name = "success", location = "transfercontractinfo.jsp", type = "redirect") })
	public String showMyTransferContract() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		User user = (User) session.get("user");
		String id = user.getSerial();
		List<LandTransferSupply> lands = landService.getAllContract(id);
		session.put("contractLands", lands);
		return "success";
	}
	/**
	 * showTransferContract()方法由供给者使用，用于跳转至合同显示页面
	 * @return
	 */
	
	@Action(value = "showTransferContractAction", results = { @Result(name = "success", location = "showtransfercontract.jsp", type = "redirect") })
	public String showTransferContract() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		List<LandTransferSupply> lands = (List<LandTransferSupply>) session
				.get("contractLands");
		land = lands.get(index);
		String[] names = registerService.getBuyerAndSaler(land.getSupplierId(),
				land.getDemanderId());
		session.put("buyer", names[0]);
		session.put("saler", names[1]);
		session.put("land", land);
		return "success";
	}

	/**
	 * openTransferContract()方法由供给发布者调用，用于提交请求，将土地信息状态更改为“合同确认中”，需要完成三个操作：
	 * （1）利用接收的index值，从session中获得land对象 （2）将land对象传递给Service
	 * （3）将返回值List对象存储于session对象
	 * 
	 * @return
	 */
	@Action(value = "openTransferContractAction", results = { @Result(name = "success", location = "main.jsp", type = "redirect") })
	public String openTransferContract() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		land = (LandTransferSupply) session.get("land");
		landService.generateContract(land);
		return "success";
	}

	/**
	 * confirmContract()方法由需求发布者调用，用于提交请求，将土地信息状态更改为“合同确认”，需要完成三个操作：
	 * （1）利用接收的index值，从session中获得land对象 （2）将land对象传递给Service
	 * （3）将返回值List对象存储于session对象
	 * 
	 * @return
	 */
	@Action(value = "confirmTransferContractAction", results = { @Result(name = "success", location = "main.jsp", type = "redirect") })
	public String confirmTransferContract() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		land = (LandTransferSupply) session.get("land");
		landService.confirmContract(land);
		return "success";
	}

}
