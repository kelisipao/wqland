package tianjin.wuqing.land.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import tianjin.wuqing.interfaces.RegisterDAOInterface;
import tianjin.wuqing.interfaces.RegisterServiceInterface;
import tianjin.wuqing.interfaces.UserDAOInterface;
import tianjin.wuqing.po.Agency;
import tianjin.wuqing.po.Financial;
import tianjin.wuqing.po.Person;
import tianjin.wuqing.po.Unit;
import tianjin.wuqing.po.User;

@Service("registerService")
public class RegisterService implements RegisterServiceInterface {
	@Resource(name = "registerDAO")
	private RegisterDAOInterface registerDAO;
	@Resource(name = "userDAO")
	private UserDAOInterface userDAO;

	public boolean registerUnit(Unit unit, String upload, File[] file,
			String[] fileName, String[] fileType, User user) {
		String serial = "0" + System.currentTimeMillis();// 0表示企业用户，1表示个人用户，2表示代理机构，3表示金融机构
		File dir = new File(upload + "/" + serial);
		dir.mkdir();
		unit.setCertificatePic("/upload/" + serial + "/" + fileName[0]);
		unit.setIdPic("/upload/" + serial + "/" + fileName[1]);
		unit.setIdSerial(serial);
		try {
			user.setSerial(serial);// user中存储serial表示user的唯一性
			File[] toFiles = new File[2];
			for (int i = 0; i < 2; i++) {
				toFiles[i] = new File(upload + "/" + serial, fileName[i]);
				InputStream in = new FileInputStream(file[i]);
				OutputStream out = new FileOutputStream(toFiles[i]);
				byte[] bytes = new byte[1024];
				int length = 0;
				while ((length = in.read(bytes)) > 0) {
					out.write(bytes, 0, length);
				}
				in.close();
				out.close();
			}
			registerDAO.save(unit);
			userDAO.updateUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String[] getBuyerAndSaler(String supplierId, String demanderId) {
		char c = supplierId.charAt(0);
		String hql = "";
		String[] names = new String[2];
		switch (c) {
		case '0':
			hql = "from Unit as u where u.idSerial = ?";
			Unit unit = (Unit) registerDAO.queryRegisterByHQLAndArgs(hql,
					new Object[] { supplierId }).get(0);
			names[0] = unit.getName();
			break;
		case '1':
			hql = "from Person as p where p.pIdSerial = ?";
			Person person = (Person) registerDAO.queryRegisterByHQLAndArgs(hql,
					new Object[] { supplierId }).get(0);
			names[0] = person.getpName();
			break;
		case '2':
			hql = "from Agency as a where a.aIdSerial = ?";
			Agency agency = (Agency) registerDAO.queryRegisterByHQLAndArgs(hql,
					new Object[] { supplierId }).get(0);
			names[0] = agency.getaName();
			break;
		case '3':
			hql = "from Financial as f where f.fIdSerial = ?";
			Financial financial = (Financial) registerDAO.queryRegisterByHQLAndArgs(hql,
					new Object[] { supplierId }).get(0);
			names[0] = financial.getfName();
			break;
		}
		
		c = demanderId.charAt(0);
		switch (c) {
		case '0':
			hql = "from Unit as u where u.idSerial = ?";
			Unit unit = (Unit) registerDAO.queryRegisterByHQLAndArgs(hql,
					new Object[] { demanderId }).get(0);
			names[1] = unit.getName();
			break;
		case '1':
			hql = "from Person as p where p.pIdSerial = ?";
			Person person = (Person) registerDAO.queryRegisterByHQLAndArgs(hql,
					new Object[] { demanderId }).get(0);
			names[1] = person.getpName();
			break;
		case '2':
			hql = "from Agency as a where a.aIdSerial = ?";
			Agency agency = (Agency) registerDAO.queryRegisterByHQLAndArgs(hql,
					new Object[] { demanderId }).get(0);
			names[1] = agency.getaName();
			break;
		case '3':
			hql = "from Financial as f where f.fIdSerial = ?";
			Financial financial = (Financial) registerDAO.queryRegisterByHQLAndArgs(hql,
					new Object[] { demanderId }).get(0);
			names[1] = financial.getfName();
			break;
		}
		return names;
	}

	public boolean registerAgency(Agency agency, String upload, File[] file,
			String[] fileName, String[] fileType, User user) {
		String serial = "2" + System.currentTimeMillis();// 0表示企业用户，1表示个人用户，2表示代理机构，3表示金融机构
		File dir = new File(upload + "/" + serial);
		dir.mkdir();
		agency.setaCertificatePhoto("/upload/" + serial + "/" + fileName[0]);
		agency.setaIdCardPhoto("/upload/" + serial + "/" + fileName[1]);
		agency.setaIdSerial(serial);
		try {
			user.setSerial(serial);// user中存储serial表示user的唯一性
			File[] toFiles = new File[2];
			for (int i = 0; i < 2; i++) {
				toFiles[i] = new File(upload + "/" + serial, fileName[i]);
				InputStream in = new FileInputStream(file[i]);
				OutputStream out = new FileOutputStream(toFiles[i]);
				byte[] bytes = new byte[1024];
				int length = 0;
				while ((length = in.read(bytes)) > 0) {
					out.write(bytes, 0, length);
				}
				in.close();
				out.close();
			}
			registerDAO.save(agency);
			userDAO.updateUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean registerPerson(Person person, String upload, File[] file,
			String[] fileName, String[] fileType, User user) {
		String serial = "1" + System.currentTimeMillis();// 0表示企业用户，1表示个人用户，2表示代理机构，3表示金融机构
		File dir = new File(upload + "/" + serial);
		dir.mkdir();
		// person.setCertificatePic("/upload/" + serial + "/" + fileName[0]);
		person.setpIdCardPhoto("/upload/" + serial + "/" + fileName[0]);
		person.setpIdSerial(serial);
		try {
			user.setSerial(serial);// user中存储serial表示user的唯一性
			File[] toFiles = new File[2];
			for (int i = 0; i < 1; i++) {
				toFiles[i] = new File(upload + "/" + serial, fileName[i]);
				InputStream in = new FileInputStream(file[i]);
				OutputStream out = new FileOutputStream(toFiles[i]);
				byte[] bytes = new byte[10240];
				int length = 0;
				while ((length = in.read(bytes)) > 0) {
					out.write(bytes, 0, length);
				}
				in.close();
				out.close();
			}
			registerDAO.save(person);
			userDAO.updateUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean registerFinancial(Financial financial, String upload,
			File[] file, String[] fileName, String[] fileType, User user) {
		String serial = "3" + System.currentTimeMillis();// 0表示企业用户，1表示个人用户，2表示代理机构，3表示金融机构
		File dir = new File(upload + "/" + serial);
		dir.mkdir();
		financial.setfCertificatePhoto("/upload/" + serial + "/" + fileName[0]);
		financial.setfIdCardPhoto("/upload/" + serial + "/" + fileName[1]);
		financial.setfIdSerial(serial);
		try {
			user.setSerial(serial);// user中存储serial表示user的唯一性
			File[] toFiles = new File[2];
			for (int i = 0; i < 2; i++) {
				toFiles[i] = new File(upload + "/" + serial, fileName[i]);
				InputStream in = new FileInputStream(file[i]);
				OutputStream out = new FileOutputStream(toFiles[i]);
				byte[] bytes = new byte[1024];
				int length = 0;
				while ((length = in.read(bytes)) > 0) {
					out.write(bytes, 0, length);
				}
				in.close();
				out.close();
			}
			registerDAO.save(financial);
			userDAO.updateUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Object getRegister(String id) {
		char c = id.charAt(0);
		String hql = "";
		switch (c) {
		case '0':
			hql = "from Unit as u  where u.idSerial = ? ";
			break;
		case '1':
			hql = "from Person as p where p.pIdSerial = ? ";
			break;
		case '2':
			hql = "from Agency as a where a.aIdSerial = ?";
			break;
		case '3':
			hql = "from Financial as financial where f.fIdSerial = ? ";
			break;
		}
		List<Object> units = registerDAO.queryRegisterByHQLAndArgs(hql,
				new Object[] { id });
		return units.get(0);
	}

}
