package consultasSQL;
import primero.*;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class sql01 {
	public static void main (String[] args){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		List<Object[]> departamentos = session.createSQLQuery(
				"SELECT dept_no, dnombre FROM departamentos" ).list();
		for (Object[] departamento : departamentos) {
				Byte id = (Byte) departamento[0];
				String name = (String) departamento[1];
		System.out.println(id + "-"+ name);
		}
	/* Equivale a:
		SQLQuery consulta = session.createSQLQuery("SELECT dept_no, dnombre FROM departamentos" );
		List<Object[]> departamentos = consulta.list();
		for (Object[] departamento : departamentos) {
			Byte id = (Byte) departamento[0];
			String name = (String) departamento[1];
			System.out.println(id + "-"+ name);
	}
	*/
		session.close();
		System.exit(0);
	}

}
