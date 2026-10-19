# Assignment 4 — Facade

A Java pizzeria example. Each order is for one pizza: Margherita (2000 KZT) or Pepperoni (2500 KZT). There are ingredients for five pizzas. Payment and baking are simulated.

## Run

```bash
javac -d out src/pizzeria/*.java
java -cp out pizzeria.Main
```

`Main` calls only `OrderFacade.executeOrder("Pepperoni", 3000)`.

The facade gets the price from `PizzaMenu`, checks `IngredientStorage`, takes payment through `Cashier`, uses one portion of ingredients and starts `PizzaKitchen`. The client does not need to call these four classes itself. The subsystem classes can also be used separately and do not know about the facade.

## Clean Code

1. Meaningful names: `getPrice`, `pay` and `bake` explain what each method does.
2. Single responsibility: menu, stock, payment and cooking have separate classes.
3. Encapsulation: the stock and oven state are private.
4. Small methods: each method performs one short operation.
5. Error handling: an unknown pizza, empty stock or failed payment stops the order before ingredients are used.
