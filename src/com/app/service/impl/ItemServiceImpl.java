package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.service.IItemService;
@Service
public class ItemServiceImpl implements IItemService{
	@Autowired
private IItemDao itemDao;
	@Override
	public int saveitem(Item item) {
		return itemDao.saveitem(item);
	}
@Override
public List<Item> getItemsByCustId(int custId) {
	return itemDao.getItemsByCustId(custId);
}
}
