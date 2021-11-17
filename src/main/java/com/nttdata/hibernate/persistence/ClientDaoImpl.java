package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Implementacion de ClienteDaoI
 * 
 * @author Manu FHD
 *
 */
public class ClientDaoImpl implements ClientDaoI {

	// Atributos

	/**
	 * Sesion de hibernate con la que trabaja el DAO
	 */
	private Session session;

	public ClientDaoImpl(Session session) {

		this.session = session;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void insert(final Client newClient) {

		beginTransaction();

		session.save(newClient);
		session.flush();

		session.getTransaction().commit();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(final Client updatedClient) {

		beginTransaction();

		// Insercción.
		session.saveOrUpdate(updatedClient);

		// Commit.
		session.getTransaction().commit();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(Client deletedClient) {

		beginTransaction();

		// Insercción.
		session.delete(deletedClient);

		// Commit.
		session.getTransaction().commit();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Client searchById(Long clientId) {
		// Verificación de sesión abierta.
		beginTransaction();

		// Búsqueda por PK.
		Client result = session.get(Client.class, clientId);

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchAll() {

		beginTransaction();

		// Búsqueda de todos los registros.
		List<Client> list = session.createQuery("FROM " + Client.class.getName()).list();

		return list;

	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByName(final String name) {

		beginTransaction();

		final List<Client> clientList = session.createQuery("FROM " + Client.class.getName() + " WHERE name=" + name)
				.list();

		return clientList;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByFullName(final String name, final String surname1, final String surname2) {

		beginTransaction();

		String query = "from " + Client.class.getName() + " " + "where name = '" + name + "'" + "and firstSurname = '"
				+ surname1 + "'" + "and secondSurname = '" + surname2 + "'";

		final List<Client> clientList = session.createQuery(query).list();

		return clientList;
	}

	/**
	 * Verificación de sesión abierta.
	 */
	private void beginTransaction() {
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}
	}

}
