package com.ravee.springboot.cache.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "name" }) })
@Data
@NoArgsConstructor
public class Company implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonManagedReference
	private Set<Department> departments = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "company", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Car> cars = new HashSet<>();

	public void setDepartments(Set<Department> departments) {
		this.departments.clear();
		if (departments != null) {
			this.departments.addAll(departments);
		}
	}

	public void setCars(Set<Car> cars) {
		this.cars.clear();
		if (cars != null) {
			this.cars.addAll(cars);
		}
	}

}
