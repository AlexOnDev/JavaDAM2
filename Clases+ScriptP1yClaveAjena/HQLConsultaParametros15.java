import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

public class HQLConsultaParametros15 {
	public static void main (String[] args){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Empleados em = new Empleados();
		List <Byte> numeros= new ArrayList <Byte>();
		numeros.add((byte)10);
		numeros.add((byte)20);
		Query q = session.createQuery("from Empleados emp where emp.departamentos.deptNo in :listadep");
		q.setParameterList("listadep", numeros);
		List<Empleados> lista = q.list();
		Iterator<Empleados> iter = lista.iterator();
		while (iter.hasNext()){
			em = (Empleados) iter.next();
			System.out.println(em.getEmpNo() + " - " + em.getApellido() + " - " + em.getSalario());
		}
				
		
		session.close();
		System.exit(0);
	}
}