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

import tianjin.wuqing.interfaces.DeclarationServiceInterface;
import tianjin.wuqing.po.Declaration;
import tianjin.wuqing.po.LandHolder;
import tianjin.wuqing.po.TransferDeclareTrade;
import tianjin.wuqing.po.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("decalrationController")
@ParentPackage("struts-default")
@Namespace("/government")
public class DeclarationAction extends ActionSupport {
	@Resource(name = "declarationService")
	private DeclarationServiceInterface declarationService;
	private Declaration declaration;
	private LandHolder holder;
	private File contract;
	private String contractFileName;
	private List<File> attachment;
	private List<String> attachmentFileName;
	private String payId;
	private String incomeId;
	private int index;
	// 表示管理人员的角色，0为窗口工作人员（查看申请状态0、1、2），1为审核工作人员（查看状态2、3、4），2为批准工作人员（查看状态4~10）
	private int role;

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public String getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(String incomeId) {
		this.incomeId = incomeId;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public File getContract() {
		return contract;
	}

	public void setContract(File contract) {
		this.contract = contract;
	}

	public String getContractFileName() {
		return contractFileName;
	}

	public void setContractFileName(String contractFileName) {
		this.contractFileName = contractFileName;
	}

	public List<File> getAttachment() {
		return attachment;
	}

	public void setAttachment(List<File> attachment) {
		this.attachment = attachment;
	}

	public List<String> getAttachmentFileName() {
		return attachmentFileName;
	}

	public void setAttachmentFileName(List<String> attachmentFileName) {
		this.attachmentFileName = attachmentFileName;
	}

	public Declaration getDeclaration() {
		return declaration;
	}

	public void setDeclaration(Declaration declaration) {
		this.declaration = declaration;
	}

	public LandHolder getHolder() {
		return holder;
	}

	public void setHolder(LandHolder holder) {
		this.holder = holder;
	}

	/**
	 * declaractionContractUpload()方法由代理人使用，用于完成合同文件的上传操作，文件信息存放在session中
	 * 
	 * @return "next" 跳转至declaration.html填写申请信息
	 */
	@Action(value = "declaractionContractUploadAction", results = { @Result(name = "next", location = "declaration.html", type = "redirect") })
	public String declaractionContractUpload() {
		String upload = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.put("contract", contract);
		session.put("contractFileName", contractFileName);
		return "next";
	}

	/**
	 * input()方法由代理人使用，用于接收转让申请表的提交内容，将declare对象存放在session中
	 */
	@Action(value = "declarationInputAction", results = { @Result(name = "next", location = "attachmentupload.html", type = "redirect") })
	public String declarationInput() {
		declaration.setHolder(holder);
		/**
		 * 此处应添加登录用户的id,User user = session.get("user"); String id =
		 * user.getSerial();向delcaration中pulisher的存储
		 * declaration.setPublisher(...);
		 */
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.put("declare", declaration);
		return "next";
	}

	/**
	 * declaractionAttachmentUpload()由代理人使用，用于接收上传申请的附件信息，
	 * 并将文件所有文件进行declarepic目录的存放和向数据库的存储
	 * 
	 * @return
	 */
	@Action(value = "declarationAttachmentUploadAction", results = {
			@Result(name = "success", location = "main.jsp?flag=0", type = "redirect"),
			@Result(name = "failure", location = "main.jsp?flag=1", type = "redirect") })
	public String declaractionAttachmentUpload() {
		String upload = ServletActionContext.getServletContext().getRealPath(
				"/declarepic");
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		declaration = (Declaration) session.get("declare");
		//contract = (File) session.get("contract");
		//contractFileName = (String) session.get("contractFileName");
		boolean flag = declarationService.addDeclaration(declaration, upload,
				attachment, attachmentFileName);
		if (flag) {
			List<Declaration> result = declarationService
					.getDeclarationByPublisher(declaration.getPublisher());
			session.put("declares", result);
			return "success";
		} else {
			return "failure";
		}

	}

	/**
	 * showAllDeclarationByRole()方法由各类管理人员使用，可利用传递的角色值显示所有相应的申请信息
	 */
	@Action(value = "showAllDeclarationAction", results = { @Result(name = "success", location = "declarationinfo.jsp", type = "redirect") })
	public String showAllDeclarationByRole() {
		List<Declaration> result = declarationService
				.getDeclarationByRole(role);
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.put("declares", result);
		session.put("role", role);
		return "success";
	}

	/**
	 * pass()方法由窗口管理人员使用，用于完成申请文件的审核通过，需要完成三个操作:
	 * （1）利用接收的index值，从session中获得declare对象 （2）将declare对象传递给Service
	 * （3）将返回值List对象存储于session对象
	 * 
	 * @return
	 */
	@Action(value = "declarationPassAction", results = {
			@Result(name = "success", location = "declarationinfo.jsp?flag=0", type = "redirect"),
			@Result(name = "failure", location = "declarationinfo.jsp?flag=1", type = "redirect") })
	public String declarationPass() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		declaration = (Declaration) session.get("declare");
		boolean flag = declarationService.passApply(declaration);
		if (flag) {
			List<Declaration> results = this.declarationService
					.getDeclarationByRole(role);
			session.put("declares", results);
			return "success";
		} else {
			return "failure";
		}
	}

