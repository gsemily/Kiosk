public enum CustomerType {
    PATRIOT(0.10),
    SOLDIER(0.05),
    STUDENT(0.03),
    REGULAR(0.00);

    private double discountRate;

    CustomerType(double discountRate) {
        this.discountRate = discountRate;
    }

    //할인율 반환
    public double getDiscountRate() {
        return discountRate;
    }
}
