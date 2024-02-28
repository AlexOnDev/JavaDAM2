package consultasSQL;
import primero.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class sql04 {
	public static void main (String[] args){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		Departamentos dep =  (Departamentos) session.createSQLQuery(
				"SELECT dept_no, dnombre, loc FROM departamentos where dept_No = :num" )
				.addEntity(Departamentos.class)
				.setByte("num", (byte) 10)
				.uniqueResult();
		System.out.println(dep.getDnombre() + "-"+dep.getLoc());
		session.close();
		System.exit(0);
	}

}
