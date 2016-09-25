/**
 *
 */
public class Order {
    BeverageType beverageType;
    int sugar;
    boolean stick;

    private Order(Builder builder) {
        beverageType = builder.beverageType;
        sugar = builder.sugar;
        stick = builder.stick;
    }

    public static final class Builder {
        private BeverageType beverageType;
        private int sugar;
        private boolean stick;

        public Builder() {
        }

        public Builder(Order copy) {
            this.beverageType = copy.beverageType;
            this.sugar = copy.sugar;
            this.stick = copy.stick;
        }

        public Builder beverageType(BeverageType val) {
            beverageType = val;
            return this;
        }

        public Builder sugar(int val) {
            sugar = val;
            return this;
        }

        public Builder stick(boolean val) {
            stick = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
