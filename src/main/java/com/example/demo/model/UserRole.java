package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user_quyen")
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_user_quyen")
	private Long idUserRole;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	User user;
	
	@ManyToOne
	@JoinColumn(name="id_quyen")
	Role role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserRole(User user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}
	
	public UserRole() {
		
	}
}
