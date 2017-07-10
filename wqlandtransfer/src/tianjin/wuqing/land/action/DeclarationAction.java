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
	// ��ʾ������Ա�Ľ�ɫ��0Ϊ���ڹ�����Ա���鿴����״̬0��1��2����1Ϊ��˹�����Ա���鿴״̬2��3��4����2Ϊ��׼������Ա���鿴״̬4~10��
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
	 * declaractionContractUpload()�����ɴ�����ʹ�ã�������ɺ�ͬ�ļ����ϴ��������ļ���Ϣ�����session��
	 * 
	 * @return "next" ��ת��declaration.html��д������Ϣ
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
	 * input()�����ɴ�����ʹ�ã����ڽ���ת���������ύ���ݣ���declare��������session��
	 */
	@Action(value = "declarationInputAction", results = { @Result(name = "next", location = "attachmentupload.html", type = "redirect") })
	public String declarationInput() {
		declaration.setHolder(holder);
		/**
		 * �˴�Ӧ��ӵ�¼�û���id,User user = session.get("user"); String id =
		 * user.getSerial();��delcaration��pulisher�Ĵ洢
		 * declaration.setPublisher(...);
		 */
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.put("declare", declaration);
		return "next";
	}

	/**
	 * declaractionAttachmentUpload()�ɴ�����ʹ�ã����ڽ����ϴ�����ĸ�����Ϣ��
	 * �����ļ������ļ�����declarepicĿ¼�Ĵ�ź������ݿ�Ĵ洢
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
	 * showAllDeclarationByRole()�����ɸ��������Աʹ�ã������ô��ݵĽ�ɫֵ��ʾ������Ӧ��������Ϣ
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
	 * pass()�����ɴ��ڹ�����Աʹ�ã�������������ļ������ͨ������Ҫ�����������:
	 * ��1�����ý��յ�indexֵ����session�л��declare���� ��2����declare���󴫵ݸ�Service
	 * ��3��������ֵList����洢��session����
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
	 * reject()�����ɴ��ڹ�����Աʹ�ã�������������ļ�����˲��أ���Ҫ�������������
	 * ��1�����ý��յ�indexֵ����session�л��declare���� ��2����declare���󴫵ݸ�Service
	 * ��3��������ֵList����洢��session����
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
	 * declarationExamineSuccess()�����ɹ�����Աʹ�ã���������ύ��ͬ��ͨ������Ҫ�������������
	 * ��1�����ý��յ�indexֵ����session�л��declare���� ��2����declare���󴫵ݸ�Service
	 * ��3��������ֵList����洢��session����
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
	 * release()�����ɹ�����Աʹ�ã�������˾����飬�ȴ����ɽ��׽���Ҫ�������������
	 * ��1�����ý��յ�indexֵ����session�л��declare���� ��2����declare���󴫵ݸ�Service
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
	 * declarationBuyerPay()�����ɴ�����ʹ�ã�ͨ��������ɽ�id���������л�ý���ƾ֤���޸�������Ϣ״̬
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
	 * declarationSalerIncome()�����ɴ�����ʹ�ã�ͨ����������id���������л������ƾ֤���޸�������Ϣ״̬
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
	 * publicity()�����ɹ�����Աʹ�ã���ɽ��׵Ĺ�ʾ����Ҫ�������������
	 * ��1�����ý��յ�indexֵ����session�л��declare���� ��2����declare���󴫵ݸ�Service
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
	 * record()�����ɹ�����Աʹ�ã���ɱ�����������Ҫ������������� ��1�����ý��յ�indexֵ����session�л��declare����
	 * ��2����declare���󴫵ݸ�Service
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
	 * showMyDeclarations()�����ɴ�����ʹ�ã����ڲ鿴�Լ������������Ϣ
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
