package com.anl.card.dto;

public class FlowDailyData {
    private Integer cardId;
    //查询月使用量
    private Integer monthUsedFlow;
    private String month;//查询的月份 yyyymm,为空时monthUsedFlow无效
    // 查询日已使用量
    private Integer dayUsedFlow;
    private String day;//查询的日期yyyymmdd,为空时dayUsedFlow无效

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public Integer getMonthUsedFlow() {
        return monthUsedFlow;
    }

    public void setMonthUsedFlow(Integer monthUsedFlow) {
        this.monthUsedFlow = monthUsedFlow;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getDayUsedFlow() {
        return dayUsedFlow;
    }

    public void setDayUsedFlow(Integer dayUsedFlow) {
        this.dayUsedFlow = dayUsedFlow;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
