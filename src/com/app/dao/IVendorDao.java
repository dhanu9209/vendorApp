package com.app.dao;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorDao {
public int saveVendor(Vendor vendor);
public void updateVendor(Vendor vendor);
public void deleteVendorById(int vendorId);
public Vendor getVendorById(int vendord);
public List<Vendor>getAllVendors();
public List<Object[]>getVendorTypewiseount();
}
