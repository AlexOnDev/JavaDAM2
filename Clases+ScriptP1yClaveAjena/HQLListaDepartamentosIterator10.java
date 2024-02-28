import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Departamentos;
import primero.SessionFactoryUtil;

public class HQLListaDepartamentosIterator10 {
	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		/*
		 * El m�todo iterate() devuelve un interador Java para recuperar los resultados de la consulta, que en 
		 * el caso de Hibernate ejecuta la consulta obteniendo solo los ids de las entidades y en cada llamada a
		 * iterator.next ejecuta la consulta propia para obtener la entidad completa
		 * --> Mayor cantidad de accesos, m�s tiempo pero no es necesario que todos los objetos est�n cargados en memoria a la vez
		 * El m�todo setFetchSize fija la cantidad de resultados a recuperar en cada acceso			
		 */
		Query q = session.createQuery("from Departamentos");
		q.setFetchSize(10); 
		Iterator iter = q.iterate();
		
		while (iter.hasNext())
		{
		   //extraer el objeto
		   Departamentos   depar = (Departamentos) iter.next(); 
		   System.out.printf("%d, %s%n", depar.getDeptNo(), depar.getDnombre());		   
		}
		session.close();
		System.exit(0);
	}
}
