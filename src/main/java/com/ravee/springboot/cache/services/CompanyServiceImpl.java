package com.ravee.springboot.cache.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ravee.springboot.cache.entities.Company;
import com.ravee.springboot.cache.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	@Transactional(readOnly = true)
	public Company get(Long id) {
		return companyRepository.find(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Company get(String name) {
		return companyRepository.find(name);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Company> getAll() {
		return companyRepository.findAll();
	}

	@Override
	@Transactional
	public void create(Company company) {
		companyRepository.create(company);
	}

	@Override
	@Transactional
	public Company update(Company company) {
		return companyRepository.update(company);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		companyRepository.delete(id);
	}

	@Override
	@Transactional
	public void delete(Company company) {
		companyRepository.delete(company);
	}
}
