package com.bjgoodwill.springbootdemo01.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * TravelRecord
 *
 * @author by Zhangyichao
 * @see # TravelRecord
 */
@Entity(name = "TravelRecord")
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

    /**
     * 默认构造函数
     */
    public TravelRecord() {
    }

    /**
     * 构造函数
     *
     * @param id         主键
     * @param userId     用户信息
     * @param traveldate 雇佣日期
     * @param fee        费用
     * @param days       天数
     */
    public TravelRecord(int id, String userId, Date traveldate, double fee, int days) {
        this.id = id;
        this.userId = userId;
        this.traveldate = traveldate;
        this.fee = fee;
        this.days = days;
    }

    /**
     * 获取 主键
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 主键
     *
     * @param id 返回 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取 用户信息
     *
     * @return 返回 用户信息
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置 用户信息
     *
     * @param userId 参数 用户信息
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 入职日期
     *
     * @return 返回 入职日期
     */
    public Date getTraveldate() {
        return traveldate;
    }

    /**
     * 设置 入职日期
     *
     * @param traveldate 参数 入职日期
     */
    public void setTraveldate(Date traveldate) {
        this.traveldate = traveldate;
    }

    /**
     * 获取 薪酬额度
     *
     * @return 返回 薪酬额度
     */
    public double getFee() {
        return fee;
    }

    /**
     * 设置 薪酬额度
     *
     * @param fee 参数 薪酬额度
     */
    public void setFee(double fee) {
        this.fee = fee;
    }

    /**
     * 获取 入职天数
     *
     * @return 返回 入职天数
     */
    public Integer getDays() {
        return days;
    }

    /**
     * 设置 入职天数
     *
     * @param days 参数 入职天数
     */
    public void setDays(Integer days) {
        this.days = days;
    }

    /**
     * 重写 ToString 方法 转换为名为TravelRecord的JSON对象
     *
     * @return 返回 名为TravelRecord的JSON对象
     */
    @Override
    public String toString() {
        return "\"TravelRecord\":{\"id\":" + this.id + ",\"userId\":\"" + userId + "\",\"traveldate\":" +
                this.traveldate + ",\"fee\":" + this.fee + ",\"days\":" + this.days + "}";
    }
}
