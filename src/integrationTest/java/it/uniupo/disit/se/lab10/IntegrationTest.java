package it.uniupo.disit.se.lab10;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JLabelFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.uniupo.disit.se.lab10.controller.Controller;
import it.uniupo.disit.se.lab10.model.Model;
import it.uniupo.disit.se.lab10.model.TicketManager;
import it.uniupo.disit.se.lab10.view.CustomerStrategy;
import it.uniupo.disit.se.lab10.view.DisplayUI;
import it.uniupo.disit.se.lab10.view.OfficeWorkerStrategy;
import it.uniupo.disit.se.lab10.view.RoleStrategy;
import it.uniupo.disit.se.lab10.view.TicketManagerUI;


public class IntegrationTest {

	private FrameFixture window;

	@BeforeClass
	public static void setUpOnce() {
	  FailOnThreadViolationRepaintManager.install();
	}
	
	@Before
	public void setUp() {
		JFrame frame = GuiActionRunner.execute(() -> new JFrame());
		JPanel panel = GuiActionRunner.execute(() -> new JPanel());
		
		// componente Model
		Model ticketManager = new TicketManager();
		
		// strategie
		RoleStrategy customerRole = new CustomerStrategy();
		RoleStrategy officeWorkerRole = new OfficeWorkerStrategy();

		// Creazione delle View
		TicketManagerUI clientUI1 = GuiActionRunner.execute(() -> new TicketManagerUI("client1", customerRole));
		TicketManagerUI clientUI2 = GuiActionRunner.execute(() -> new TicketManagerUI("client2", customerRole));
		TicketManagerUI serverUI1 = GuiActionRunner.execute(() -> new TicketManagerUI("server1", officeWorkerRole));
		TicketManagerUI serverUI2 = GuiActionRunner.execute(() -> new TicketManagerUI("server2", officeWorkerRole));
		DisplayUI display = GuiActionRunner.execute(() -> new DisplayUI());
		
		// associazione View-Model via Controller 
		new Controller(clientUI1, ticketManager);
		new Controller(clientUI2, ticketManager);
		new Controller(serverUI1, ticketManager);
		new Controller(serverUI2, ticketManager);
		new Controller(display, ticketManager);
	
		// Aggiunta degli oggetti dell'UI e alla finestra principale
		panel.add(clientUI1);
		panel.add(clientUI2);
		panel.add(serverUI1);
		panel.add(serverUI2);
		panel.add(display);

		frame.add(panel);
		frame.pack();
		frame.setPreferredSize(new Dimension(600,200));
		
		window = new FrameFixture(frame);
		window.show();
	}
	
	@Test
	public void singleClientSingleServerTest() {		
		JButtonFixture clientButton1 = window.button("client1Button");
		JLabelFixture clientText1 = window.label("client1Label");
		JButtonFixture officeWorkerButton1 = window.button("server1Button");
		JLabelFixture officeWorkerText1 = window.label("server1Label");
		JLabelFixture display = window.label("display");
		
		assertThat(clientText1.text()).isEqualTo("ticket: 0");
		clientButton1.click();
		assertThat(clientText1.text()).isEqualTo("ticket: 1");		
		assertThat(officeWorkerText1.text()).isEqualTo("ticket: 0");
		officeWorkerButton1.click();
		assertThat(officeWorkerText1.text()).isEqualTo("ticket: 1");
		assertThat(display.text()).isEqualTo("currently served: 1");
	}
	
	@Test
	public void twoClientsTwoServersTest() {
		JButtonFixture clientButton1 = window.button("client1Button");
		JLabelFixture clientText1 = window.label("client1Label");
		JButtonFixture clientButton2 = window.button("client2Button");
		JLabelFixture clientText2 = window.label("client2Label");
		JButtonFixture officeWorkerButton1 = window.button("server1Button");
		JLabelFixture officeWorkerText1 = window.label("server1Label");
		JButtonFixture officeWorkerButton2 = window.button("server2Button");
		JLabelFixture officeWorkerText2 = window.label("server2Label");
		JLabelFixture display = window.label("display");
		
		assertThat(clientText1.text()).isEqualTo("ticket: 0");
		assertThat(clientText2.text()).isEqualTo("ticket: 0");
		assertThat(officeWorkerText1.text()).isEqualTo("ticket: 0");
		assertThat(officeWorkerText2.text()).isEqualTo("ticket: 0");
		clientButton1.click();
		assertThat(clientText1.text()).isEqualTo("ticket: 1");
		assertThat(clientText2.text()).isEqualTo("ticket: 1");
		assertThat(officeWorkerText1.text()).isEqualTo("ticket: 0");
		assertThat(officeWorkerText2.text()).isEqualTo("ticket: 0");
		clientButton1.click();
		assertThat(clientText1.text()).isEqualTo("ticket: 2");
		clientButton2.click();
		assertThat(clientText2.text()).isEqualTo("ticket: 3");
		clientButton1.click();
		assertThat(clientText1.text()).isEqualTo("ticket: 4");
		officeWorkerButton1.click();
		assertThat(officeWorkerText1.text()).isEqualTo("ticket: 1");
		assertThat(officeWorkerText2.text()).isEqualTo("ticket: 1");
		assertThat(display.text()).isEqualTo("currently served: 1");
		officeWorkerButton2.click();
		assertThat(officeWorkerText2.text()).isEqualTo("ticket: 2");
		assertThat(display.text()).isEqualTo("currently served: 2");
		officeWorkerButton1.click();
		officeWorkerButton1.click();
		assertThat(officeWorkerText1.text()).isEqualTo("ticket: 4");
		assertThat(display.text()).isEqualTo("currently served: 4");
		officeWorkerButton1.click();
		assertThat(officeWorkerText1.text()).isEqualTo("ticket: 4");
		assertThat(display.text()).isEqualTo("currently served: 4");
	}
	
	@After 
	public void tearDown(){
		window.cleanUp();
	}
}
