package dao.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import beans.BuyRecord;
import beans.Equipment;
import beans.User;
import dao.FileName;
import dao.IEquipmentDao;
import util.FileUtil;

public class EquipmentDaoImpl implements IEquipmentDao{
	ArrayList<Equipment> eqs;
	FileUtil<Equipment> fileUtil = new FileUtil<>(FileName.EQUIPMENT_FILE);
	BuyRecordDaoImpl brdi;
	UserDaoImpl udi;
	public EquipmentDaoImpl() {
		try {
			ArrayList<Equipment> temp = fileUtil.readFromFile();
			if (null != temp && temp.size() > 0) {
				eqs = temp;
			} else {
				eqs = new ArrayList<Equipment>();
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public EquipmentDaoImpl(BuyRecordDaoImpl brdi, UserDaoImpl udi) {
		super();
		this.brdi = brdi;
		this.udi = udi;
		try {
			ArrayList<Equipment> temp = fileUtil.readFromFile();
			if (null != temp && temp.size() > 0) {
				eqs = temp;
			} else {
				eqs = new ArrayList<Equipment>();
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean add(Equipment t) {
		eqs.add(t);
		try {
			fileUtil.writeToFile(eqs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remove(String name) {
		try {
			for (int i = 0; i < eqs.size(); i++) {
				if (eqs.get(i).getName().equals(name)) {
					eqs.remove(i);
					fileUtil.writeToFile(eqs);
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<Equipment> selectByJob(String job) {
		try {
			ArrayList<Equipment> temp = fileUtil.readFromFile();
			if(null != temp && temp.size()>0) {
				eqs = temp;
			}else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Equipment> temp = new ArrayList<Equipment>();
		for (int i = 0; i < eqs.size(); i++) {
			if (eqs.get(i).getJob().equals(job)) {
				temp.add(eqs.get(i));
			}
		}
		return temp;
		
	}

	@Override
	public ArrayList<Equipment> selectAll() {
		try {
			ArrayList<Equipment> temp = fileUtil.readFromFile();
			if(null != temp && temp.size()>0) {
				eqs = temp;
			}else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return eqs;
	}

	@Override
	public boolean buyEquipment(User user,String equipmentName, int buyCount) {
		Equipment eqt = new Equipment(equipmentName);
		int indexE = eqs.indexOf(eqt);
		int indexU = udi.users.indexOf(user);
		if (-1 == indexE || -1 == indexU ) {
			return false;
		}
		
		User ut = udi.users.get(indexU);
		eqt = eqs.get(indexE);
		if (ut.getMoney() >= eqt.getPrice() *buyCount && eqt.getCount() > buyCount) {
			ut.setMoney(ut.getMoney() - eqt.getPrice() * buyCount);
			udi.users.set(indexU, ut);
			eqt.setCount(eqt.getCount() - buyCount);
			eqs.set(indexE, eqt);
			BuyRecord br = new BuyRecord(ut, eqt, buyCount, LocalDateTime.now());
			brdi.add(br);
			try {
				udi.fileUitl.writeToFile(udi.users);
				fileUtil.writeToFile(eqs);
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public ArrayList<Equipment> selectByName(String name) {
		try {
			ArrayList<Equipment> temp = fileUtil.readFromFile();
			if(null != temp && temp.size()>0) {
				eqs = temp;
			}else {
				return null;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Equipment> temp = new ArrayList<Equipment>();
		for (int i = 0; i < eqs.size(); i++) {
			if (eqs.get(i).getName().equals(name)) {
				temp.add(eqs.get(i));
			}
		}
		return temp;
	}

	@Override
	public boolean replace(String name, String newName, String newJob, int newPrice, int newCount) {
		try {
			ArrayList<Equipment> temp = fileUtil.readFromFile();
			if(null != temp && temp.size()>0) {
				eqs = temp;
			}else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Equipment eqt = new Equipment(name);
		int index = eqs.indexOf(eqt);
		if (index != -1) {
			eqt.setName(newName);
			eqt.setJob(newJob);
			eqt.setPrice(newPrice);
			eqt.setCount(newCount);
			eqs.set(index, eqt);
			try {
				fileUtil.writeToFile(eqs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
		
	}

}
