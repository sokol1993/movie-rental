package pl.ksokolowski.movierental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ksokolowski.movierental.dao.RentDAO;
import pl.ksokolowski.movierental.dao.UserDAO;
import pl.ksokolowski.movierental.domain.Rent;

@Service
public class RentServiceImpl implements RentService{

	
	@Autowired
	RentDAO rentDAO;
	
	@Override
	@Transactional
	public void addRent(Rent rent) {
		// TODO Auto-generated method stub
		rentDAO.addRent(rent);
	}

	@Override
	@Transactional
	public List<Rent> listRent() {
		// TODO Auto-generated method stub
		return rentDAO.listRent();
	}

	@Override
	@Transactional
	public void removeRent(int id) {
		// TODO Auto-generated method stub
		rentDAO.removeRent(id);
	}

	@Override
	@Transactional
	public Rent getRent(int id) {
		// TODO Auto-generated method stub
		return rentDAO.getRent(id);
	}

	@Override
	@Transactional
	public void editRent(Rent rent) {
		// TODO Auto-generated method stub
		rentDAO.editRent(rent);
	}

}
