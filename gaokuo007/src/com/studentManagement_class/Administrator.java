package com.studentManagement_class;

import java.io.Serializable;

public class Administrator implements Serializable{
	protected String userName;
	protected String passWord;
	
	public Administrator(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Administrator [userName=" + userName + ", passWord=" + passWord + "]";
	}
	public boolean equals(Object object){
		if (object instanceof Administrator) {
			Administrator anotherAdministrator = (Administrator) object;
			if (anotherAdministrator.getUserName() == this.getUserName()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	public int hashCode() {
		Administrator admin = (Administrator) this;
        return userName.hashCode();
            
    }
}
