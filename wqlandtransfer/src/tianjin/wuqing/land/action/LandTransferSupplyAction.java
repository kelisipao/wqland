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
	//��������
	private LandTransferSupply land;
	//����������
	private LandHolder holder;
	//�������
	private PlotSituation situation;
	//�ϴ�ͼƬ�ļ�����
	private List<File> allFiles;
	//�ϴ��ļ�������
	private List<String> allFilesFileName;
	//����������session�е�����
	private int index;
	//�������صķ�����Id
	private String supplierId;
	//�������ص�����Id
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
	 * ����supply()���������Ϣ��Service�з���addLand��..�����ύ����������������
	 * ��1����ȡ�ϴ��ļ��Ĵ洢Ŀ¼����upload�ļ���λ��
	 * ��2����session�л�ȡ��¼��user���󣬻����serialֵ��ע��ʱ���ɵ�ע������ʶ��������������land�����supplierId
	 * ��3��holder�����situation����ֱ�����land����
	 * ��4������addLand(..)���������������Ϣ���ύ
	 * ��5������addLand(..)�����ķ���ֵ����flag���ҳ����ת
	 * 
	 * @return "success"��ʾ��ӳɹ�����main.jsp����ʾ����������Ϣ
	 *         "failure"��ʾ���ʧ�ܣ��ص�landtransfersupply.htmlҳ��
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
	 * showMyTransferSupplyLands()�����ɹ�����/������ʹ�ã���ʾ����Լ������Ĺ�����Ϣ
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
	 * showAll()�����ɹ�����������Աʹ�ã����ڲ鿴�ϴ���ȫ��������Ϣ
	 * @return	String �����landtransferinfo.jsp����ת
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
	 * pass()�����ɹ�����������Աʹ�ã����ڽ�һ��������Ϣ״̬��Ϊ���ͨ����������Ҫ�����������:
	 * ��1����session�л����ҳ�����Ѿ�����session��һ��land����
	 * ��2����land���󴫵ݸ�Service
	 * ��3��������ֵList����洢��session����
	 * 
	 * @return String ����List�еĽ���������transferinfo.jspҳ�����ת��flag=0��ʾ״̬�޸ĳɹ���flag=1��ʾ״̬�޸�ʧ��
	 */
	@Action(value = "transferSupplyPassAction", results = {
			@Result(name = "success", location = "transferinfo.jsp?flag=0", type = "redirect"),
			@Result(name = "failure", location = "transferinfo.jsp?flag=1", type = "redirect") })
	public String pass() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		//��ҳ�����Ѿ���ɴ�session�л��һ��land���󲢽������session�Ĳ���
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
	 * reject()�������ڽ��ս�һ��������Ϣ״̬��Ϊ���δͨ�������󣬲���״̬�ĸ��Ľ���Service������ɣ���Ҫ�������������
	 * ��1�����ý��յ�indexֵ����session�л��land���� ��2����land���󴫵ݸ�Service
	 * ��3��������ֵList����洢��session����
	 * 
	 * @return
	 */
	@Action(value = "transferSupplyrejectAction", results = {})
	public String reject() {
		return "";
	}
	
	/**
	 * showConformTransferLands()�����ɹ�����/�����ߵ��ã����ڻ�ȡ���з���������������Ϣ
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
	 * transferIntentionOpen()�����������ߵ��ã������ύ���󣬽�������Ϣ״̬����Ϊ��������ȷ���С�����Ҫ�������������
	 * ��1�����ý��յ�indexֵ����session�л��land����
	 * ��2����demanderId�洢��land�����У���land���󴫵ݸ�Service ��3��������ֵList����洢��session����
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
	 * showIntetion()�����ɹ�����/�����ߵ��ã����ڻ�ȡ���������ף���Ҫ�������������
	 * ��1�������յ�supplierIdֵ���ݸ�Service ��2��������ֵList����洢��session����
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
	 * transferIntentionDetail()�����ɹ�����ʹ�ã���������������ߵĵ��ã������ڲ鿴ĳ���������ϸ��Ϣ������Ҫ����˭��
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
	 * confirmIntetion()�����ɹ��������ߵ��ã������ύ���󣬽�������Ϣ״̬����Ϊ�����������ɡ�����Ҫ�������������
	 * ��1�����ý��յ�indexֵ����session�л��land���� ��2����land���󴫵ݸ�Service
	 * ��3��������ֵList����洢��session����
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
	 * showTransferContract()�����ɹ���������/���󷢲��ߵ��ã����ڻ�ȡ�������ڽ��к�ͬȷ�ϵĽ��ף���Ҫ�������������
	 * ��1�������յ�idֵ���ݸ�Service ��2��������ֵList����洢��session����
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
	 * showTransferContract()�����ɹ�����ʹ�ã�������ת����ͬ��ʾҳ��
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
	 * openTransferContract()�����ɹ��������ߵ��ã������ύ���󣬽�������Ϣ״̬����Ϊ����ͬȷ���С�����Ҫ�������������
	 * ��1�����ý��յ�indexֵ����session�л��land���� ��2����land���󴫵ݸ�Service
	 * ��3��������ֵList����洢��session����
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
	 * confirmContract()���������󷢲��ߵ��ã������ύ���󣬽�������Ϣ״̬����Ϊ����ͬȷ�ϡ�����Ҫ�������������
	 * ��1�����ý��յ�indexֵ����session�л��land���� ��2����land���󴫵ݸ�Service
	 * ��3��������ֵList����洢��session����
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
