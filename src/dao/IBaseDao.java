package dao;

import java.util.ArrayList;

public interface IBaseDao<T> {
	boolean add(T t);
	boolean remove(String name);
	ArrayList<T> selectByJob(String job);
	ArrayList<T> selectByName(String name);
	ArrayList<T> selectAll();
}
