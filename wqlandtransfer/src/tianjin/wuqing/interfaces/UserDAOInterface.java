package tianjin.wuqing.interfaces;

import java.util.List;

import tianjin.wuqing.po.User;

public interface UserDAOInterface {
	List<User> queryUserByArgs(String hql, Object[] args);

	int insertUser(User user) throws Exception;

	void updateUser(User user) throws Exception;
}
