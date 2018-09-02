package com.metacube.advertismentwebservices.dao;

import java.util.List;

import com.metacube.advertismentwebservices.entity.Advertisement;

public interface AdvertisementDao extends BaseDao<Advertisement> {
	public List<Advertisement> getAllById(int id);
	public void updateName(String name,int id);
}
