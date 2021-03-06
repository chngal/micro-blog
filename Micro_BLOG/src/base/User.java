package base;

import java.io.Serializable;

public class User implements Comparable<User>, Serializable {
	
	private int id;
	private String name;
	private String email;
	
	public User(int id, String name, String email){
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public int getUserId(){
		return id;
	}
	
	public String getUserName(){
		return name;
	}
	
	public String getUserEmail(){
		return email;
	}
	
	@Override
	public String toString() {
		String temp;
		temp = this.getUserId() + " " + ' ' + this.name + ' ' + this.email;
		return temp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(User otherUser) {
		// TODO Auto-generated method stub
		if(this.id > otherUser.id){return 1;}
		if(this.id < otherUser.id){return -1;}
		return 0;
	}
	

	
}
