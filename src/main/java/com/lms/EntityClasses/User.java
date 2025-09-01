package com.lms.EntityClasses;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@OneToOne
	@JoinColumn(name = "membership_id")
	private Member member;
	
	@Column(name = "enabled")
	private boolean enabled;
	
	private Set<Role> roles;
	
	public User() {}
	
	public User(int userId, String email, String password, Member member, boolean enabled, Set<Role> roles) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.member = member;
		this.enabled = enabled;
		this.roles = roles;
	}
	
	public User(String email, String password, Member member, boolean enabled, Set<Role> roles) {
		this.email = email;
		this.password = password;
		this.member = member;
		this.enabled = enabled;
		this.roles = roles;
	}


	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "user_role",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	@Override
    public String toString() {
        return "Users [user_id=" + userId +
                ", email=" + email +
                ", membership_id=" + (member != null ? member.getMembershipId() : null) +
                ", enabled=" + enabled + "]";
    }
	
	
	
	
}
