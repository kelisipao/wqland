package tianjin.wuqing.land.action;

import java.io.File;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import tianjin.wuqing.interfaces.RegisterServiceInterface;
import tianjin.wuqing.interfaces.UserServiceInterface;
import tianjin.wuqing.po.Agency;
import tianjin.wuqing.po.Financial;
import tianjin.wuqing.po.Person;
import tianjin.wuqing.po.Unit;
import tianjin.wuqing.po.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Controller("registerController")
@ParentPackage("struts-default")
@Namespace(value = "/market")
public class RegisterAction extends ActionSupport {
	@Resource(name = "registerService")
	private RegisterServiceInterface registerService;
	private Unit unit;
	private Agency agency;
	private Person person;
	private Financial financial;
	private File[] filePic;
	private String[] filePicContentType;
	private String[] filePicFileName;

	public String[] getFilePicContentType() {
		return filePicContentType;
	}

	public void setFilePicContentType(String[] filePicContentType) {
		this.filePicContentType = filePicContentType;
	}

	public String[] getFilePicFileName() {
		return filePicFileName;
	}

	public void setFilePicFileName(String[] filePicFileName) {
		this.filePicFileName = filePicFileName;
	}

	public File[] getFilePic() {
		return filePic;
	}

	public void setFilePic(File[] filePic) {
		this.filePic = filePic;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public Agency getAgency() {
		return agency;
	}

	public void setAgency(Agency agency) {
		this.agency = agency;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Financial getFinancial() {
		return financial;
	}

	public void setFinancial(Financial financial) {
		this.financial = financial;
	}

	@Action(value = "unitregister", results = {
			@Result(name = "success", location = "main.jsp", type = "redirect"),
			@Result(name = "failure", location = "../unitregister.html", type = "redirect") })
	public String unitRegister() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		User user = (User) session.get("user");
		String upload = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		boolean f = registerService.registerUnit(unit, upload, filePic,
				filePicFileName, filePicContentType, user);
		if (f) {
			return "success";
		} else {
			return "failure";
		}
	}

	@Action(value = "agentregister", results = {
			@Result(name = "success", location = "../government/main.jsp", type = "redirect"),
			@Result(name = "failure", location = "../agentregister.html", type = "redirect") })
	public String agentRegister() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		User user = (User) session.get("user");
		String upload = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		boolean f = registerService.registerAgency(agency, upload, filePic,
				filePicFileName, filePicContentType, user);
		if (f) {
			return "success";
		} else {
			return "failure";
		}
	}

	@Action(value = "personalregister", results = {
			@Result(name = "success", location = "main.jsp", type = "redirect"),
			@Result(name = "failure", location = "../personalregister.html", type = "redirect") })
	public String personRegister() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		User user = (User) session.get("user");
		String upload = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		boolean f = registerService.registerPerson(person, upload, filePic,
				filePicFileName, filePicContentType, user);
		if (f) {
			return "success";
		} else {
			return "failure";
		}
	}

	@Action(value = "financialregister", results = {
			@Result(name = "success", location = "main.jsp", type = "redirect"),
			@Result(name = "failure", location = "../financialregister.html", type = "redirect") })
	public String financialRegister() {
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		User user = (User) session.get("user");
		String upload = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		boolean f = registerService.registerFinancial(financial, upload,
				filePic, filePicFileName, filePicContentType, user);
		if (f) {
			return "success";
		} else {
			return "failure";
		}
	}
}
