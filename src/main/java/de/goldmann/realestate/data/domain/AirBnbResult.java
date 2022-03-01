/*
 * Created: 15.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.data.domain;


/**
 * @author Andre Goldmann
 */
public class AirBnbResult extends CollecionResult {
    private String title;
    private String pricePerNight;
    private String priceTotal;
    private String views;
    private String interior;
    private String rating;

    public AirBnbResult(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(String pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(String priceTotal) {
        this.priceTotal = priceTotal;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("AirBnbResult{");
        sb.append("title='").append(title).append('\'');
        sb.append(", pricePerNight='").append(pricePerNight).append('\'');
        sb.append(", priceTotal='").append(priceTotal).append('\'');
        sb.append(", views='").append(views).append('\'');
        sb.append(", interior='").append(interior).append('\'');
        sb.append(", rating='").append(rating).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
