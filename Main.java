
interface Pizza {
    double getCost();
    String getDescription();
}

class PlainPizza implements Pizza {
    @Override
    public double getCost() {
        return 5.0;
    }
    @Override
    public String getDescription() {
        return "plain dough&sauce";
    }
}

abstract class PizzaDecorator implements Pizza {
    protected final Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }
}

class Cheese extends PizzaDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", cheese";
    }
}

class Pineapple extends PizzaDecorator {
    public Pineapple(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.5;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", pineapple";
    }
}

class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", olives";
    }
}

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pineapple(new Olives(new Cheese(new PlainPizza())));
        Pizza pizza1 = new Olives(new Pineapple(new PlainPizza()));
        Pizza pizza2 = new Pineapple(new Cheese(new PlainPizza()));

        System.out.println("Pizza: "+pizza.getDescription());
        System.out.printf("Total:"+"$%.2f%n",pizza.getCost());
        System.out.println();
        System.out.println("Pizza1: "+pizza1.getDescription());
        System.out.printf("Total1: "+"$%.2f%n",pizza1.getCost());
        System.out.println();
        System.out.println("Pizza2: "+pizza2.getDescription());
        System.out.printf("Total2: "+"$%.2f%n",pizza2.getCost());
    }
}