package tianjin.wuqing.interfaces;

import java.util.List;

public interface RegisterDAOInterface {
	int save(Object regsiter) throws Exception;

	List<Object> queryRegisterByHQLAndArgs(String hql, Object[] args);
}
