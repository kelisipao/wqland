package tianjin.wuqing.land.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import tianjin.wuqing.interfaces.UserDAOInterface;
import tianjin.wuqing.po.User;

@Repository("userDAO")
public class UserDAO implements UserDAOInterface {
	@Resource(name = "ht")
	private HibernateTemplate ht;

	public List<User> queryUserByArgs(String hql, Object[] args) {
		return ht.find(hql, args);
	}

	public int insertUser(User user) {
		return (Integer) ht.save(user);
	}

	public void updateUser(User user) throws Exception {
		ht.update(user);
	}

}
