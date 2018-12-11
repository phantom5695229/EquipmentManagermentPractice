package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileUtil<T> {
	String file;
	public FileUtil(String fileName) {
		this.file = fileName;
	}
	public void writeToFile(ArrayList<T> list) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		if (null != list && list.size() > 0) {
			oos.writeObject(list);
			oos.flush();
		}
		oos.close();
		fos.close();
	}
	public ArrayList<T> readFromFile() throws IOException, ClassNotFoundException {
		if (!new File(file).exists()) {
			return null;
		}
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		if (fis.available() > 0) {
			ArrayList<T> list = (ArrayList<T>) ois.readObject();
			if (null != list && list.size() > 0) {
				ois.close();
				fis.close();
				return list;
			}
		}
		ois.close();
		fis.close();
		return null;
	}
}
