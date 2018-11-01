package com.leafchild0.hybrid.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * View to be loaded by default
 */
@Route
public class DefaultView extends VerticalLayout {

	/**
	 * New instance
	 * @param bean - bean service
	 */
	public DefaultView(@Autowired MessageBean bean) {

		Button button = new Button("Click me",
				e -> Notification.show(bean.getMessage()));
		add(button);

		Grid<CustomEvent> grid = new Grid<>(CustomEvent.class);
		grid.setItems(Utils.getGridData());
		grid.getColumnByKey("id").setHeader("ID");
		grid.getColumnByKey("date").setHeader("Date");
		grid.getColumnByKey("type").setHeader("Event Type");
		grid.getColumnByKey("description").setHeader("Description");

		add(grid);

	}

}
