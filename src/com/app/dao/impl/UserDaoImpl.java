package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.Customer;
import com.app.model.VDMSUser;
@Repository
public class UserDaoImpl implements IUserDao {
@Autowired
	private HibernateTemplate  ht;
	
	
	@Override
	public int saveUser(VDMSUser user) {
		return (int)ht.save(user);
	}

	@Override
	public void UpdateUser(VDMSUser user) {
		ht.update(user);
	}

	@Override
	public void deleteUser(int userId) {
		ht.delete(new VDMSUser(userId));

	}

	@Override
	public VDMSUser getUserByUserId(int userId) {
		return ht.get(VDMSUser.class, userId);
	}

	@Override
	public List<VDMSUser> getAllUsers() {
		return ht.loadAll(VDMSUser.class);
	}

	@Override
	public VDMSUser getUserByUsername(String userName) {
		
			VDMSUser user=null;
			String hql="from com.app.model.VDMSUser where email=?";
				List<VDMSUser> userList= ht.find(hql, userName);
				if(userList!=null && userList.size()>0){
					user=userList.get(0);
				}
			return user;
		
	}

}
