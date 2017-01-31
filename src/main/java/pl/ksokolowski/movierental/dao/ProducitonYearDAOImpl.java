package pl.ksokolowski.movierental.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.ksokolowski.movierental.dao.ProducitonYearDAO;
import pl.ksokolowski.movierental.domain.ProducitonYear;
import pl.ksokolowski.movierental.domain.User;

@Repository
public class ProducitonYearDAOImpl implements ProducitonYearDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addYear(ProducitonYear productionYear) {
		sessionFactory.getCurrentSession().save(productionYear);
		
	}

	@Override
	public List<ProducitonYear> listYear() {
		return sessionFactory.getCurrentSession().createQuery("from ProducitonYear order by id").list();
	}

	@Override
	public ProducitonYear getYear(int id) {
		return (ProducitonYear) sessionFactory.getCurrentSession().get(ProducitonYear.class, id);
	}

	@Override
	public void editYear(ProducitonYear productionYear) {
		sessionFactory.getCurrentSession().update(productionYear);
	}

}
