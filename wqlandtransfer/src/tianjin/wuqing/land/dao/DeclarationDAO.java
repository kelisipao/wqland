package tianjin.wuqing.land.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import tianjin.wuqing.interfaces.DeclarationDAOInterface;
import tianjin.wuqing.po.Declaration;

@Repository("declarationDAO")
public class DeclarationDAO implements DeclarationDAOInterface {
	@Resource(name = "ht")
	private HibernateTemplate ht;

	public Declaration getDeclarationById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertDeclaration(Declaration declare) throws Exception {
		return (Integer) ht.save(declare);
	}

	public List<Declaration> queryDeclarationByHQLAndArgs(String hql,
			Object[] args) {
		return ht.find(hql, args);
	}

	public List<Declaration> queryDeclarationByHQLNoArgs(String hql) {
		return ht.find(hql);
	}

	public void updateDeclaration(Declaration declare) throws Exception {
		ht.update(declare);
	}

}
