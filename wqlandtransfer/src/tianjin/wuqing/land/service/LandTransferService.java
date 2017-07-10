package tianjin.wuqing.land.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import tianjin.wuqing.interfaces.LandTransferDAOInterface;
import tianjin.wuqing.interfaces.LandTransferSupplyServiceInterface;
import tianjin.wuqing.po.LandTransferSupply;
import tianjin.wuqing.utils.FileToSave;

@Service("landTransferService")
public class LandTransferService implements LandTransferSupplyServiceInterface {
	@Resource(name = "landTransferDAO")
	private LandTransferDAOInterface landDAO;

	/**
	 * addLand(..)����������ɹ���������Ϣ����Ӻ��ļ����ϴ��������ع����ύ���ϴ�������������Ϣ
	 * 
	 * @param land
	 *            ����洢��������Ϣ
	 * @param upload
	 *            �����ļ��ϴ��Ĵ洢Ŀ¼
	 * @param agenetFile
	 *            �����ϴ��Ĵ�����֤���ļ�
	 * @param agentFileFileName
	 *            �����ϴ��Ĵ�����֤���ļ���
	 * @param sceneFile
	 *            �����ϴ��������ֳ���Ƭ
	 * @param sceneFileFileName
	 *            �����ϴ��������ֳ���Ƭ��
	 * @param sourceProofFile
	 *            �����ϴ���������Դ֤���ļ�
	 * @param sourceProofFileFileName
	 *            �����ϴ���������Դ֤���ļ���
	 * @param idProofFile
	 *            ��������ʹ��Ȩ�����֤��
	 * @param idProofFileFileName
	 *            ��������ʹ��Ȩ�����֤���ļ���
	 * @param agreeTransferFile
	 *            Ȩ����ͬ��ת������֤��
	 * @param agreeTransferFileFileName
	 *            Ȩ����ͬ��ת������֤���ļ���
	 * @param otherFiles
	 *            ������ز����ļ�
	 * @param otherFilesFileName
	 *            ������ز����ļ���
	 * @return List<LandTransferSupply> ��ʾ��ǰ���ع����ύ�˵��ϴ�������������Ϣ
	 * 
	 *         ������Ҫ��������ĸ������� ��1������upload�������ϴ��ļ���
	 *         ��2�������Ĵ�updateFileToDir(..)�������ֱ����agenetFile
	 *         ��sceneFile��sourceProofFile
	 *         ��idProofFile��agreeTransferFile��otherFiles���ϴ�����
	 *         ��3���ϴ��ɹ��󣬽��ϴ��ļ��ĵ�ַ�洢��land�����У�֮�󣬽�land��״̬�޸�Ϊ����飨0ֵ��Ҳ��Ĭ��ֵ��
	 *         ��4����land���󴫵ݸ�DAO����������ݿ�Ĵ洢
	 *         ��5���洢�ɹ�������DAO�еķ�������land�е�supplierIdΪ��������ѯ�ύ�����е�������Ϣ������List
	 */
	public boolean addLand(LandTransferSupply land, String upload,
			List<File> allFiles, List<String> allFilesFileName) {
		String millis = System.currentTimeMillis() + "";
		String s = upload + "/" + millis;
		File dir = new File(s);
		dir.mkdir();
		boolean flag = FileToSave.updateFileToDir(dir, allFiles,
				allFilesFileName);
		allFilesFileName = FileToSave.getDir(allFilesFileName, "upload/"
				+ millis);
		if (flag) {
			try {
				land.setAllFilePics(allFilesFileName);
				landDAO.insertLand(land);
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

	private int changeStatus(int status, int oper) {
		if (oper == 0) {
			status++;
		} else {
			status--;
		}
		return status;
	}

	/**
	 * confirmContract(..)�������ڽ�land״̬��Ϊ��ͬȷ��
	 * 
	 * @param land
	 *            ������޸�״̬��������Ϣ
	 * @return List<LandTransferSupply> �����������������ڽ��н��׵�������Ϣ ��Ҫ����������
	 *         ��1�����land�е�״ֵ̬������changeStatus()������ʹ״̬��1 ��2������DAO�������land����
	 *         ��3������land��demanderId��ֵ��status=6Ϊ��������ѯ����������������ڽ��еĽ���
	 */
	public List<LandTransferSupply> confirmContract(LandTransferSupply land) {
		int status = land.getStatus();
		land.setStatus(status + 1);
		try {
			landDAO.updateLand(land);
			return landDAO
					.querySupplyByHQLAndArgs(
							"from LandTransferSupply as land where (land.supplierId= ? or land.demanderId = ?) and land.status = 6",
							new Object[] { land.getSupplierId(),
									land.getDemanderId() });
		} catch (DataAccessException e) {
			return null;
		}
	}

	/**
	 * confirmIntention(..)�������ڽ�land״̬��Ϊ��������
	 * 
	 * @param land
	 *            ������޸�״̬��������Ϣ
	 * @return List<LandTransferSupply> ���ع��������е�������Ϣ ��Ҫ����������
	 *         ��1�����land�е�״ֵ̬������changeStatus()������ʹ״̬��1 ��2������DAO�������land����
	 *         ��3������land��supplierId��ֵ��status=4Ϊ��������ѯ��ù�����������������Ľ���
	 */
	public List<LandTransferSupply> confirmIntention(LandTransferSupply land) {
		int status = land.getStatus();
		land.setStatus(status + 1);
		try {
			landDAO.updateLand(land);
			return this.showLands();
		} catch (DataAccessException e) {
			return null;
		}
	}

	/**
	 * generateContract(..)�������ڽ�land״̬��Ϊ��ͬȷ����
	 * 
	 * @param land
	 *            ������޸�״̬��������Ϣ
	 * @return List<LandTransferSupply> ���ع��������е�������Ϣ ��Ҫ����������
	 *         ��1�����land�е�״ֵ̬������changeStatus()������ʹ״̬��1 ��2������DAO�������land����
	 *         ��3������land��supplierId��ֵ��status=5Ϊ��������ѯ��ù������������ڽ��еĽ���
	 */
	public List<LandTransferSupply> generateContract(LandTransferSupply land) {
		int status = land.getStatus();
		land.setStatus(status + 1);
		landDAO.updateLand(land);
		return landDAO
				.querySupplyByHQLAndArgs(
						"from LandTransferSupply as land where land.supplierId= ? and land.status = 5",
						new Object[] { land.getSupplierId() });
	}

	/**
	 * generateIntention(..)�������ڽ�land״̬��Ϊ����������ȷ����
	 * 
	 * @param land
	 *            ������޸�״̬��������Ϣ
	 * @return List<LandTransferSupply> �������������е�������Ϣ ��Ҫ����������
	 *         ��1�����land�е�״ֵ̬������changeStatus()������ʹ״̬��1 ��2������DAO�������land����
	 *         ��3������land��demanderId��ֵ��status=3Ϊ��������ѯ������������е��н��������������Ϣ
	 */
	public List<LandTransferSupply> generateIntention(LandTransferSupply land) {
		int status = land.getStatus();
		land.setStatus(status + 2);
		try {
			landDAO.updateLand(land);
			return this.showLands();
		} catch (DataAccessException e) {
			return null;
		}
	}

	/**
	 * getAllContract(..)�������ڻ�����н����еĽ���
	 * 
	 * @param id
	 *            ��ʾ������/��������land�е�supplierId/demanderIdֵ
	 * @return List<LandTransferSupply> ���ع�����/�������������ڽ��еĽ���
	 *         ֱ��ͨ��DAO�����ȡ���ڽ��׵���Ϣ����ѯ����ΪsupplierId=id or demanderId=id and status
	 *         = 5 or status = 6
	 */
	public List<LandTransferSupply> getAllContract(String id) {
		return landDAO
				.querySupplyByHQLAndArgs(
						"from LandTransferSupply as land where (land.supplierId = ? or land.demanderId = ?) and (land.status between 4 and 6)",
						new Object[] { id, id });
	}

	/**
	 * getAllIntention(..)�������ڻ������������
	 * 
	 * @param id
	 *            ��ʾ������/��������land�е�supplierId/demanderIdֵ
	 * @return List<LandTransferSupply> ���ع�����/����������������
	 *         ֱ��ͨ��DAO�����ȡ�����׵���Ϣ����ѯ����ΪsupplierId=id or demanderId=id and status
	 *         = 3 or status = 4
	 */
	public List<LandTransferSupply> getAllIntention(String id) {
		return landDAO
				.querySupplyByHQLAndArgs(
						"from LandTransferSupply as land where (land.supplierId = ? or land.demanderId = ?) and land.status = 3",
						new Object[] { id, id });
	}

	public List<LandTransferSupply> passLand(LandTransferSupply land) {
		int status = land.getStatus();
		land.setStatus(status + 1);
		try {
			landDAO.updateLand(land);
			return this.showLands();
		} catch (DataAccessException e) {
			return null;
		}
	}

	public List<LandTransferSupply> rejectLand(LandTransferSupply land) {
		int status = land.getStatus();
		land.setStatus(status + 2);
		try {
			landDAO.updateLand(land);
			return this.showLands();
		} catch (DataAccessException e) {
			return null;
		}
	}

	public List<LandTransferSupply> showLands() {
		return landDAO.querySupplyByHQLNoArgs("from LandTransferSupply");
	}

	public List<LandTransferSupply> showMyLands(String supplierId) {
		return landDAO.querySupplyByHQLAndArgs(
				"from LandTransferSupply as land where land.supplierId = ?",
				new Object[] { supplierId });
	}

	public List<LandTransferSupply> showMyConformLands(String id) {
		return landDAO
				.querySupplyByHQLAndArgs(
						"from LandTransferSupply as land where land.supplierId != ? and land.demanderId != ? and status = 1",
						new Object[] { id, id });
	}

}
