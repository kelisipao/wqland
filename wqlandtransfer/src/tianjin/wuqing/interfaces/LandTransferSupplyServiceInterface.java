package tianjin.wuqing.interfaces;

import java.io.File;
import java.util.List;

import tianjin.wuqing.po.LandTransferSupply;

public interface LandTransferSupplyServiceInterface {
	boolean addLand(LandTransferSupply land, String upload,
			List<File> allFiles, List<String> allFilesFileName);

	List<LandTransferSupply> passLand(LandTransferSupply land);

	List<LandTransferSupply> rejectLand(LandTransferSupply land);

	List<LandTransferSupply> generateIntention(LandTransferSupply land);

	List<LandTransferSupply> confirmIntention(LandTransferSupply land);

	List<LandTransferSupply> generateContract(LandTransferSupply land);

	List<LandTransferSupply> confirmContract(LandTransferSupply land);

	List<LandTransferSupply> getAllContract(String id);

	List<LandTransferSupply> getAllIntention(String id);

	List<LandTransferSupply> showLands();

	List<LandTransferSupply> showMyLands(String supplierId);

	List<LandTransferSupply> showMyConformLands(String id);

}
