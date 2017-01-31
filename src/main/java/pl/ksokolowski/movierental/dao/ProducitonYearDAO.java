package pl.ksokolowski.movierental.dao;

import java.util.List;

import pl.ksokolowski.movierental.domain.ProducitonYear;

public interface ProducitonYearDAO {

	public void addYear(ProducitonYear productionYear);
	public List<ProducitonYear> listYear();
	public ProducitonYear getYear(int id);
	public void editYear(ProducitonYear productionYear);
}
