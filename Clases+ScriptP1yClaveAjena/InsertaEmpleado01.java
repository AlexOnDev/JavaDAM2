
import primero.SessionFactoryUtil;
import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class InsertaEmpleado01 {
	public static void main(String[] args) {
		SessionFactory sesion=SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx= session.beginTransaction();
		System.out.println("Inserto Empleado en el Departamento 10");
		//
		Float salario = new Float(1500);
		Float comision= new Float (10);
		Empleados em = new Empleados();
		em.setEmpNo((short) 4455);
		em.setApellido("Pepe");
		em.setDir((short) 7499);
		em.setOficio("VENDEDOR");
		em.setSalario(salario);
		em.setComision(comision);
		//
		Departamentos d = new Departamentos();
		d.setDeptNo((byte)10); 
		em.setDepartamentos(d);
		java.util.Date hoy = new java.util.Date();
		java.sql.Date fecha = new java.sql.Date(hoy.getTime());
		em.setFechaAlt(fecha);
		session.save(em);
		tx.commit();
		session.close();
		System.exit(0);
	}

}
