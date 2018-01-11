package it.uniupo.disit.se.lab10.controller;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniupo.disit.se.lab10.model.Model;
import it.uniupo.disit.se.lab10.model.TicketManager;
import it.uniupo.disit.se.lab10.view.CustomerStrategy;
import it.uniupo.disit.se.lab10.view.TicketManagerUI;


public class TestController {

	@Test
	public void controllerTest() {
	    CustomerStrategy customerStrategy = new CustomerStrategy();
	    TicketManagerUI clientUI1 = new TicketManagerUI("client1", customerStrategy);
	    Model ticketManager = new TicketManager();
	    Controller controller = new Controller(clientUI1, ticketManager);
	    assertEquals(0, customerStrategy.getTicketNumber(ticketManager));
	    controller.actionPerformed(null);
	    assertEquals(1, customerStrategy.getTicketNumber(ticketManager));
	}
}
