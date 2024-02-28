import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.Departamentos;
import primero.Empleados;
import primero.SessionFactoryUtil;
/*
 * Poner en Empleados.hbm.xml, antes de </class> (un empleado que es director puede tener otros empleados a su cargo)
 
       <set name = "empleacargo" table="empleados"> 
        <key column="dir" />
        <one-to-many class ="primero.Empleados" />
        </set> 
    
    
   y en Empleados.java
   
   private Set <Empleados> empleacargo = new HashSet<Empleados>(0);
	public Set<Empleados> getEmpleacargo() {
		return empleacargo;
	}
	public void setEmpleacargo(Set<Empleados> empleacargo) {
		this.empleacargo=empleacargo;
	}
 */
public class EjemploAsociaciones2 {

	public static void main(String[] args) {
		// 
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		
		//String hql = "from Empleados emp1, Empleados emp2 where emp1.empNo=emp2.dir order by emp1.empNo";
		//En la anterior consulta no asociada faltarían los empleados que no tienen director. Pero:
		// La siguiente da error pues no se especifica cláusula on en HQL:
		//String hql = "from Empleados emp1 right join Empleados emp2 on emp1.empNo=emp2.dir  order by emp1.empNo";
		
		String hql = "from Empleados as emp  right join emp.empleacargo order by emp.empNo";
		Query cons = session.createQuery(hql);
		Iterator q = cons.iterate();
		
		while (q.hasNext()) {
			Object[] par = (Object[]) q.next();
			Empleados dir = (Empleados) par[0];//director
			Empleados em = (Empleados) par[1]; //empleado
			if(dir!=null)				
			System.out.printf("Empleado: %d, %s, DIRECTOR: %d, %s %n",					
					em.getEmpNo(), em.getApellido(), 
					dir.getEmpNo(), dir.getApellido());
			else
				System.out.printf("Empleado %d, %s, SIN DIRECTOR.%n",					
						em.getEmpNo(), em.getApellido());
					
		}
		
		session.close();
		System.exit(0);
		
	}
	

}
