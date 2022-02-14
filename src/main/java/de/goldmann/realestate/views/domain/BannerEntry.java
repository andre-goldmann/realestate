/*
 * Created: 12.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.views.domain;

/**
 * @author Andre Goldmann
 */
public class BannerEntry {
    private String link;
    private String h1;
    private String h2;
    private String h3;
    private String btnText;
    private String route;

    public BannerEntry(
        final String link,
        final String h1,
        final String h2,
        final String h3,
        final String btnText,
        final String route) {
        this.link = link;
        this.h1 = h1;
        this.h2 = h2;
        this.h3 = h3;
        this.btnText = btnText;
        this.route = route;
    }

    public String getLink() {
        return link;
    }

    public String getH1() {
        return h1;
    }

    public String getH2() {
        return h2;
    }

    public String getH3() {
        return h3;
    }

    public String getBtnText() {
        return btnText;
    }

    public String getRoute() {
        return route;
    }
}
