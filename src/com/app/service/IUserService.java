package com.app.service;

import java.util.List;

import com.app.model.VDMSUser;

public interface IUserService {
	public int saveUser(VDMSUser user);
	public void UpdateUser(VDMSUser user);
	public void deleteUser(int userId);
	public VDMSUser getUserByUserId(int userId);
	public List<VDMSUser> getAllUsers();
	public VDMSUser getUserByUsername(String userName);
}
