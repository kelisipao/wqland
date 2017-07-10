package tianjin.wuqing.interfaces;

import tianjin.wuqing.po.User;

public interface UserServiceInterface {
	User login(User user);

	boolean register(User user);
	
	boolean update(User user);
}
