

import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

public class HQLFuncionesGrupo18 {
	public static void main (String[] args){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Query q = session.createQuery("Select avg(salario) from Empleados");
		Double suma=(Double) q.uniqueResult();
		System.out.println("Salario medio: " + suma);		
		
		session.close();
		System.exit(0);
	}
}