package dao.impl;

import java.io.IOException;
import java.util.ArrayList;

import beans.User;
import dao.FileName;
import dao.IUserDao;
import util.FileUtil;

public class UserDaoImpl implements IUserDao{
	ArrayList<User> users;
	FileUtil<User> fileUitl = new FileUtil<>(FileName.USER_FILE);
	
	
	public UserDaoImpl() {
		try {
			ArrayList<User> temp = fileUitl.readFromFile();
			if (null != temp && temp.size() > 0) {
				users = temp;
			}else {
				users = new ArrayList<User>();
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean add(User t) {
		
		try {
			users.add(t);
			fileUitl.writeToFile(users);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remove(String name) {
		return false;
	}

	@Override
	public ArrayList<User> selectByJob(String job) {
		return null;
	}

	@Override
	public ArrayList<User> selectAll() {
		try {
			ArrayList<User> temp = fileUitl.readFromFile();
			if (null != temp && temp.size() > 0) {
				users = temp;
			}else {
				return null;
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean regist(int id, String password) {
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				return false;
			}
		}
		User temp = new User(id, password);
		return add(temp);
	}

	@Override
	public User login(int id, String password) {
		try {
			ArrayList<User> temp = fileUitl.readFromFile();
			if (null != temp && temp.size() > 0) {
				users = temp;
			}else {
				return null;
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		User temp = new User(id, password);
		int index = users.indexOf(temp);
		if (index == -1) {
			return null;
		}
		temp = users.get(index);
		if (users.contains(temp)) {
			return temp;
		}else {
			return null;
		}
	}

	@Override
	public ArrayList<User> selectByName(String name) {
		return null;
	}
}
