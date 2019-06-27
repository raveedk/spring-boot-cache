package com.ravee.springboot.cache.services;

import java.util.List;

import com.ravee.springboot.cache.entities.Company;

public interface CompanyService {
	Company get(Long id);

	Company get(String name);

	List<Company> getAll();

	void create(Company company);

	Company update(Company company);

	void delete(Long id);

	void delete(Company company);
}
