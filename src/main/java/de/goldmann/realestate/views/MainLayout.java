/*
 * Created: 12.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.views;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;
import de.goldmann.realestate.security.SecurityService;

public class MainLayout extends AppLayout {
    private final SecurityService securityService;

    public MainLayout(SecurityService securityService) {
        this.securityService = securityService;
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        final H1 logo = new H1("Realestate");
        logo.addClassNames("text-l", "m-m");

        final Button logout = new Button("Log out", e -> securityService.logout());

        final HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setWidth("100%");
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);

    }

    private void createDrawer() {
        final RouterLink rentHomeLink = new RouterLink("Rent a Home", RentHomeView.class);
        rentHomeLink.setHighlightCondition(HighlightConditions.sameLocation());

        final RouterLink buyHomeLink = new RouterLink("Buy a Home", BuyHomeView.class);
        buyHomeLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(new VerticalLayout(
            new RouterLink("Dashboard", DashboardView.class),
            rentHomeLink,
            buyHomeLink
        ));
    }
}
