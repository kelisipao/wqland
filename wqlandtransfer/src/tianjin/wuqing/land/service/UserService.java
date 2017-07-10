package tianjin.wuqing.land.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tianjin.wuqing.interfaces.UserDAOInterface;
import tianjin.wuqing.interfaces.UserServiceInterface;
import tianjin.wuqing.po.User;

@Service("userService")
public class UserService implements UserServiceInterface {
	@Resource(name = "userDAO")
	private UserDAOInterface userDAO;

	public User login(User user) {
		String hql = "from User as u where u.username = ? and u.password = ?";
		String username = user.getUsername();
		String password = user.getPassword();
		List<User> users = userDAO.queryUserByArgs(hql, new Object[] {
				username, password });
		if (users.size() > 0) {
			return user = users.get(0);
		} else {
			return null;
		}
	}

	public boolean register(User user) {
		try {
			userDAO.insertUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(User user) {
		try {
			userDAO.updateUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
