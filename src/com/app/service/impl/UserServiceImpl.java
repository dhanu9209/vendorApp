package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.model.VDMSUser;
import com.app.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
  @Autowired
	private IUserDao userDao;
	
	
	@Override
	public int saveUser(VDMSUser user) {
		return userDao.saveUser(user);
	}

	@Override
	public void UpdateUser(VDMSUser user) {
    userDao.UpdateUser(user);
	}

	@Override
	public void deleteUser(int userId) {
      userDao.deleteUser(userId);
	}

	@Override
	public VDMSUser getUserByUserId(int userId) {
		return userDao.getUserByUserId(userId);
	}

	@Override
	public List<VDMSUser> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public VDMSUser getUserByUsername(String userName) {
		return userDao.getUserByUsername(userName);
	}

}
