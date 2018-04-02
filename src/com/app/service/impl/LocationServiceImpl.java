package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ILocationDao;
import com.app.model.Location;
import com.app.service.ILocationService;
@Service
public class LocationServiceImpl implements ILocationService {
@Autowired
	private ILocationDao ilocDao;
	@Override
	public int saveLocation(Location loc) {
		return ilocDao.saveLocation(loc);
	}

	@Override
	public void updateLocation(Location loc) {
		ilocDao.updateLocation(loc);
		
	}

	@Override
	public void deleteLocation(Integer locId) {
		ilocDao.deleteLocation(locId);
		
	}

	@Override
	public Location getLocationById(Integer locId) {
		return ilocDao.getLocationById(locId);
	}

	@Override
	public List<Location> getAllLocations() {
		return ilocDao.getAllLocations();
	}
	@Override
		public List<Object[]> getLocWiseCount() {
			return ilocDao.getLocWiseCount();
		}

}
