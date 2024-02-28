/* El m�todo builSessionFactory aparec�a "deprecated"
 * por eso busqu� otra soluci�n en Internet
 a esta que ya ten�a
package primero;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
	private static final SessionFactory sessionFactory;
		static {
			try {
				sessionFactory= new Configuration().configure().buildSessionFactory();
			} catch (Throwable ex) {
				System.err.println("Initial SessionFactory creation failed. " + ex);
				throw new ExceptionInInitializerError(ex);
			}
		}
		public static SessionFactory getSessionFactory(){
			return sessionFactory;
		}
}


*/
package clases;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
public class SessionFactoryUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            // loads configuration and mappings
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
             
            // builds a session factory from the service registry
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);           
        }
         
        return sessionFactory;
    }
}
