package starbucks.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import starbucks.model.Coffee;

import java.util.List;

@Repository
public class CoffeeDAOImpl implements CoffeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Coffee> getCoffee() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Coffee> query = currentSession.createQuery("from Coffee", Coffee.class);

        return query.getResultList();
    }

    @Override
    public void saveCoffee(Coffee coffee) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(coffee);
    }

    @Override
    public void updateCoffee(Coffee coffee) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.update(coffee);
    }

    @Override
    public void deleteCoffee(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Coffee> query = currentSession.createQuery("delete from Coffee where id=:coffeeId");

        query.setParameter("coffeeId", id);

        query.executeUpdate();
    }

    @Override
    public Coffee getOneCoffee(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Coffee.class, id);
    }
}