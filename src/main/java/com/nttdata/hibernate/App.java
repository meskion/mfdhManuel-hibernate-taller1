package com.nttdata.hibernate;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Client;
import com.nttdata.hibernate.services.ClientManagementServiceI;
import com.nttdata.hibernate.services.ClientManagementServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		final Session session = NttdataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final ClientManagementServiceI service = new ClientManagementServiceImpl(session);
		
		//generacion de clientes
		
		final Client tellez = new Client();
		tellez.setDni("111111111");
		tellez.setName("Juan Alejandro");
		tellez.setFirstSurname("Tellez");
		tellez.setSecondSurname("Rubio");
		
		service.insertNewClient(tellez);
		
		service.searchByFullName(tellez.getName(), tellez.getFirstSurname(), tellez.getSecondSurname()).forEach(System.out::println);
		
		session.close();
		
	}
}
