package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    
    private static EntityManagerFactory emf = null;
    
    public static void closeManager(EntityManager manager) {
        try{
            manager.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static EntityManager getManager(){
        try{
            return getEmf().createEntityManager();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    private static EntityManagerFactory getEmf(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("TCC-JAVAPU");
        }
        return emf;
    }
}
