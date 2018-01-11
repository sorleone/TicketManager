package it.uniupo.disit.se.lab10.view;

import static org.mockito.Mockito.*;

import java.util.Observable;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniupo.disit.se.lab10.model.Model;
import it.uniupo.disit.se.lab10.model.TicketManager;

public class TestView {

    private Model ticketManager;
    private RoleStrategy customerRole, officeWorkerRole;
    
    @Before
    public void setUp() {
        this.ticketManager = new TicketManager();
        this.customerRole = new CustomerStrategy();
        this.officeWorkerRole = new OfficeWorkerStrategy();
    }
    
	@Test
	public void customerStrategyTest() {
        assertEquals(0, customerRole.getTicketNumber(ticketManager));
        customerRole.incTicketNumber(ticketManager);
        assertEquals(1, customerRole.getTicketNumber(ticketManager));
	}
	
   @Test
   public void officeWorkerStrategyTest() {
       assertEquals(0, officeWorkerRole.getTicketNumber(ticketManager));
       officeWorkerRole.incTicketNumber(ticketManager);
       assertEquals(0, officeWorkerRole.getTicketNumber(ticketManager));
       assertEquals(0, customerRole.getTicketNumber(ticketManager));
       customerRole.incTicketNumber(ticketManager);
       assertEquals(0, officeWorkerRole.getTicketNumber(ticketManager));
       officeWorkerRole.incTicketNumber(ticketManager);
       assertEquals(1, officeWorkerRole.getTicketNumber(ticketManager));
   }

   @Test
   public void customerTicketManagerUITest() {
       TicketManagerUI clientUI1 = new TicketManagerUI("client1", customerRole);
       assertEquals("ticket: 0", clientUI1.label.getText());
       ticketManager.addObserver(clientUI1);
       assertEquals(customerRole, clientUI1.getRole());
       officeWorkerRole.incTicketNumber(ticketManager);
       assertEquals("ticket: 0", clientUI1.label.getText());
       customerRole.incTicketNumber(ticketManager);
       assertEquals("ticket: 1", clientUI1.label.getText());
   }
   
   @Test
   public void serverTicketManagerUITest() {
       TicketManagerUI serverUI1 = new TicketManagerUI("server1", officeWorkerRole);
       assertEquals("ticket: 0", serverUI1.label.getText());
       ticketManager.addObserver(serverUI1);
       assertEquals(officeWorkerRole, serverUI1.getRole());
       customerRole.incTicketNumber(ticketManager);
       assertEquals("ticket: 0", serverUI1.label.getText());
       officeWorkerRole.incTicketNumber(ticketManager);
       assertEquals("ticket: 1", serverUI1.label.getText());
   }
   /*
   @Test
   public void displayUITest() {
       DisplayUI display = GuiActionRunner.execute(() -> new DisplayUI());
       assertEquals(null, display.getRole());
   }*/
}
