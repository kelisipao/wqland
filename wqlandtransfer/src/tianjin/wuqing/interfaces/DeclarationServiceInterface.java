package tianjin.wuqing.interfaces;

import java.io.File;
import java.util.List;

import tianjin.wuqing.po.Declaration;

public interface DeclarationServiceInterface {
	boolean addDeclaration(Declaration declare, String upload,
			List<File> attachment, List<String> attachmentFileName);

	boolean passApply(Declaration declare);

	boolean rejectApply(Declaration declare);

	boolean passExamine(Declaration declare);

	boolean release(Declaration declare);

	boolean pay(Declaration declare);

	boolean income(Declaration declare);

	boolean publicity(Declaration declare);

	boolean record(Declaration declare);

	List<Declaration> getDeclarationByRole(int role);

	List<Declaration> getDeclarationByPublisher(String publisher);
}
