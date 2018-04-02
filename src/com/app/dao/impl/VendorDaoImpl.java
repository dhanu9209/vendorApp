package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IVendorDao;
import com.app.model.Vendor;

@Repository
public class VendorDaoImpl implements IVendorDao{
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveVendor(Vendor vendor) {
		return (Integer)ht.save(vendor);
	}

	@Override
	public void updateVendor(Vendor vendor) {
		ht.update(vendor);
		
	}

	@Override
	public Vendor getVendorById(int vendord) {
		return ht.get(Vendor.class, vendord);
	}

	@Override
	public List<Vendor> getAllVendors() {
		return ht.loadAll(Vendor.class);
	}

	@Override
	public void deleteVendorById(int vendorId) {
		ht.delete(new Vendor(vendorId));
	}
@Override
public List<Object[]> getVendorTypewiseount() {
		String hql="select vendorType,count(vendorId) from com.app.model.Vendor group by vendorType ";
	return ht.find(hql);
}
}
