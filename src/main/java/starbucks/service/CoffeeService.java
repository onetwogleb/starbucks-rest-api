package starbucks.service;

import starbucks.model.Coffee;

import java.util.List;

public interface CoffeeService {

    List<Coffee> getCoffee();
    Coffee getOneCoffee(int id);
    void saveCoffee(Coffee coffee);
    void updateCoffee(Coffee coffee);
    void deleteCoffee(int id);

}
