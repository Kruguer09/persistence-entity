/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelos.Departamentos;
import Modelos.Empleados;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class ConectorBD {

    private EntityManagerFactory emf;
    private EntityManager em;

    public ConectorBD() {

    }

    private void Sesion() {
        emf = Persistence.createEntityManagerFactory("empresa");
        em = emf.createEntityManager();

    }

    private void Cerrarsesion() {

        em.close();
    }
    public boolean InsertarDep(Departamentos a1){
        boolean result=false;
        Sesion();
         
         try {
             em.getTransaction().begin();
             em.persist(a1);
             em.getTransaction().commit();
             result=true;
             
             
                         
         }catch(Exception e) {
             em.getTransaction().rollback();
             JOptionPane.showMessageDialog(null, "CLAVE DUPLICADA", "ERROR", 0);
              
            
         }
         
         Cerrarsesion();
         return result;
    }
    public boolean InsertarEmp(Empleados c1){
        boolean resul=false;
       
         Sesion();
         
         try {
             em.getTransaction().begin();
             em.persist(c1);
             em.getTransaction().commit();
             resul=true;
             
             
                         
         }catch(Exception e) {
             em.getTransaction().rollback();
             JOptionPane.showMessageDialog(null, "CLAVE DUPLICADA", "ERROR", 0);
              
            
         }
         
         Cerrarsesion();
         return resul;
    }
    public boolean EliminarEmp(Integer numero) {
         boolean resul=false;
         
         Sesion();
         Empleados c1=new Empleados();
         c1= (Empleados) em.find(Empleados.class,numero);
         try
         {
                em.getTransaction().begin();
                em.remove(c1);
                em.getTransaction().commit();
             
             resul=true;
         } catch (Exception ex){
         JOptionPane.showMessageDialog(null,"No se ha podido eliminar", "ERROR", 0);
              em.getTransaction().rollback();
            
         } finally {
            //Cerramos la sesion
            Cerrarsesion();
        }
         
          
        return resul;
      }
    public boolean EliminarDep(Integer numero) {
         boolean resul=false;
         
         Sesion();
         Departamentos c1=new Departamentos();
         c1= (Departamentos) em.find(Departamentos.class,numero);
         try
         {
                em.getTransaction().begin();
                em.remove(c1);
                em.getTransaction().commit();
             
             resul=true;
         } catch (Exception ex){
         JOptionPane.showMessageDialog(null,"No se ha podido eliminar", "ERROR", 0);
              em.getTransaction().rollback();
            
         } finally {
            //Cerramos la sesion
            Cerrarsesion();
        }
         
          
        return resul;
      }
    public boolean ActualizarDep(Departamentos a1) {
         boolean resul=false;
         
         Sesion();
    
         
         try
         {
                em.getTransaction().begin();
                em.merge(a1);
                em.getTransaction().commit();
             
             resul=true;
         } catch (Exception ex){
         JOptionPane.showMessageDialog(null,"No se ha actualizado", "ERROR", 0);
              em.getTransaction().rollback();
            
         } finally {
            //Cerramos la sesion
            Cerrarsesion();
        }
         
          
        return resul;
      }
    public boolean ActualizarEmp(Empleados a1) {
         boolean resul=false;
         
         Sesion();
    
         
         try
         {
                em.getTransaction().begin();
                em.merge(a1);
                em.getTransaction().commit();
             
             resul=true;
         } catch (Exception ex){
         JOptionPane.showMessageDialog(null,"No se ha actualizado", "ERROR", 0);
              em.getTransaction().rollback();
            
         } finally {
            //Cerramos la sesion
            Cerrarsesion();
        }
         
          
        return resul;
      }
    public Departamentos BuscarDep (Departamentos a1)
     {
         
         
           Sesion();
    
        return em.find(Departamentos.class, a1.getDepno());
     }
    public Empleados BuscarEmp (Empleados a1)
     {
                  
           Sesion();
    
        return em.find(Empleados.class, a1.getEmpno());
     }
    public List lanzarConsulta(String consulta) {
        List resultList = null;
        //Inicio la sesion con HibernateUtil. No va en try-catch porque HibernateUtil ya lanza excepcion si hay fallo.
        Sesion();
        
        //Capturamos toda excepcion que pueda ocurrir al lanzar una consulta
        try {
            
                Query query = em.createQuery(consulta);

                resultList = query.getResultList();
                 
                
         
        } catch (Exception e) {
            String errQuery = "Ha ocurrido un error inesperado lanzando la consulta";
            System.err.println(errQuery);
            JOptionPane.showMessageDialog(null, errQuery, "ERROR", 0);
        } finally {
            //Cerramos la sesion
            Cerrarsesion();
        }
        return resultList;
    }
}
