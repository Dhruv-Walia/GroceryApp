package in.vibescom.groceryapp.Models;

import java.io.Serializable;

import in.vibescom.groceryapp.Constants.Constants;

public class OrderHistory implements Serializable,Constants {

    private int totalItems;
    private String orderId;
    private String orderDate;
    private String amountPaid;
    private String paymentType;
    private String custPhone;
    private String custAddress;
    private int orderStatus;

    public OrderHistory(String orderId, int items,String orderDate, String amountPaid, String paymentType,int orderStatus ,String custPhone, String custAddress){
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.amountPaid = amountPaid;
        this.paymentType = paymentType;
        this.custPhone = custPhone;
        this.custAddress = custAddress;
        this.totalItems = items;
        this.orderStatus = orderStatus;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
}
