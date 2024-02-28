import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import primero.SessionFactoryUtil;


public class EjemploUsoINSERT {

	public static void main(String[] args) {
	
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();

		// Insertamos los departamentos de la tabla NUEVOS, 
		// PREVIAMENTE: la tabla tiene
		// que estar mapeada en nuestro proyecto y también haber incluido
		// en hibernate.reveng.xml la siguiente entrada
		// <table-filter match-catalog="ejemplo3" match-name="nuevos"/>
		// y generar la nueva clase desde Hibernate Code Generation Configurations
		// para generar la claes y el fichero nuevos.hbm.xml
		// Aunque generé el proyecto entero desde el principio...

		String hqlInsert = "insert into Departamentos (deptNo, dnombre, loc) " +
			             " select n.deptNo, n.dnombre, n.loc from Nuevos n";
		Query cons=session.createQuery( hqlInsert );
		int filascreadas = cons.executeUpdate();

		System.out.printf("FILAS INSERTADAS: %d%n",filascreadas); 	

		
		tx.commit(); // valida la transacción
		session.close();
		System.exit(0);

	}

}
