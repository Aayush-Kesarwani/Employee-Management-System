package com.aayush.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data // It internally uses @Getter, @Setter, @ToString, @RequiredArgsConstructor,
		// @EqualsAndHashCode
@Entity // Specifies that the class is an entity
@Table(name = "employees")
public class Employee {

	@Id // Specifies the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // specifies the generation strategies for the values of primary
														// keys
	private long id;
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
}
