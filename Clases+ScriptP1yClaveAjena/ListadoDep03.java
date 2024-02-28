import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class ListadoDep03 {
	public static void main (String[] args){
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		System.out.println("Datos del Departamento 11.");
		System.out.println("===========================");
		Departamentos dep = new Departamentos();
		try {
			
		dep=(Departamentos) session.load(Departamentos.class, (byte) 11);
		System.out.println("Nombre Dep: " + dep.getDnombre());
		System.out.println("Localidad: "+ dep.getLoc());
		
		}catch (Exception e) { // realmente ObjectNotFoundException
			System.out.println("No existe el departamento 11");
		}
		session.close();
		System.exit(0);
	}

}
