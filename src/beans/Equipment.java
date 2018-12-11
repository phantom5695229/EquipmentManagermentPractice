package beans;

import java.io.Serializable;

public class Equipment implements Serializable {

	private static final long serialVersionUID = -3729030677667689526L;
	private String name;
	private String job;
	private int price;
	private int count;
	public Equipment() {
		super();
	}
	
	public Equipment(String name) {
		super();
		this.name = name;
	}

	public Equipment(String name, int count) {
		super();
		this.name = name;
		this.count = count;
	}

	public Equipment(String name, String job, int price, int count) {
		super();
		this.name = name;
		this.job = job;
		this.price = price;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Equipment other = (Equipment) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Equipment [name=" + name + ", job=" + job + ", price=" + price + ", count=" + count + "]";
	}
	

}
