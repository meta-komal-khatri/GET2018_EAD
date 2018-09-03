package com.metacube.advertismentwebservices.facade;

import java.util.List;

import com.metacube.advertismentwebservices.enums.*;
import com.metacube.advertismentwebservices.dao.AdvertisementDao;
import com.metacube.advertismentwebservices.dao.MYSQLAdvertisementDao;
import com.metacube.advertismentwebservices.entity.Advertisement;



public class AdvertisementFacade {
	private static AdvertisementFacade advertisementFacade = new AdvertisementFacade();
    
	AdvertisementDao advertisementDao = (AdvertisementDao) MYSQLAdvertisementDao.getInstance();
  
    
    public static AdvertisementFacade getInstance(){
    	return advertisementFacade;
    }


	public List<Advertisement> getAll() {
		return advertisementDao.getAll();
	}
	
	public List<Advertisement> getAllById(int id) {
		return advertisementDao.getAllById(id);
	}
	public Status updateName(String name,int id){
		if(advertisementDao.updateName(name, id)>0){
			return Status.UPDATED;
		}
		else{
			return Status.FAILED;
		}
	}
	public Status deleteAdvertisementById(int id){
		if(advertisementDao.deleteById(id)>0){
			return Status.DELETED;
		}
		else{
			return Status.FAILED;
		}
	}
}
