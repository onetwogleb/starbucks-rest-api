package starbucks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import starbucks.dao.CoffeeDAO;
import starbucks.model.Coffee;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    private CoffeeDAO coffeeDAO;

    @Override
    @Transactional
    public List<Coffee> getCoffee() {
        return coffeeDAO.getCoffee();
    }

    @Override
    @Transactional
    public void saveCoffee(Coffee coffee) {
        coffeeDAO.saveCoffee(coffee);
    }

    @Override
    @Transactional
    public void updateCoffee(Coffee coffee) {
        coffeeDAO.updateCoffee(coffee);
    }

    @Override
    @Transactional
    public void deleteCoffee(int id) {
        coffeeDAO.deleteCoffee(id);
    }

    @Override
    @Transactional
    public Coffee getOneCoffee(int id) {
        return coffeeDAO.getOneCoffee(id);
    }
}
