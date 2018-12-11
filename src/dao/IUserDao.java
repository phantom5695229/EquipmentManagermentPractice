package dao;

import beans.User;

public interface IUserDao extends IBaseDao<User>{
	boolean regist(int id,String password);
	User login(int id,String password);
}
