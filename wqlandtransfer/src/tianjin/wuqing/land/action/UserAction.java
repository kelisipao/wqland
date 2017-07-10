package tianjin.wuqing.land.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import tianjin.wuqing.interfaces.UserServiceInterface;
import tianjin.wuqing.po.User;

@Controller("userAction")
@ParentPackage("struts-default")
@Namespace(value = "/market")
public class UserAction extends ActionSupport {
	@Resource(name = "userService")
	private UserServiceInterface userService;
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Action(value = "login", results = {
			@Result(name = "main", location = "main.jsp", type = "redirect"),
			@Result(name = "failure", location = "../login.html", type = "redirect"),
			@Result(name = "unitregister", location = "../unitregister.html", type = "redirect"),
			@Result(name = "personalregister", location = "../personalregister.html", type = "redirect"),
			@Result(name = "agentregister", location = "../agentregister.html", type = "redirect"),
			@Result(name = "financialregister", location = "../financialregister.html", type = "redirect") })
	public String login() {
		user = userService.login(user);
		ActionContext ac = ActionContext.getContext();
		Map session = ac.getSession();
		session.put("user", user);//user对象存入session，以保证登录后的操作能够获得user中的serial
		if (user == null) {
			return "failure";
		} else if (user.getSerial() == null) {
			int type = user.getType();
			String url = "";
			switch (type) {
			case 0:
				url = "unitregister";
				break;
			case 1:
				url = "personalregister";
				break;
			case 2:
				url = "agentregister";
				break;
			case 3:
				url = "financialregister";
				break;
			}
			return url;
		} else {
			return "main";
		}
	}

	@Action(value = "registerUser", results = {
			@Result(name = "success", location = "../login.html", type = "redirect"),
			@Result(name = "failure", location = "../register.html", type = "redirect") })
	public String register() {
		boolean f = userService.register(user);
		if (f) {
			return "success";
		} else {
			return "failure";
		}
	}
}
