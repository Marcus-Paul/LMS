package com.lms.TableClassess;

public class Users {
	
	private int user_id;
	private String email;
	private String password;
	private int membership_id;
	private boolean enabled;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMembership_id() {
		return membership_id;
	}
	public void setMembership_id(int membership_id) {
		this.membership_id = membership_id;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", email=" + email + ", password=" + password + ", membership_id="
				+ membership_id + ", enabled=" + enabled + "]";
	}
	
	
	
	
}
