package com.mohamed.resturant.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    private List<Food> foods;

    @OneToOne(mappedBy = "cart")
	@JsonIgnore // don't return user in postman or json
    private User user;
    
    public Cart () {
    	
    }
    

    public Cart(int id, List<Food> foods, User user) {
		super();
		this.id = id;
		this.foods = foods;
		this.user = user;
	}


	public void addFood(Food food) {
        if (this.foods == null)
            foods = new ArrayList<>();
        this.foods.add(food);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
