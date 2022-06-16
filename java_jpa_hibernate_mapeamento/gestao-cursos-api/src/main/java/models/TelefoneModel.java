package models;

import entities.Telefone;
import entities.Telefone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class TelefoneModel {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

        public void create(Telefone telefone){
            EntityManager entityManager = null;
            EntityTransaction entityTransaction = null;

            try {
                entityManager = emf.createEntityManager();
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                entityManager.persist(telefone);
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

        public List<Telefone> findAll(){
            EntityManager entityManager = null;
            EntityTransaction entityTransaction = null;
            List<Telefone> pessoas = null;

            try{
                entityManager = emf.createEntityManager();
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                pessoas = entityManager.createQuery("FROM " + Telefone.class.getName()).getResultList();
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

        public void update(Telefone telefone){
            EntityManager entityManager = null;
            EntityTransaction entityTransaction = null;

            try{
                entityManager = emf.createEntityManager();
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                entityManager.merge(telefone);
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

        public void delete(Telefone telefone){
            EntityManager entityManager = null;
            EntityTransaction entityTransaction = null;
            Telefone pessoaDeleted;

            try{
                entityManager = emf.createEntityManager();
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                pessoaDeleted = entityManager.find(Telefone.class, telefone.getId());
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

        public Telefone findById(Telefone telefone){
            EntityManager entityManager = null;
            EntityTransaction entityTransaction = null;
            Telefone telefoneEncontrado;

            try{
                entityManager = emf.createEntityManager();
                entityTransaction = entityManager.getTransaction();
                entityTransaction.begin();
                telefoneEncontrado = entityManager.find(Telefone.class, telefone.getId());
                entityTransaction.commit();
            }catch (Exception ex){
                ex.printStackTrace();
                telefoneEncontrado = null;
                if(entityTransaction != null)
                    entityTransaction.rollback();
            }finally{
                if(entityManager != null)
                    entityManager.close();
            }

            return telefoneEncontrado;
        }
}
