package com.hcl.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@Column(name="user_email", length=100)
	private String userEmail;
	private String password;
	@Column(name="fullname")
	private String userFullName;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            mappedBy = "user", orphanRemoval = true)
    private Set<Task> tasks = new HashSet<>();
}