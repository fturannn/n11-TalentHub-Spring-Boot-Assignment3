package com.n11.assignment3.enums;

public enum Periods {
    WEEK(7), FORTNIGHT(14), MAX(16), MIN(1);

    private final int days;

    Periods(int days) {
        this.days = days;
    }

    public int obtainPeriod() {
        return days;
    }
}
