package com.nttdata.hibernate.persistence;

import java.util.List;

/**
 * Interfaz del patron DAO para la clase cliente.
 * 
 * @author Usuario
 *
 */
public interface ClientDaoI {
	/**
	 * Inserta un cliente nuevo en la base de datos
	 * 
	 * @param newClient
	 */
	public void insert(final Client newClient);

	/**
	 * Actualiza un cliente de la base de datos, debe existir un cliente con la
	 * clave primaria de la instancia Cliente pasada por parametro.
	 * 
	 * @param updatedClient
	 */
	public void update(final Client updatedClient);

	/**
	 * Elimina el cliente especificado.
	 * 
	 * @param deletedClient
	 */
	public void delete(final Client deletedClient);

	/**
	 * Busca y devuelve el cliente con el id especificado.
	 * 
	 * @param clientId
	 * @return matching client
	 */
	public Client searchById(final Long clientId);

	/**
	 * Devuelve una lista con todos los clientes en la base de datos.
	 * 
	 * @return
	 */
	public List<Client> searchAll();

	/**
	 * Busca y devuelve una lista con todos los clientes con el nombre exacto
	 * especificado.
	 * 
	 * @param name
	 * @return matching clients
	 */
	public List<Client> searchByName(final String name);

	/**
	 * Busca y devuelve una lista con todos los clientes con el nombre completo
	 * exacto especificado.
	 * 
	 * @param name
	 * @param surname1
	 * @param surname2
	 * @return
	 */
	public List<Client> searchByFullName(String name, String surname1, String surname2);
}
