/*
 * Created: 12.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.goldmann.realestate.views.components.Banner;

import javax.annotation.security.PermitAll;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Dashboard | Realestate")
@PermitAll
public class DashboardView extends VerticalLayout {

    private static final String ENABLED_OPTION = "Enabled";
    private static final String DISABLED_OPTION = "Disabled";

//    private final CrmService service;

    //public DashboardView(CrmService service) {
    public DashboardView() {
        //this.service = service;
        addClassName("dashboard-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(getBanners());
    }

    private Component getBanners() {
        final VerticalLayout layout = new VerticalLayout();
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);
        layout.add(new Banner());
        return layout;
    }

}


