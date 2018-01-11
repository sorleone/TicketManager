package it.uniupo.disit.se.lab10.view;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniupo.disit.se.lab10.model.Model;
import it.uniupo.disit.se.lab10.model.TicketManager;

public class TestView {

    private Model ticketManager;
    private RoleStrategy customerRole;
    
    @Before
    public void setUp() {
        this.ticketManager = new TicketManager();
        this.customerRole = new CustomerStrategy();
    }
    
	@Test
	public void customerStrategyTest() {
        assertEquals(0, customerRole.getTicketNumber(ticketManager));
        customerRole.incTicketNumber(ticketManager);
        assertEquals(1, customerRole.getTicketNumber(ticketManager));
	}
	
   @Test
   public void officeWorkerStrategyTest() {
       RoleStrategy officeWorkerRole = new OfficeWorkerStrategy();
       assertEquals(0, officeWorkerRole.getTicketNumber(ticketManager));
       officeWorkerRole.incTicketNumber(ticketManager);
       assertEquals(0, officeWorkerRole.getTicketNumber(ticketManager));
       assertEquals(0, customerRole.getTicketNumber(ticketManager));
       customerRole.incTicketNumber(ticketManager);
       assertEquals(0, officeWorkerRole.getTicketNumber(ticketManager));
       officeWorkerRole.incTicketNumber(ticketManager);
       assertEquals(1, officeWorkerRole.getTicketNumber(ticketManager));
   }
}




