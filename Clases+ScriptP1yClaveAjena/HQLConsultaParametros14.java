import java.util.Iterator;
import java.util.List;

import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

public class HQLConsultaParametros14 {
	public static void main (String[] args){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Empleados em = new Empleados();
		Query q = session.createQuery("from Empleados emp where emp.departamentos.deptNo= ? and emp.oficio=?");
		q.setInteger(0, 20);
		q.setString(1, "ANALISTA");
		List<Empleados> lista = q.list();
		Iterator<Empleados> iter = lista.iterator();
		while (iter.hasNext()){
			em = (Empleados) iter.next();
			System.out.println(em.getApellido() + " - " + em.getSalario());
		}
				
		
		session.close();
		System.exit(0);
	}
}