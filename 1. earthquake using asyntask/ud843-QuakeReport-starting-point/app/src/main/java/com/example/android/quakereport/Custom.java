package com.example.android.quakereport;

/**
 * Created by ROHAN on 30-06-2017.
 */

public class Custom {
    private double mag;
    private String countryname;
    private long day;
    private String murl;



    public Custom(double a,String b,long c,String d){
        mag=a;
        countryname=b;
        day=c;
        murl=d;
    }

    public double getmag(){return mag;}
    public String getCountryname(){return countryname;}
    public long getDay(){return day;}
    public String getUrl(){return murl;};
}
