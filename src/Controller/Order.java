package Controller;

public class Order {
    private String date;
    private String orderState;
    private String orderTime;
    private String paymentMethod;

    public Order(String date, String orderState, String orderTime, String paymentMethod) {
        this.date = date;
        this.orderState = orderState;
        this.orderTime = orderTime;
        this.paymentMethod = paymentMethod;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
