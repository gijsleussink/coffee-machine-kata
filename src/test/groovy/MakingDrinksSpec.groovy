import spock.lang.Specification
import spock.lang.Unroll

import static BeverageType.*

class MakingDrinksSpec extends Specification {
    InstructionsSender instructionsSender = new InstructionsSender(Mock(DrinkMaker))

    @Unroll
    void "given user wants #beverage, drink maker should receive instruction \"#instruction\""() {
        when:
        instructionsSender.send(new Order.Builder().beverageType(beverage).build())

        then:
        1 * instructionsSender.drinkMaker.instruct(instruction)

        where:
        beverage  | instruction
        COFFEE    | "C::"
        TEA       | "T::"
        CHOCOLATE | "H::"
    }
}
