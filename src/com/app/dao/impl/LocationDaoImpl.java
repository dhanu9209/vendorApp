package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ILocationDao;
import com.app.model.Location;
@Repository
public class LocationDaoImpl implements ILocationDao {
@Autowired
	private HibernateTemplate ht;
	@Override
	public int saveLocation(Location loc) {
		return (Integer)ht.save(loc);
	}

	@Override
	public void updateLocation(Location loc) {
		ht.update(loc);
	}

	@Override
	public void deleteLocation(Integer locId) {
		ht.delete(new Location(locId));
		
	}

	@Override
	public Location getLocationById(Integer locId) {
		return ht.get(Location.class, locId);
	}

	@Override
	public List<Location> getAllLocations() {
		return ht.loadAll(Location.class);
	}
	@Override
		public List<Object[]> getLocWiseCount() {
			String hql="Select locType,count(locId) from com.app.model.Location group by locType order by locType " ;
			return (List<Object[]>)ht.find(hql);
		}

}
