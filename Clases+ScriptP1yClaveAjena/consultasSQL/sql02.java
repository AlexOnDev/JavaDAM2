package consultasSQL;
import primero.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class sql02 {
	public static void main (String[] args){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		List<Object[]> departamentos = session.createSQLQuery(
				"SELECT * FROM departamentos" ).list();
		for (Object[] departamento : departamentos) {
				Byte id = (Byte) departamento[0];
				String name = (String) departamento[1];
				//String loc =  (String) departamento[2];
		System.out.println(id + "-"+ name);
		}
		
		
		session.close();
		System.exit(0);
	}

}
