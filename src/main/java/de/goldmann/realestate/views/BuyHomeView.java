/*
 * Created: 12.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.views;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.security.PermitAll;

/**
 * @author Andre Goldmann
 */
@Component
@Scope("prototype")
@Route(value="buyhome", layout = MainLayout.class)
@PageTitle("Buy a Home | Realestate")
@PermitAll
public class BuyHomeView extends VerticalLayout {

    public BuyHomeView() {
        final NativeButton button = new NativeButton("Back");
        button.addClickListener(e -> button.getUI().ifPresent(ui -> ui.navigate(""))
        );
        add(button, new Label("BuyHomeView"));
    }
}