	/**
	 * reject()方法由窗口工作人员使用，用于完成申请文件的审核驳回，需要完成三个操作：
	 * （1）利用接收的index值，从session中获得declare对象 （2）将declare对象传递给Service
	 * （3）将返回值List对象存储于session对象
	 * 
	 * @return
	 */
	@Action(value = "declarationRejectAction", results = {
			@Result(name = "success", location = "declarationinfo.jsp?flag=0", type = "redirect"),
			@Result(name = "failure", location = "declarationinfo.jsp?flag=1", type = "redirect") })
	public String declarationReject() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		declaration = (Declaration) session.get("declare");
		boolean flag = declarationService.rejectApply(declaration);
		if (flag) {
			List<Declaration> results = this.declarationService
					.getDeclarationByRole(role);
			session.put("declares", results);
			return "success";
		} else {
			return "failure";
		}
	}

	/**
	 * declarationExamineSuccess()方法由管理人员使用，用于审核提交合同的通过，需要完成三个操作：
	 * （1）利用接收的index值，从session中获得declare对象 （2）将declare对象传递给Service
	 * （3）将返回值List对象存储于session对象
	 */
	@Action(value = "declarationExamineSuccessAction", results = {
			@Result(name = "success", location = "declarationinfo.jsp?flag=0", type = "redirect"),
			@Result(name = "failure", location = "declarationinfo.jsp?flag=1", type = "redirect") })
	public String declarationExamineSuccess() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		List<Declaration> declares = (List<Declaration>) session
				.get("declares");
		declaration = declares.get(index);
		boolean flag = declarationService.passExamine(declaration);
		if (flag) {
			List<Declaration> results = this.declarationService
					.getDeclarationByRole(role);
			session.put("declares", results);
			return "success";
		} else {
			return "failure";
		}
	}

	/**
	 * release()方法由管理人员使用，发布审核决定书，等待缴纳交易金，需要完成两个操作：
	 * （1）利用接收的index值，从session中获得declare对象 （2）将declare对象传递给Service
	 */
	@Action(value = "declarationReleaseExamineAction", results = {
			@Result(name = "success", location = "declarationinfo.jsp?flag=0", type = "redirect"),
			@Result(name = "failure", location = "declarationinfo.jsp?flag=1", type = "redirect") })
	public String declarationReleaseExamine() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		List<Declaration> declares = (List<Declaration>) session
				.get("declares");
		declaration = declares.get(index);
		boolean flag = declarationService.release(declaration);
		if (flag) {
			List<Declaration> results = this.declarationService
					.getDeclarationByRole(role);
			session.put("declares", results);
			return "success";
		} else {
			return "failure";
		}
	}

	/**
	 * declarationBuyerPay()方法由代理人使用，通过输入缴纳金id，从银行中获得缴纳凭证，修改申请信息状态
	 */
	@Action(value = "declarationBuyerPayAction", results = {
			@Result(name = "success", location = "mydeclarationinfo.jsp?flag=0", type = "redirect"),
			@Result(name = "failure", location = "mydeclarationinfo.jsp?flag=1", type = "redirect") })
	public String declarationBuyerPay() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		declaration = (Declaration) session.get("declare");
		TransferDeclareTrade trade = new TransferDeclareTrade();
		trade.setPayId(payId);
		declaration.setTrade(trade);
		boolean flag = declarationService.pay(declaration);
		if (flag) {
			//User user = (User) session.get("user");
			//String publisher = user.getSerial();
			String publisher = "00000000";
			List<Declaration> results = this.declarationService
					.getDeclarationByPublisher(publisher);
			session.put("declares", results);
			return "success";
		} else {
			return "failure";
		}
	}

	/**
	 * declarationSalerIncome()方法由代理人使用，通过输入收入id，从银行中获得收入凭证，修改申请信息状态
	 */
	@Action(value = "declarationSalerIncomeAction", results = {
			@Result(name = "success", location = "mydeclarationinfo.jsp?flag=0", type = "redirect"),
			@Result(name = "failure", location = "mydeclarationinfo.jsp?flag=1", type = "redirect") })
	public String declarationSalerIncome() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		declaration = (Declaration) session.get("declare");
		TransferDeclareTrade trade = declaration.getTrade();
		trade.setIncomeId(incomeId);
		declaration.setTrade(trade);
		boolean flag = declarationService.income(declaration);
		if (flag) {
			//User user = (User) session.get("user");
			//String publisher = user.getSerial();
			String publisher = "00000000";
			List<Declaration> results = this.declarationService
					.getDeclarationByPublisher(publisher);
			session.put("declares", results);
			return "success";
		} else {
			return "failure";
		}
	}

	/**
	 * publicity()方法由管理人员使用，完成交易的公示，需要完成两个操作：
	 * （1）利用接收的index值，从session中获得declare对象 （2）将declare对象传递给Service
	 */
	@Action(value = "declarationPublicityAction", results = {
			@Result(name = "success", location = "declarationinfo.jsp?flag=0", type = "redirect"),
			@Result(name = "failure", location = "declarationinfo.jsp?flag=1", type = "redirect") })
	public String declarationPublicity() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		List<Declaration> declares = (List<Declaration>) session
				.get("declares");
		declaration = declares.get(index);
		boolean flag = declarationService.publicity(declaration);
		if (flag) {
			List<Declaration> results = this.declarationService
					.getDeclarationByRole(role);
			session.put("declares", results);
			return "success";
		} else {
			return "failure";
		}
	}

	/**
	 * record()方法由管理人员使用，完成备案操作，需要完成两个操作： （1）利用接收的index值，从session中获得declare对象
	 * （2）将declare对象传递给Service
	 */
	@Action(value = "declarationRecordAction", results = {
			@Result(name = "success", location = "declarationinfo.jsp?flag=0", type = "redirect"),
			@Result(name = "failure", location = "declarationinfo.jsp?flag=1", type = "redirect") })
	public String declarationRecord() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		List<Declaration> declares = (List<Declaration>) session
				.get("declares");
		declaration = declares.get(index);
		boolean flag = declarationService.record(declaration);
		if (flag) {
			List<Declaration> results = this.declarationService
					.getDeclarationByRole(role);
			session.put("declares", results);
			return "success";
		} else {
			return "failure";
		}
	}

	/**
	 * showMyDeclarations()方法由代理人使用，用于查看自己代理的申请信息
	 * 
	 * @return
	 */
	@Action(value = "showMyDeclarationsAction", results = { @Result(name = "success", location = "mydeclarationinfo.jsp", type = "redirect") })
	public String showMyDeclarations() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		// User user = (User) session.get("user");
		// String publisher = user.getSerial();
		String publisher = "00000000";
		List<Declaration> result = declarationService
				.getDeclarationByPublisher(publisher);
		session.put("declares", result);
		return "success";
	}

}
