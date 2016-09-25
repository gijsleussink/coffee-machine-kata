public class InstructionsSender {
    public InstructionsSender(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    DrinkMaker drinkMaker;

    public void send(Order order) {
        if (BeverageType.COFFEE.equals(order.beverageType)) {
            drinkMaker.instruct("C::");
        } else if (BeverageType.CHOCOLATE.equals(order.beverageType)) {
            drinkMaker.instruct("H::");
        } else if (BeverageType.TEA.equals(order.beverageType)) {
            drinkMaker.instruct("T::");
        }
    }
}
