package pl.ksokolowski.movierental.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.ksokolowski.movierental.domain.Rent;
import pl.ksokolowski.movierental.domain.User;

@Repository
public class RentDAOImpl implements RentDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addRent(Rent rent) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(rent);
	}

	@Override
	public List<Rent> listRent() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Rent order by id").list();
	}

	@Override
	public void removeRent(int id) {
		// TODO Auto-generated method stub
		Rent rent = (Rent) sessionFactory.getCurrentSession().load(Rent.class, id);
		if (null != rent) {
			sessionFactory.getCurrentSession().delete(rent);
		}
	}

	@Override
	public void editRent(Rent rent) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(rent);
	}

	@Override
	public Rent getRent(int id) {
		// TODO Auto-generated method stub
		return (Rent) sessionFactory.getCurrentSession().get(Rent.class, id);
	}

}
