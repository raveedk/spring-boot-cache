package com.ravee.springboot.cache.repositories;

import java.util.List;

import com.ravee.springboot.cache.entities.Company;

public interface CompanyRepository {

	Company find(Long id);

	Company find(String name);

	List<Company> findAll();

	void create(Company company);

	Company update(Company company);

	void delete(Long id);

	void delete(Company company);
}