package com.sanria.test.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"id","email"}))public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userId;
	@NotNull
	@Size(min = 2 , message = "Firstname must have at least 2 characters" )
	private String firstName;

	private String lastName;
	@NonNull
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",/* flags = Pattern.Flag.CASE_INSENSITIVE , */ message = "Email must have at least 2 characters" )
	@Column(unique=true)
	private String email;
	private String password;

}
