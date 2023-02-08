package com.keyin.account;

public class Time {
    private int hour;
    private int minute;
    private int second;

    // Constructor

    public Time(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;

    }

    // Getters

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    // Setters

    public void setHour(int hour)
    {
        this.hour = hour;
    }

    public void setMinute(int minute)
    {
        this.minute = minute;
    }

    public void setSecond(int second)
    {
        this.second = second;
    }

    public void setTime(int hour, int minute, int second)
    {
        this.hour = hour;
        this.minute = minute;
        this.second = second;

    }

    public String toString()
    {
        return String.format("%02d:%02d:%02d",this.hour,this.minute,this.second);
    }

    public Time nextSecond(){
        this.second++;
        if(this.second == 60){
            this.second = 0;
            this.minute++;
            if (this.minute == 60) {
                this.minute = 0;
                this.hour = (this.hour + 1) % 24;
            }
        }
        return new Time(this.hour, this.minute, this.second);
    }

    public Time prevSecond(){
        this.second--;
        if (this.second < 0) {
            this.second = 59;
            this.minute--;
        }
        if (this.minute < 0) {
            this.minute = 59;
            this.hour--;
        }
        if (this.hour < 0) {
            this.hour = 23;
        }
        return new Time(this.hour, this.minute, this.second);
    }
}
