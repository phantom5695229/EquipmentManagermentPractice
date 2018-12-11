package beans;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -6011206372737614745L;
	private int id;
	private String password;
	private double money;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int id) {
		super();
		this.id = id;
	}
	
	public User(int id, String password) {
		super();
		this.id = id;
		this.password = password;
		this.money = 1000000.0;
	}

	public User(int id, String password, double money) {
		super();
		this.id = id;
		this.password = password;
		this.money = money;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", money=" + money + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	

}
