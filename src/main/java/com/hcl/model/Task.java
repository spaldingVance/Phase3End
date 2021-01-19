package com.hcl.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="name")
	private String taskName;
	@Column(name="startdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date taskStartDate;
	@Column(name="enddate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date taskEndDate;
	@Column(name="description")
	private String taskDescription;
	@Column(name="severity")
	private String taskSeverity;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "user_email")
    private User user;
	
}          
