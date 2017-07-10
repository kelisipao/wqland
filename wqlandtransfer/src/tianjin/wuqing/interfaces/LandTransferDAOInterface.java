package tianjin.wuqing.interfaces;

import java.util.List;

import org.springframework.dao.DataAccessException;

import tianjin.wuqing.po.LandTransferSupply;

public interface LandTransferDAOInterface {
	int insertLand(LandTransferSupply land) throws Exception;

	List<LandTransferSupply> querySupplyByHQLAndArgs(String hql, Object[] args);

	void updateLand(LandTransferSupply land);

	LandTransferSupply getLandById(int id);

	List<LandTransferSupply> querySupplyByHQLNoArgs(String hql);
}
