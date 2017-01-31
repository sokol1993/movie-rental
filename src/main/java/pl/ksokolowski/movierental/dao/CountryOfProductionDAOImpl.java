package pl.ksokolowski.movierental.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.ksokolowski.movierental.dao.CountryOfProductionDAO;
import pl.ksokolowski.movierental.domain.CountryOfProduction;
import pl.ksokolowski.movierental.domain.User;

@Repository
public class CountryOfProductionDAOImpl implements CountryOfProductionDAO {

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public void addCountry(CountryOfProduction country) {
		sessionFactory.getCurrentSession().save(country);
	}

	@Override
	public List<CountryOfProduction> listCountry() {
		return sessionFactory.getCurrentSession().createQuery("from CountryOfProduction order by id").list();
	}

	@Override
	public CountryOfProduction getCountry(int id) {
		return (CountryOfProduction) sessionFactory.getCurrentSession().get(CountryOfProduction.class, id);
	}

	@Override
	public void editCountry(CountryOfProduction country) {
		sessionFactory.getCurrentSession().update(country);
	}

}
