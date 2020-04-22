package com.talent4gig.secureapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.talent4gig.secureapp.entity.Role.RoleId;

import lombok.Data;

@Data
@Entity
@Table(name = "ruoli")
@IdClass(value = RoleId.class)
public class Role {

	@Data
	static class RoleId implements Serializable {

		private static final long serialVersionUID = 1109238120318401215L;

		private String email;
		private String role;
	}

	@Id
	@Column(name = "email")
	private String email;

	@Id
	@Column(name = "ruolo")
	private String role;
}
