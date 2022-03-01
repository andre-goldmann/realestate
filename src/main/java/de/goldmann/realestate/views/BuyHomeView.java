/*
 * Created: 12.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.NativeButton;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.goldmann.realestate.data.domain.CiencuadrasData;
import de.goldmann.realestate.data.domain.RealtorData;
import de.goldmann.realestate.data.domain.TypeParameter;
import de.goldmann.realestate.data.service.RealtorService;
import de.goldmann.realestate.jms.Producer;
import de.goldmann.realestate.views.components.ProviderCard;
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

    public BuyHomeView(
        final Producer producer,
        final RealtorService realestateService) {

        final NativeButton button = new NativeButton("Back");
            button.addClickListener(e -> button.getUI().ifPresent(ui -> ui.navigate(""))
        );

        final VerticalLayout cardsLayout = new VerticalLayout(
            new Label("TOOD ich möchte eine Filter über alle Tabelle oder alle Daten in eine Tabelle?"),
            new ProviderCard(realestateService, new TypeParameter<>(RealtorData.class, "www.realtor.com")),
            //https://www.metrocuadrado.com/venta/nuevo/bogota/?search=form
            new ProviderCard(realestateService, new TypeParameter<>(CiencuadrasData.class, "www.ciencuadras.com")),
            new VerticalLayout(
                new Label("www.metrocuadrado.com")
            ),
            //https://www.puntopropiedad.com/venta/apartamentos/bogota
            new VerticalLayout(
                new Label("www.puntopropiedad.com")
            ),
            //https://www.properati.com.co/s/bogota-d-c-colombia/venta
            new VerticalLayout(
                new Label("www.properati.com")
            )
        );
        cardsLayout.setSizeFull();
        cardsLayout.setAlignItems(Alignment.AUTO);

        final Button jmsTestButton = new Button("Start Data Collection");
        jmsTestButton.addClickListener(e -> producer.publish("Start Data Collection"));
        add(button, jmsTestButton, cardsLayout);

    }
}
