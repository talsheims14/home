package com.example.home;

public class Ride    {
    private String destination;
    private String start;
    private String datemonth;
    private String dateday;
    private String name;
    private String number;


    public Ride(String destination, String start, String datemonth,String dateday,String name, String number)
    {
        this.name=name;
        this.number=number;
        this.destination=destination;
        this.start=start;
        this.datemonth=datemonth;
        this.dateday=dateday;
    }

    public void setDatemonth(String datemonth) {
        this.datemonth = datemonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDatemonth() {
        return datemonth;
    }

    public void setDate(String datemonth) {
        this.datemonth = datemonth;
    }
    public String getDateday()
    {
        return dateday;
    }
    public void setDateday(String dateday)
    {
        this.dateday=dateday;
    }
}
