package models;

import entities.Curso;
import entities.Professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ProfessorModel {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Professor professor){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(professor);
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

    public void update(Professor professor){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(professor);
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

    public void delete(Professor professor){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Curso pessoaDeleted;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            pessoaDeleted = entityManager.find(Curso.class, professor.getId());
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

    public Curso findById(Professor professor){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Curso professorEncontrado;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            professorEncontrado = entityManager.find(Curso.class, professor.getId());
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            professorEncontrado = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

        return professorEncontrado;
    }
    
}
