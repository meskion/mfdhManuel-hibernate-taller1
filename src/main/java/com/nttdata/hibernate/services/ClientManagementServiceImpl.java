package com.nttdata.hibernate.services;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.Client;
import com.nttdata.hibernate.persistence.ClientDaoI;
import com.nttdata.hibernate.persistence.ClientDaoImpl;

/**
 * Imlementacion de ClientManagementI
 * 
 * @author Manu FHD
 *
 */
public class ClientManagementServiceImpl implements ClientManagementServiceI {
	/**
	 * Clase DAO que consume el servicio
	 */
	private ClientDaoI dao;

	public ClientManagementServiceImpl(Session session) {
		dao = new ClientDaoImpl(session);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insertNewClient(Client newClient) {

		if (newClient != null && newClient.getId() == null) {

			// Insercción del nuevo partido.
			dao.insert(newClient);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateClient(Client updatedClient) {

		if (updatedClient != null && updatedClient.getId() != null) {

			// Insercción del nuevo partido.
			dao.update(updatedClient);

		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteClient(Client deletedClient) {

		if (deletedClient != null && deletedClient.getId() != null) {

			// Insercción del nuevo partido.
			dao.delete(deletedClient);
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Client searchById(Long clientId) {

		Client result = null;

		if (clientId != null) {
			result = dao.searchById(clientId);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Client> searchAll() {

		return dao.searchAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Client> searchByName(String name) {

		return dao.searchByName(name);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Client> searchByFullName(String name, String surname1, String surname2) {

		return dao.searchByFullName(name, surname1, surname2);

	}

}
