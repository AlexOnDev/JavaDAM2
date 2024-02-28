import java.util.HashSet;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Departamentos;
import primero.Empleados;
import primero.SessionFactoryUtil;

public class EjemploAsociaciones1 {

	public static void main(String[] args) {
		// 
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		
			
		String hql = "from Departamentos as d  left join d.empleadoses order by d.deptNo";
		Query cons = session.createQuery(hql);
		Iterator q = cons.iterate();
		
		while (q.hasNext()) {
			Object[] par = (Object[]) q.next();
			Departamentos de = (Departamentos) par[0];//Departamento
			Empleados em = (Empleados) par[1]; //Empleado	
			System.out.printf("Departamento: %d, %s, %s \t",					
					de.getDeptNo() , de.getDnombre(), de.getLoc());
			if (em!=null) 
				System.out.printf("Empleado %d, %s, %n",					
						em.getEmpNo(), em.getApellido());
					
		}
		
		session.close();
		System.exit(0);
		
	}
	

}
