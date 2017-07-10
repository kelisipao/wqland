package tianjin.wuqing.land.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import tianjin.wuqing.interfaces.RegisterDAOInterface;

@Repository("registerDAO")
public class RegisterDAO implements RegisterDAOInterface {
	@Resource(name = "ht")
	private HibernateTemplate ht;

	public int save(Object regsiter) throws Exception {
		return (Integer) ht.save(regsiter);
	}

	public List<Object> queryRegisterByHQLAndArgs(String hql, Object[] args) {
		return ht.find(hql, args);
	}

}
