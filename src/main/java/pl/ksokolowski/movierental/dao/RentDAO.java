package pl.ksokolowski.movierental.dao;

import java.util.List;

import pl.ksokolowski.movierental.domain.ProducitonYear;
import pl.ksokolowski.movierental.domain.Rent;

public interface RentDAO {

	public void addRent(Rent rent);
	public List<Rent> listRent();
	public void removeRent (int id);
	public void editRent(Rent rent);
	public Rent getRent(int id);
	
}
