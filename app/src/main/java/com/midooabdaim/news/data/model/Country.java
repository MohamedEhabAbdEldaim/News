package com.midooabdaim.news.data.model;

public class Country {
    String countryName;
    String countryAbbreviation;
    int image;


    public Country(String countryName, String countryAbbreviation, int image) {
        this.countryName = countryName;
        this.countryAbbreviation = countryAbbreviation;
        this.image = image;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
