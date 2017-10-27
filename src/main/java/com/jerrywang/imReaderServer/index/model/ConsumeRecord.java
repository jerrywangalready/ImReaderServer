package com.jerrywang.imReaderServer.index.model;

/**
 * @author jerrywang
 * @create 2017/8/13.
 */
public class ConsumeRecord {

    private String uuid;

    private String userId;

    private float breakfast;

    private float lunch;

    private float dinner;

    private float other;

    private String remark;

    private String recordTime;

    private String cardId;

    private float money;

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public float getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(float breakfast) {
        this.breakfast = breakfast;
    }

    public float getLunch() {
        return lunch;
    }

    public void setLunch(float lunch) {
        this.lunch = lunch;
    }

    public float getDinner() {
        return dinner;
    }

    public void setDinner(float dinner) {
        this.dinner = dinner;
    }

    public float getOther() {
        return other;
    }

    public void setOther(float other) {
        this.other = other;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }
}
