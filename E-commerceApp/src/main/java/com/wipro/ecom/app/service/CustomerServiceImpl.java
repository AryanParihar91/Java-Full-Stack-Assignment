package com.wipro.ecom.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wipro.ecom.app.dto.CustomersDto;
import com.wipro.ecom.app.entity.Customers;
import com.wipro.ecom.app.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository repo;

	@Override
	public Customers addCustomer(CustomersDto c) {
		Customers cus = new Customers();

		cus.setCid(c.getCid());
		cus.setCname(c.getCname());
		cus.setEmail(c.getEmail());
		cus.setAddress(c.getAddress());

		return repo.save(cus);
	}

	@Override
	public Customers updateCustomer(CustomersDto c) {
		Customers cus = new Customers();

		cus.setCid(c.getCid());
		cus.setCname(c.getCname());
		cus.setEmail(c.getEmail());
		cus.setAddress(c.getAddress());

		return repo.save(cus);
	}

	@Override
	public Customers getByCid(int cid) {
		return repo.findById(cid).orElse(null);
	}

	@Override
	public List<Customers> getAllSorted() {
		return repo.findAll(Sort.by("cname"));
	}

	@Override
	public List<Customers> getByAddress(String city) {
		return repo.findByAddressIgnoreCase(city);
	}

}
