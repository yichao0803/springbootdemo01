package com.bjgoodwill.springbootdemo01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * TravelRecord
 *
 * @Classname TravelRecord
 * @Date 2019/10/14 13:13
 * @Created by Zhangyichao
 */
@Entity(name="TravelRecord")
public class TravelRecord {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String userId;
    @Column
    private Date traveldate;
    @Column
    private double fee;
    @Column
    private Integer days;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getTraveldate() {
        return traveldate;
    }

    public void setTraveldate(Date traveldate) {
        this.traveldate = traveldate;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    @Override
    public String toString(){
        return "\"TravelRecord\":{\"id\":" +this.id+",\"userId\":\""+userId+"\",\"traveldate\":"+
                this.traveldate+",\"fee\":"+this.fee+",\"days\":"+this.days+"}";
    }
}
