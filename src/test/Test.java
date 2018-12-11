package test;

import beans.Equipment;
import beans.User;
import dao.IEquipmentDao;
import dao.impl.BuyRecordDaoImpl;
import dao.impl.EquipmentDaoImpl;
import dao.impl.UserDaoImpl;

public class Test {
	public static void main(String[] args) {
		BuyRecordDaoImpl brdi = new BuyRecordDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		IEquipmentDao ied = new EquipmentDaoImpl(brdi,udi);
/*		System.out.println(udi.regist(1234, "abc"));
		System.out.println(udi.login(1234, "abc"));*/
/*		Equipment eq1 = new Equipment("��", "սʿ", 100, 10);
		Equipment eq2 = new Equipment("����", "��ʦ", 200, 30);
		Equipment eq3 = new Equipment("����", "����", 150, 20);
		Equipment eq4 = new Equipment("�̽�", "����", 150, 20);*/
/*		ied.add(eq1);
		ied.add(eq2);
		ied.add(eq3);
		ied.add(eq4);
		ied.remove("��");*/
//		System.out.println(ied.selectAll());
//		System.out.println(ied.selectByJob("����"));
//		System.out.println(ied.replace("�̽�", "ذ��", "����", 300, 30));
//		System.out.println(ied.selectByName("����"));
//		System.out.println(ied.selectAll());
//		User u3 = new User(1111, "abc");
//		System.out.println(udi.regist(1234, "abc"));
//		System.out.println(udi.regist(5678, "abc"));
//		System.out.println(udi.selectAll());
		User loginUser = udi.login(1234, "abc");
//		System.out.println(loginUser);
		System.out.println(ied.buyEquipment(loginUser, "����", 1));
		System.out.println(ied.selectAll());
		System.out.println(brdi.selectByUser(loginUser));
		loginUser = udi.login(5678, "abc");
		System.out.println(ied.buyEquipment(loginUser, "����", 5));
		System.out.println(ied.buyEquipment(loginUser, "ذ��", 3));
		System.out.println(brdi.selectByUser(loginUser));
		
		
	}
}
