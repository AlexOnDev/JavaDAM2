import java.util.Iterator;
import java.util.List;
import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

public class HQLConsultaParametros13 {
	public static void main (String[] args){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Empleados em = new Empleados();
	
		Query q = session.createQuery("from Empleados emp where emp.departamentos.deptNo= :ndep and emp.oficio=:ofi");
		q.setByte("ndep", (byte) 10); // vale tambi�n m�todo .setParameter
		q.setString("ofi", "DIRECTOR");
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