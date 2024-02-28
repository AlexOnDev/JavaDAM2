import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class HQLConsultaParametros12 {
	public static void main (String[] args){
		
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		System.out.println("Datos de los Departamentos.");
		System.out.println("===========================");
		/* Parámetros posicionales al estilo JDBC
		 * En el resultado aparecía como deprecated 
		 * Departamentos dep = (Departamentos) session.createQuery(
				"from Departamentos as dep " +
		         "where dep.deptNo= ?").setInteger(0, 20).uniqueResult();*/
		Departamentos dep = (Departamentos) session.createQuery(
				"from Departamentos as dep " +
		         "where dep.deptNo= :deptNO").setInteger("deptNO", 20).uniqueResult();
		System.out.print("Número: " + dep.getDeptNo());
		System.out.print("\tNombre: " + dep.getDnombre());
		System.out.println("\tLocalidad: "+ dep.getLoc());
		
		//
		/*
		 * dep = (Departamentos) session.createQuery(
				"from Departamentos as dep " +
		         "where dep.dnombre= ?").setString(0, "CONTABILIDAD").uniqueResult();
		 */
		dep = (Departamentos) session.createQuery(
				"from Departamentos as dep " +
		         "where dep.dnombre=:dnombRE").setString("dnombRE", "CONTABILIDAD").uniqueResult();
		System.out.print("Número: " + dep.getDeptNo());
		System.out.print("\tNombre: " + dep.getDnombre());
		System.out.println("\tLocalidad: "+ dep.getLoc());
		session.close();
		System.exit(0);
		
	}

}
