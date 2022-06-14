package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoModel {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");

    public void create(Produto p) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(p);
            entityTransaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        } finally {
            if(entityManager != null)
                entityManager.close();
        }
    }

    public void update(Produto p) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(p);
            entityTransaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        } finally {
            if(entityManager != null)
                entityManager.close();
        }
    }

    public void delete(Produto p) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Produto produtoDeleted;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            produtoDeleted = entityManager.find(Produto.class, p.getId());
            entityManager.remove(produtoDeleted);
            entityTransaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
    }

    public Produto findById(Produto p) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Produto produtoEncontrado;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            produtoEncontrado = entityManager.find(Produto.class, p.getId());
            entityTransaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            produtoEncontrado = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

        return produtoEncontrado;
    }

    public List<Produto> findAll() {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<Produto> produtos = null;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            produtos = entityManager.createQuery("FROM " + Produto.class.getName()).getResultList();
            entityTransaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            produtos = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

        return produtos;
    }

}
