package pl.ksokolowski.movierental.service;

import java.util.List;

import pl.ksokolowski.movierental.domain.ProducitonYear;

public interface ProducitonYearService {
	public void addYear(ProducitonYear productionYear);
	public List<ProducitonYear> listYear();
	public ProducitonYear getYear(int id);
	public void editYear(ProducitonYear productionYear);
}
