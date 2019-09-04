package com.algaworks.curso.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.algaworks.curso.modelo.Cliente;

public class ConsultaComJPQL {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		//consulta que devolve uma lista de cliente
		List<Cliente> clientes = em.createQuery("from Cliente", Cliente.class) //são passados a consulta e o objeto pra fazer a consulta.
									.getResultList(); //para devolver a lista em typed query
		
		for(Cliente cliente : clientes) {
			System.out.println("Cliente: " + cliente.getCodigo());
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Sexo: " + cliente.getSexo());
			System.out.println("---------------------------------------");
			
		}
	}
}
