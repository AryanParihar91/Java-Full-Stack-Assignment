package com.wipro.ecom.app.service;

import java.util.List;

import com.wipro.ecom.app.dto.CustomersDto;
import com.wipro.ecom.app.entity.Customers;

public interface ICustomerService {

    Customers addCustomer(CustomersDto c);

    Customers updateCustomer(CustomersDto c);

    Customers getByCid(int cid);

    List<Customers> getAllSorted();

    List<Customers> getByAddress(String city);
}
