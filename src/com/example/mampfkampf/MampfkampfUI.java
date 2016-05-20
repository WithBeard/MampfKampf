package com.example.mampfkampf;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("mampfkampf")
public class MampfkampfUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = MampfkampfUI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		MampfkampfController mkc = new MampfkampfController();
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
/*
		Button button = new Button("Click Not");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label("Thank you for nothing"));
			}
		});
		layout.addComponent(button);
		ComboBox userBox = new ComboBox( "Users", mkc.getUsers() );
		layout.addComponent(userBox);
		
		Grid gridExample = new Grid();
		gridExample.addColumn( "Users" );
		gridExample.addColumn( "Toll" );
		gridExample.addColumn( "Relevant" );
		List<String> users = mkc.getUsers();
		Object[] row;
		for (String user : users) {
			row = new String[3];
			row[0] = user;
			row[1] = "Nein";
			//row[2] = "Sicher nicht.";
			Button cellButt = new Button("Toggle");
			cellButt.addClickListener(new Button.ClickListener() {
				public void buttonClick(ClickEvent event) {
					layout.addComponent(new Label("Ping"));
				}
			});
			row[2] = "cellButt";
			gridExample.addRow( row );
		}
		gridExample.addRow( "Custom", "SingleString", "Row" );
		
		layout.addComponent( gridExample );
		
*/
		// Create the accordion
		Accordion accordion = new Accordion();
		
		Layout userTab = new VerticalLayout(); // Wrap in a layout
		HorizontalLayout userCredentials = new HorizontalLayout();		
		userCredentials.addComponent( new Label( "Username:" ) );
		TextField userName = new TextField();
		userCredentials.addComponent( userName );
		userCredentials.addComponent( new Label( "Passwort:" ) );
		TextField userPassword = new TextField();
		userCredentials.addComponent(userPassword);
		Button loginButt = new Button("Login");
		loginButt.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				//TODO: Controller.login
			}
		}); 
		userCredentials.addComponent(loginButt);
		Button createButt = new Button("Create");
		createButt.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				//TODO: Controller.create
			}
		}); 
		userCredentials.addComponent(createButt);
		
		userTab.addComponent( userCredentials );
		accordion.addTab( userTab, "User" );
		
		Layout restaurantTab = new VerticalLayout(); // Wrap in a layout
		restaurantTab.addComponent( new Image( null, new ThemeResource( "img/planets/Mercury.jpg" ) ) );
		accordion.addTab( restaurantTab, "Restaurant" );
		
		Layout wahlTab = new VerticalLayout(); // Wrap in a layout
		wahlTab.addComponent( new Image( null, new ThemeResource( "img/planets/Mercury.jpg" ) ) );
		accordion.addTab( wahlTab, "Wahl" );
		
		layout.addComponent( accordion );
	}

}