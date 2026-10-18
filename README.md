# Assignment 4 — Facade pattern

A small Java program for ordering pizza. The menu has Margherita (2000 KZT) and Pepperoni (2500 KZT). One order can contain 1–3 pizzas of the same type. Payment and cooking are simulated in memory.

## Run

Requires JDK 17 or newer. From the project folder:

```bash
javac -d out src/pizzeria/*.java
java -cp out pizzeria.Main
```

`Main` demonstrates two successful orders, a rejected payment and an order rejected because there are not enough ingredients.

## Facade

The client calls `PizzeriaFacade.orderPizza(pizzaName, quantity, paidAmount)`. The facade coordinates four subsystems:

| Class | Responsibility |
| --- | --- |
| `PizzaMenu` | Stores prices and provides the recipe for each pizza. |
| `IngredientStorage` | Checks ingredient amounts and subtracts used portions from stock. |
| `PizzaKitchen` | Checks oven capacity, heats the oven and requires the correct temperature for baking. |
| `Cashier` | Checks payment, calculates change and records revenue. |

The facade checks the quantity, pizza name, ingredients and payment before changing stock or accepting money. It then heats the oven, takes ingredients, accepts payment and bakes the pizza. Expected validation errors leave stock and revenue unchanged. This is a single-threaded demonstration.

`Main` knows only the facade. Each subsystem has public methods and no reference to the facade, so another client could use those classes directly. The facade is useful because ordering a pizza takes one call instead of manually coordinating all four classes.

## Clean Code

1. **Meaningful names.** `orderPizza`, `checkAvailability` and `acceptPayment` describe what the methods do.
2. **Single responsibility.** Each subsystem has one job. The facade coordinates them and does not calculate change or update ingredient amounts itself.
3. **Encapsulation.** Stock, prices, temperature and revenue are private. The facade accepts simple values and returns a receipt string without exposing its subsystem objects.
4. **Small methods.** Checking availability and using ingredients are separate operations, which makes their purpose and order easy to follow.
5. **Error handling.** Invalid quantities, unknown pizzas, insufficient payment and missing ingredients produce clear exceptions. The client reports the error and continues with the next order.
6. **Named constants.** Oven capacity and baking temperature are constants instead of unexplained numbers inside methods.
