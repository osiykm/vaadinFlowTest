package com.osiykm;

import com.osiykm.services.Customer;
import com.osiykm.services.CustomerService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    private CustomerService service = CustomerService.getInstance();
    private Grid<Customer> grid = new Grid<>();

    public MainView() {
        grid.setSizeFull();

        grid.addColumn(Customer::getFirstName).setHeader("First Name");
        grid.addColumn(Customer::getLastName).setHeader("Last Name");
        grid.addColumn(Customer::getStatus).setHeader("Status");

        add(grid);

        setHeight("100vh");
        updateList();
    }

    private void updateList() {
        grid.setItems(service.findAll());
    }


}
