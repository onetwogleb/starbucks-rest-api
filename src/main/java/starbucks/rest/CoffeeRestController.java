package starbucks.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import starbucks.model.Coffee;
import starbucks.service.CoffeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoffeeRestController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/coffee")
    public List<Coffee> getCoffee(){

        return coffeeService.getCoffee();
    }

    @GetMapping("/coffee/{id}")
    public Coffee getOneCoffee(@PathVariable int id){

        Coffee coffee = coffeeService.getOneCoffee(id);

        return coffee;
    }

    @PostMapping("/coffee")
    public Coffee addCoffee(@RequestBody Coffee coffee){

        coffeeService.saveCoffee(coffee);

        return coffee;
    }

    @PutMapping("/coffee")
    public Coffee updatePlayer(@RequestBody Coffee coffee){

        coffeeService.updateCoffee(coffee);

        return coffee;
    }

    @DeleteMapping("/coffee/{id}")
    public String deleteCoffee(@PathVariable int id){

        coffeeService.deleteCoffee(id);

        return "Deleted Hot Coffee id is " + id;
    }

}
