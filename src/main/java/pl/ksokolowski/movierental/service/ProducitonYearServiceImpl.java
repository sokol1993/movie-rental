package pl.ksokolowski.movierental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.ksokolowski.movierental.dao.ProducitonYearDAO;
import pl.ksokolowski.movierental.domain.ProducitonYear;
import pl.ksokolowski.movierental.service.ProducitonYearService;

@Service
public class ProducitonYearServiceImpl implements ProducitonYearService {

	@Autowired
	ProducitonYearDAO yearDAO;

	@Transactional
	@Override
	public void addYear(ProducitonYear productionYear) {
		yearDAO.addYear(productionYear);
	}

	@Transactional
	@Override
	public List<ProducitonYear> listYear() {
		return yearDAO.listYear();
	}

	@Transactional
	@Override
	public ProducitonYear getYear(int id) {
		return yearDAO.getYear(id);
	}

	@Transactional
	@Override
	public void editYear(ProducitonYear productionYear) {
		yearDAO.editYear(productionYear);
	}

}
