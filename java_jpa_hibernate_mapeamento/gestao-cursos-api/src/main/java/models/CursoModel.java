package models;

import entities.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class CursoModel {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Curso curso){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(curso);
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

    public void update(Curso curso){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(curso);
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

    public void delete(Curso aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Curso pessoaDeleted;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            pessoaDeleted = entityManager.find(Curso.class, aluno.getId());
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

    public Curso findById(Curso aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Curso resultadoEncontrado;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            resultadoEncontrado = entityManager.find(Curso.class, aluno.getId());
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            resultadoEncontrado = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

        return resultadoEncontrado;
    }
}
