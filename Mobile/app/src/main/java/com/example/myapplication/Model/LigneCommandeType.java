package com.example.myapplication.Model;

public class PizzaType
{
    private Pizza pizza;
    private PizzaTypeEnum type;

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public PizzaTypeEnum getType() {
        return type;
    }

    public void setType(PizzaTypeEnum type) {
        this.type = type;
    }
}
