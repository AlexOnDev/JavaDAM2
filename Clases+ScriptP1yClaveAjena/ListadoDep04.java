import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
// el m�todo load provoca excepci�n si no encuentra resultados
// de all� de usar el m�todo get

public class ListadoDep04 {
	public static void main (String[] args){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		System.out.println("Datos del Departamento 10.");
		System.out.println("===========================");
		Departamentos dep = new Departamentos();
		dep=(Departamentos) session.get(Departamentos.class, (byte) 10);
		if (dep==null)
			System.out.println("El departamento no existe");
		else {
			
			System.out.println("Nombre Dep: " + dep.getDnombre());
			System.out.println("Localidad: "+ dep.getLoc());
		}
			session.close();
			System.exit(0);
		
	}

}
