package com.app.service;

import java.util.List;

import com.app.model.Item;

public interface IItemService {
	public int saveitem(Item item);
	public List<Item> getItemsByCustId(int custId);
}
