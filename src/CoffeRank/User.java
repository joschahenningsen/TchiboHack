package CoffeRank;

import java.util.ArrayList;

public class User {
    int id;
    ArrayList<Coffee> coffes;


    public User(int id, ArrayList<Coffee>coffees){
        this.id = id;
        coffees.forEach(c->this.coffes.add(c));

    }
}
