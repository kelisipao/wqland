package tianjin.wuqing.land.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import tianjin.wuqing.interfaces.LandTransferDAOInterface;
import tianjin.wuqing.po.LandTransferSupply;

@Repository("landTransferDAO")
public class LandTransferDAO implements LandTransferDAOInterface {
	@Resource(name = "ht")
	private HibernateTemplate ht;

	public int insertLand(LandTransferSupply land) throws Exception {
		return (Integer) ht.save(land);
	}

	public List<LandTransferSupply> querySupplyByHQLAndArgs(String hql,
			Object[] args) {
		return ht.find(hql, args);
	}

	public LandTransferSupply getLandById(int id) {
		return ht.get(LandTransferSupply.class, id);
	}

	public void updateLand(LandTransferSupply land) throws DataAccessException {
		ht.update(land);
	}

	public List<LandTransferSupply> querySupplyByHQLNoArgs(String hql) {
		return ht.find(hql);
	}

}
