import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Departamentos;
import primero.SessionFactoryUtil;

public class HQLListaDepartamentos09 {

	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
	/*
	 * el método list() devuelve en una colección todos los resultados de la consulta. Una única comunicación
	 * con la bda --> memoria suficiente para almacenar los objetos resultantes de la consulta
	 */
					
		Query q = session.createQuery("from Departamentos");
		List <Departamentos> lista = q.list();
		// Obtenemos un Iterador y recorremos la lista.
		Iterator <Departamentos> iter = lista.iterator();
		System.out.printf("Número de registros: %d%n",lista.size());
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
