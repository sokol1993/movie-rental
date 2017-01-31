package pl.ksokolowski.movierental.service;

import java.util.List;

import pl.ksokolowski.movierental.domain.Rent;
import pl.ksokolowski.movierental.domain.User;

public interface RentService {

	public void addRent(Rent rent);
	public List<Rent> listRent();
	public void removeRent (int id);
	public Rent getRent(int id);
	public void editRent(Rent rent);
	
}
