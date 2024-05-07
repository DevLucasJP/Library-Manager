package inf;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import books.backend.Books;

public class Dao<E> {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> pClass;

	static {

		try {

			emf = Persistence.createEntityManagerFactory("books");
		} catch (Exception e) {
		}
	}

	public Dao() {
		em = emf.createEntityManager();
	}

	public Dao(Class<E> pClass) {
		em = emf.createEntityManager();
		this.pClass = pClass;
	}

	public Class<E> getpClass() {
		return pClass;
	}

	public void setpClass(Class<E> pClass) {
		this.pClass = pClass;
	}

	public Dao<E> openTransaction() {

		em.getTransaction().begin();

		return this;
	}

	public Dao<E> include(E entity) {

		em.persist(entity);

		return this;
	}

	public Dao<E> closeTransaction() {

		em.getTransaction().commit();

		return this;
	}

	public Dao<E> atomicInclude(E entity) {

		this.openTransaction().include(entity).closeTransaction();

		return this;
	}

	public List<E> getAll() {

		String jpql = "SELECT e FROM " + pClass.getName() + " e ORDER BY e.name ASC";
		TypedQuery<E> query = em.createQuery(jpql, pClass);

		return query.getResultList();
	}

	public List<E> getPag(int limit, int offset) {

		String jpql = "SELECT e FROM " + pClass.getName() + " e ORDER BY e.name ASC";
		TypedQuery<E> query = em.createQuery(jpql, pClass);
		query.setMaxResults(limit);
		query.setFirstResult(offset);

		return query.getResultList();
	}

	public E getMinId() {

		String jpql = "SELECT e FROM " + pClass.getName() + " e ORDER BY e.id DESC";
		TypedQuery<E> query = em.createQuery(jpql, pClass);
		query.setMaxResults(1);

		return query.getSingleResult();
	}

	public Dao<E> updateBook(Books book) {

		this.openTransaction();
		em.merge(book);
		this.closeTransaction();

		return this;
	}
	
	public Dao<E> deleteBook(Books book) {

		this.openTransaction();
		E remove = em.find(pClass, book.getId());
		em.remove(remove);
		this.closeTransaction();

		return this;
	}

	public void closeDao() {

		em.close();
	}
}
