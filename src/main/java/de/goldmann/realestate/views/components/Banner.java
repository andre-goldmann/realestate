/*
 * Created: 12.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.views.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andre Goldmann
 */
public class Banner extends Div {

    public Banner() {

        final List<BannerEntry> items = new ArrayList<>();
        items.add(new BannerEntry(
            "https://bayut-production.s3.eu-central-1.amazonaws.com/image/145426814/33973352624c48628e41f2ec460faba4",
            "Rent a Home",
            "Rent Homes for Everyone",
            "Explore Apartments, Villas, Homes, and more",
            "Explore Renting",
            "renthome"));
        items.add(new BannerEntry(
            "https://bayut-production.s3.eu-central-1.amazonaws.com/image/110993385/6a070e8e1bae4f7d8c1429bc303d2008",
            "BUY A HOME",
            "Find, Buy & Own Your Drean Ho,e",
            "Explore Apartments, Villas Homes and more",
            "Explore Buying",
            "buyhome"));
        final MultiSelectListBox<BannerEntry> listBox = new MultiSelectListBox<>();
        listBox.setItems(items);
        listBox.setRenderer(new ComponentRenderer<>(bannerEntry -> {
            final HorizontalLayout row = new HorizontalLayout();
            row.setAlignItems(FlexComponent.Alignment.CENTER);

            final Image img = new Image(bannerEntry.getLink(), "Image not found");
            img.setWidth("40%");
            img.setHeight("40%");
            //new Button(bannerEntry.getBtnText()
            final NativeButton button = new NativeButton(bannerEntry.getBtnText());
            button.addClickListener(e -> button.getUI().ifPresent(ui -> ui.navigate(bannerEntry.getRoute()))
            );
            final HorizontalLayout column = new HorizontalLayout(img,
                                new VerticalLayout(
                                    new H1(bannerEntry.getH1()),
                                    new H2(bannerEntry.getH2()),
                                    new H3(bannerEntry.getH3()),
                                    button
                        ));
            column.setPadding(false);
            column.setSpacing(false);

            row.add(column);
            row.getStyle().set("line-height", "var(--lumo-line-height-m)");
            return row;
        }));
        add(listBox);
    }
}
