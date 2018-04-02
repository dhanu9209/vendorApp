package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;
@Repository
public class ItemDaoImpl implements IItemDao {
    @Autowired
	private HibernateTemplate ht;
	@Override
	public int saveitem(Item item) {
		return (Integer)ht.save(item);
	}
  @Override
public List<Item> getItemsByCustId(int custId) {
   String hql="from com.app.model.Item where customer.custId=?";
	return (List<Item>)ht.find(hql,custId);
}
}
