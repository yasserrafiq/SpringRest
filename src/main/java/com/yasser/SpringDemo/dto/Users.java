package com.yasser.SpringDemo.dto;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Data
public class Users {

	@Id
	@GeneratedValue
	private int id;
	private String first_name;
	private String last_name;
	private String role;
	private boolean enabled;
	private String password;
	private String email;
	private int contact_number;
}
