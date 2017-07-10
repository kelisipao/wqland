package tianjin.wuqing.interfaces;

import java.io.File;

import tianjin.wuqing.po.Agency;
import tianjin.wuqing.po.Financial;
import tianjin.wuqing.po.Person;
import tianjin.wuqing.po.Unit;
import tianjin.wuqing.po.User;

public interface RegisterServiceInterface {
	boolean registerUnit(Unit unit, String upload, File[] file,
			String[] fileName, String[] fileType, User user);

	boolean registerAgency(Agency agency, String upload, File[] file,
			String[] fileName, String[] fileType, User user);

	boolean registerPerson(Person person, String upload, File[] file,
			String[] fileName, String[] fileType, User user);

	boolean registerFinancial(Financial financial, String upload, File[] file,
			String[] fileName, String[] fileType, User user);

	Object getRegister(String id);

	String[] getBuyerAndSaler(String supplierId, String demanderId);
}
