/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Tarea;
import java.util.List;
import javax.persistence.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Conti
 */
public class ControladorBD {
    private EntityManagerFactory emf;
    private EntityManager em;

    

    public ControladorBD() {

    }
/**
 * Método que abre la sesión con hibernate
 */
    private void Sesion() {
        emf = Persistence.createEntityManagerFactory("tarea");
        em = emf.createEntityManager();
    }
/**
 * Método que cierra la sesión
 */
    private void CerrarSesion() {
        em.close();
    }
/**
 * Método que inserta una tarea en la BBDD
 * @param t
 * @return verdadero si ha hecho correctamente la inserción, falso en caso contrario
 */
    public boolean insertar(Tarea t) {
         boolean result=false;
        Sesion();
         
         try {
             em.getTransaction().begin();
             em.persist(t);
             em.getTransaction().commit();
             result=true;
             
             
                         
         }catch(Exception e) {
             em.getTransaction().rollback();
             JOptionPane.showMessageDialog(null, "CLAVE DUPLICADA", "ERROR", 0);
              
            
         }
         
         CerrarSesion();
         return result;

    }
/**
 * Método que actualiza una tarea en la BBDD
 * @param t
 * @return verdadero si actualiza correctamente, falso en caso contrario
 */
    public boolean actualizar(Tarea t) {
       boolean resul=false;
         
         Sesion();
    
         
         try
         {
                em.getTransaction().begin();
                em.merge(t);
                em.getTransaction().commit();
             
             resul=true;
         } catch (Exception ex){
         JOptionPane.showMessageDialog(null,"No se ha actualizado", "ERROR", 0);
              em.getTransaction().rollback();
            
         } finally {
            //Cerramos la sesion
            CerrarSesion();
        }
         
          
        return resul;
    }
/**
 * Método que elimina una tarea de la BBDD, indicada por el ID
 * @param numero
 * @return verdadero si ha podido eliminar correctamente, falso en caso contrario
 */
    public boolean eliminar(Integer numero) {
        boolean resul=false;
         
         Sesion();
         Tarea c1=new Tarea();
         c1= (Tarea) em.find(Tarea.class,numero);
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
            CerrarSesion();
        }
         
          
        return resul;
    }
/**
 * Método que devuelve una lista
 * @param consulta
 * @return Lista con las filas de la base de datos afectadas por la consulta
 */
    public List lanzarConsulta(String consulta) {
        List resultList = null;
        //Inicio la sesion con HibernateUtil. No va en try-catch porque HibernateUtil ya lanza excepcion si hay fallo.
        Sesion();
        
       
        try {
            
                Query query = em.createQuery(consulta);

                resultList = query.getResultList();
                 
                
         
        } catch (Exception e) {
            String errQuery = "Ha ocurrido un error inesperado lanzando la consulta";
            System.err.println(errQuery);
            JOptionPane.showMessageDialog(null, errQuery, "ERROR", 0);
        } finally {
            //Cerramos la sesion
            CerrarSesion();
        }
        return resultList;
    }
/**
 * Metodo que devuelve un número
 * @param consulta
 * @return numero de filas de la BBDD afectadas por la consulta 
 */
    public long Consulta(String consulta) {

        Long resul=12345678910L;
          
          
          
       
        //Inicio la sesion con HibernateUtil. No va en try-catch porque HibernateUtil ya lanza excepcion si hay fallo.
      Sesion();
        
        
        //Capturamos toda excepcion que pueda ocurrir al lanzar una consulta
        try {
            
               
            
            resul = (Long)em.createQuery(consulta).getSingleResult();
            
      
           
         

         
         
        } catch (Exception e) {
            String errQuery = "Ha ocurrido un error inesperado lanzando la consulta simple";
            System.err.println(errQuery + " " + e);
            JOptionPane.showMessageDialog(null, errQuery, "ERROR", 0);
        } finally {
            //Cerramos la sesion
            CerrarSesion();
        }
       
        return resul;
    }
/**
 * Método que busca una tarea en la base de datos
 * @param t
 * @return Tarea encontrada
 */
    public Tarea Buscar(Tarea t) {
        Sesion();
    
        return em.find(Tarea.class, t.getIdTarea());
      
    }
}
