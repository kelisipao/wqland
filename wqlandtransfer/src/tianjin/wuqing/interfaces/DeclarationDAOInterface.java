package tianjin.wuqing.interfaces;

import java.util.List;

import org.springframework.dao.DataAccessException;

import tianjin.wuqing.po.Declaration;

public interface DeclarationDAOInterface {
	int insertDeclaration(Declaration declare) throws Exception;

	List<Declaration> queryDeclarationByHQLAndArgs(String hql, Object[] args);

	void updateDeclaration(Declaration declare) throws Exception;

	Declaration getDeclarationById(int id);

	List<Declaration> queryDeclarationByHQLNoArgs(String hql);
}
