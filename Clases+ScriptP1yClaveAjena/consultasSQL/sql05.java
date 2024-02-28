package consultasSQL;
import primero.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class sql05 {
	public static void main (String[] args){
		Transaction tx=null;
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		tx = session.beginTransaction();
		session.createSQLQuery("Insert into departamentos values (?,?,?)")
				.setByte(0, (byte) 88)
				.setString(1, "Departamento 88")
				.setString(2, "Loc del dep 88").executeUpdate();
	    tx.commit();
		session.close();
		System.exit(0);
	}

}
