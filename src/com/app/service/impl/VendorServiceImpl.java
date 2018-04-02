package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;
import com.app.service.IVendorService;

@Service
public class VendorServiceImpl implements IVendorService {
	@Autowired
private IVendorDao vendorDao;

	@Override
	public int saveVendor(Vendor vendor) {
		return vendorDao.saveVendor(vendor);
	}

	@Override
	public void updateVendor(Vendor vendor) {
    vendorDao.updateVendor(vendor);		
	}

	@Override
	public void deleteVendorById(int vendorId) {
		vendorDao.deleteVendorById(vendorId);
	}

	@Override
	public Vendor getVendorById(int vendord) {
		
		return vendorDao.getVendorById(vendord);
	}

	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return vendorDao.getAllVendors();
	}
@Override
public List<Object[]> getVendorTypewiseount() {
	// TODO Auto-generated method stub
	return vendorDao.getVendorTypewiseount();
}
}
