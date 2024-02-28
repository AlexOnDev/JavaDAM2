import primero.*;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
// 
public class ListadoDep05 {
	public static void main (String[] args){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		System.out.println("Datos del Departamento 10.");
		System.out.println("===========================");
		Departamentos dep = new Departamentos();
		dep=(Departamentos) session.get(Departamentos.class, (byte) 10);
		if (dep==null) {
			System.out.println("El departamento no existe");
			System.exit(-1);
		}
		else {
			
			System.out.println("Nombre Dep: " + dep.getDnombre());
			System.out.println("Localidad: "+ dep.getLoc());
		}
			
		System.out.println("Empleados del Departamento 10.");
		System.out.println("==============================");
		Set<Empleados> listaemple = dep.getEmpleadoses();
		Iterator<Empleados> it = listaemple.iterator();
		System.out.println("Numero de empleados--> " + listaemple.size());
		/*while (it.hasNext()) {
			Empleados emple = it.next();
			System.out.println(emple.getApellido() + "  " + emple.getSalario());
		}*/
		for(Empleados emple: listaemple) {
			System.out.println(emple.getApellido() + "  " + emple.getSalario());
		}
		System.out.println("==============================");
		session.close();
		System.exit(0);
	}

}
