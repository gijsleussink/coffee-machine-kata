import spock.lang.Specification
import spock.lang.Unroll

import static BeverageType.*

class MakingDrinksSpec extends Specification {
    InstructionsSender instructionsSender = new InstructionsSender(Mock(DrinkMaker))

    @Unroll
    void "given user wants #beverage, drink maker should receive instruction \"#instruction\""() {
        when:
        instructionsSender.send(orderWithBeverage(beverage))

        then:
        1 * instructionsSender.drinkMaker.instruct(instruction)

        where:
        beverage  | instruction
        COFFEE    | "C::"
        TEA       | "T::"
        CHOCOLATE | "H::"
    }

    @Unroll
    void "given user wants #sugar sugar, drink maker should receive instruction \"#instruction\""() {
        when:
        instructionsSender.send(orderWithSugar(sugar))

        then:
        1 * instructionsSender.drinkMaker.instruct(instruction)

        where:
        sugar | instruction
        null  | "::"
        1     | ":1:"
        2     | ":2:"

    }

    Order orderWithBeverage(BeverageType beverageType) {
        new Order.Builder().beverageType(beverageType).build()
    }

    Order orderWithSugar(Integer sugar) {
        Order.Builder orderBuilder = new Order.Builder()
        if (sugar != null) {
            orderBuilder.sugar(sugar)
        }
        orderBuilder.build()
    }
}
