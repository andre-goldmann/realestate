/*
 * Created: 12.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.views.components;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * @author Andre Goldmann
 */
public class HomeDetailView extends VerticalLayout {

    public HomeDetailView() {
        add(
            new Image("https://ap.rdcpix.com/7f63b67d384b51f1a52f2767518c19efl-m3988439457od-w480_h360_x2.webp", "Image not found"),
            new HorizontalLayout(new Label("$875,000"),
            new HorizontalLayout(new Label("3\n"
                                               + "bed\n"
                                               + "2.5\n"
                                               + "bath\n"
                                               + "2.473sqft\n"
                                               + "2.473 square feet\n"
                                               + "0,3acre lot"))));
    }
}
