import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Empleados;
import primero.SessionFactoryUtil;

public class EjemploAsociaciones3 {
	public static void main(String[] args) {
		//
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		String hql = "from Empleados ";
		Query cons = session.createQuery(hql);
		
		List<Empleados> lis = cons.list();
		Iterator<Empleados> ite = lis.iterator();

		System.out.println("========================================");
		while (ite.hasNext()) {
			Empleados emple = (Empleados) ite.next();
			if (emple != null) {
				Set acargo = emple.getEmpleacargo(); //empleados a cargo

				if (acargo.size() == 0) {// no son directores
					System.out.printf("EMPLEADO: %d, %s %n", emple.getEmpNo(), emple.getApellido());
					System.out.println("========================================");
				} else {
					System.out.printf("DIRECTOR: %d, %s %n", 
							 emple.getEmpNo(), emple.getApellido());
					System.out.println("A cargo: " + acargo.size());
					
					Iterator it = acargo.iterator();
					while (it.hasNext()) { // recorro los empleados a cargo
						Empleados em = (Empleados) it.next();
						System.out.printf("\t %d, %s %n", 
								em.getEmpNo(), em.getApellido());
					}
					System.out.println("========================================");
				}
			}
		}//

		session.close();
		System.exit(0);

	}

}
