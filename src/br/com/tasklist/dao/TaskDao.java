package br.com.tasklist.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.com.tasklist.entity.Task;

public class TaskDao {

    private static TaskDao instance;
    protected EntityManager entityManager;

    public static TaskDao getInstance() {
        if (instance == null) {
            instance = new TaskDao();
        }

        return instance;
    }

    private TaskDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("TaskPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Task getById(final Long id) {
        return entityManager.find(Task.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Task> findAll() {
        return entityManager.createQuery("FROM " + Task.class.getName() + " ORDER BY idTask").getResultList();
    }

    public void persist(Task task) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(task);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Task task) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(task);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Task task) {
        try {
            entityManager.getTransaction().begin();
            task = entityManager.find(Task.class, task.getIdTask());
            entityManager.remove(task);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final Long id) {
        try {
            Task task = getById(id);
            remove(task);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
