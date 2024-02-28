import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import primero.SessionFactoryUtil;
import primero.Totales;

public class HQLFuncionesGrupo19 {

	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();

		String hql = "select  d.deptNo,  count(e.empNo), coalesce(avg(e.salario),0), " 
		        + " d.dnombre  "
				+ " from Empleados as e right join  e.departamentos as d " 
		        + " group by  d.deptNo, d.dnombre ";

		Query cons = session.createQuery(hql);

		List<Object[]> filas = cons.list(); // Todas las filas
		for (int i = 0; i < filas.size(); i++) {
			Object[] filaActual = filas.get(i); // Acceso a una fila
			System.out.printf("Numero Dep: %d, Nombre: %s, Salario medio: %.2f, N� emple: %d%n", filaActual[0],
					filaActual[3], filaActual[2], filaActual[1]);
		}

		session.close();
		System.exit(0);
	}

}
