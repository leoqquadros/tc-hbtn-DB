package models;

import entities.Curso;
import entities.MaterialCurso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MaterialModel {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(MaterialCurso material){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(material);
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
    }

    public List<Curso> findAll(){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<Curso> pessoas = null;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            pessoas = entityManager.createQuery("FROM " + Curso.class.getName()).getResultList();
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            pessoas = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

        return pessoas;
    }

    public void update(MaterialCurso material){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(material);
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

    public void delete(MaterialCurso material){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Curso pessoaDeleted;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            pessoaDeleted = entityManager.find(Curso.class, material.getId());
            entityManager.remove(pessoaDeleted);
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
    }

    public Curso findById(MaterialCurso material){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Curso materialEncontrado;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            materialEncontrado = entityManager.find(Curso.class, material.getId());
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            materialEncontrado = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

        return materialEncontrado;
    }
}
