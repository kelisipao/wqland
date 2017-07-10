package tianjin.wuqing.land.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tianjin.wuqing.interfaces.DeclarationDAOInterface;
import tianjin.wuqing.interfaces.DeclarationServiceInterface;
import tianjin.wuqing.po.Declaration;
import tianjin.wuqing.utils.FileToSave;

@Service("declarationService")
public class DeclarationService implements DeclarationServiceInterface {
	@Resource(name = "declarationDAO")
	private DeclarationDAOInterface declarationDAO;

	public boolean addDeclaration(Declaration declare, String upload,
			List<File> attachment, List<String> attachmentFileName) {
		String millis = System.currentTimeMillis() + "";
		String s = upload + "/" + millis;
		File dir = new File(s);
		dir.mkdir();
		//attachment.add(contract);
		//attachmentFileName.add(contractFileName);
		boolean flag = FileToSave.updateFileToDir(dir, attachment,
				attachmentFileName);
		attachmentFileName = FileToSave.getDir(attachmentFileName,
				"declarepic/" + millis);
		if (flag) {
			try {
				declare.setAllPics(attachmentFileName);
				declarationDAO.insertDeclaration(declare);
				/*
				 * List<LandTransferSupply> result = landDAO
				 * .querySupplyByHQLAndArgs(
				 * "from LandTransferSupply as land where land.supplierId = ?",
				 * new Object[] { land.getSupplierId() });
				 */
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public List<Declaration> getDeclarationByRole(int role) {
		String hql = "";
		switch (role) {
		case 0:
			hql = "from Declaration as decl where decl.status between 0 and 2";
			break;
		case 1:
			hql = "from Declaration as decl where decl.status between 2 and 4";
			break;
		case 2:
			hql = "from Declaration as decl where decl.status between 4 and 9";
			break;
		}
		return declarationDAO.queryDeclarationByHQLNoArgs(hql);
	}

	public boolean passApply(Declaration declare) {
		declare.setStatus(2);
		try {
			this.declarationDAO.updateDeclaration(declare);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean passExamine(Declaration declare) {
		declare.setStatus(4);
		try {
			this.declarationDAO.updateDeclaration(declare);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean pay(Declaration declare) {
		declare.setStatus(6);
		try {
			this.declarationDAO.updateDeclaration(declare);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean publicity(Declaration declare) {
		declare.setStatus(8);
		try {
			this.declarationDAO.updateDeclaration(declare);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean record(Declaration declare) {
		declare.setStatus(9);
		try {
			this.declarationDAO.updateDeclaration(declare);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean rejectApply(Declaration declare) {
		declare.setStatus(1);
		try {
			this.declarationDAO.updateDeclaration(declare);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean release(Declaration declare) {
		declare.setStatus(5);
		try {
			this.declarationDAO.updateDeclaration(declare);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Declaration> getDeclarationByPublisher(String publisher) {
		return this.declarationDAO.queryDeclarationByHQLAndArgs(
				"from Declaration as decl where decl.publisher = ?",
				new Object[] { publisher });
	}

	public boolean income(Declaration declare) {
		declare.setStatus(7);
		try {
			this.declarationDAO.updateDeclaration(declare);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
