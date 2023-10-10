package com.medicine.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @Column(name = "order_id")
    private int orderid;

    @Column(name = "user_id", nullable = false)
    private int userid;

    @Column(name = "total_price")
    private int totalprice;

    @Column(name = "order_date")
    private String orderdate;

    public Orders(int orderid, int userid, int totalprice, String orderdate) {
        this.orderid = orderid;
        this.userid = userid;
        this.totalprice = totalprice;
        this.orderdate = orderdate;
    }

    public Orders() {
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }
}
