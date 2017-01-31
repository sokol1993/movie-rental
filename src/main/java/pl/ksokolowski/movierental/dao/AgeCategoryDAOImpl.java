package pl.ksokolowski.movierental.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.ksokolowski.movierental.domain.AgeCategory;





@Repository
public class AgeCategoryDAOImpl implements AgeCategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public void addAgeCategory(AgeCategory age) {
		sessionFactory.getCurrentSession().save(age);
	}

	@Override
	public List<AgeCategory> listAgeCategory() {
		return sessionFactory.getCurrentSession().createQuery("from AgeCategory order by id").list();
	}

	@Override
	public AgeCategory getAgeCategory(int id) {
		return (AgeCategory) sessionFactory.getCurrentSession().get(AgeCategory.class, id);
	}

	@Override
	public void editAgeCategory(AgeCategory age) {
		sessionFactory.getCurrentSession().update(age);	
	}

}
