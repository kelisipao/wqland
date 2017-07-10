package tianjin.wuqing.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileToSave {
	/**
	 * updateFileToDir(..)�������ڽ����ļ���Ŀ¼���ϴ�����
	 * 
	 * @param dir
	 *            �ļ��ϴ�Ŀ¼
	 * @param files
	 *            ����ϴ��ļ�
	 * @param fileNames
	 *            ����ϴ��ļ����ļ���
	 * @return boolean �ϴ��ɹ�����true���ϴ������г����쳣�����ϴ�ʧ�ܣ�����false
	 */
	public static boolean updateFileToDir(File dir, List<File> files,
			List<String> fileNames) {
		int count = files.size();
		for (int i = 0; i < count; i++) {
			File toFile = new File(dir, fileNames.get(i));
			try {
				System.out.println(files.get(i));
				InputStream in = new FileInputStream(files.get(i));
				OutputStream out = new FileOutputStream(toFile);
				byte[] bytes = new byte[1024];
				int length = 0;
				while ((length = in.read(bytes)) > 0) {
					out.write(bytes, 0, length);
				}
				in.close();
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	public static List<String> getDir(List<String> fileNames, String dir) {
		int count = fileNames.size();
		List<String> newFileList = new ArrayList<String>();
		for (int i = 0; i < count; i++) {
			String fileName = fileNames.get(i);
			newFileList.add(i, dir + "/" + fileName);
		}
		return newFileList;
	}
}
