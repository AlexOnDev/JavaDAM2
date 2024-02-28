
import primero.SessionFactoryUtil;
import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class InsertaDep00 {
	public static void main(String[] args) {
		SessionFactory sesion=SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx= session.beginTransaction();
		System.out.println("Inserto una fila en la tabla Departamentos.");
		Departamentos dep = new Departamentos();
		dep.setDeptNo((byte) 62);
		dep.setDnombre("MARKETING");
		dep.setLoc("GUADALAJARA");
		session.save(dep);
		tx.commit();
		session.close();
		System.exit(0);
	}

}
