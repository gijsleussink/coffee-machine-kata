import static java.lang.String.format;
import static java.lang.String.valueOf;

public class InstructionsSender {
    public InstructionsSender(DrinkMaker drinkMaker) {
        this.drinkMaker = drinkMaker;
    }

    DrinkMaker drinkMaker;

    public void send(Order order) {

        String instruction = "";
        instruction += determineBeverageInstruction(order);
        instruction += ":" + determineSugarInstruction(order) + ":";

        drinkMaker.instruct(instruction);
    }

    private String determineSugarInstruction(Order order) {
        return order.sugar == 0 ? "" : valueOf(order.sugar);
    }

    private String determineBeverageInstruction(Order order) {
        BeverageType beverageType = order.beverageType;
        if (beverageType == null) {
            return "";
        }
        if (BeverageType.COFFEE.equals(beverageType)) {
            return "C";
        }
        if (BeverageType.CHOCOLATE.equals(beverageType)) {
            return "H";
        }
        if (BeverageType.TEA.equals(beverageType)) {
            return "T";
        }
        return "";
    }
}
