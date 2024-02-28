import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import primero.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

public class HQLConsultaParametros16 {
	public static void main(String[] args) {
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Empleados em = new Empleados();
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		String strFecha = "1991-12-03";
		java.util.Date fecha = null;
		try {
			fecha = formatoDelTexto.parse(strFecha);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		Query q = session.createQuery("from Empleados emp where emp.fechaAlt=?");
		q.setDate(0, fecha);
		List<Empleados> lista = q.list();
		Iterator<Empleados> iter = lista.iterator();
		while (iter.hasNext()) {
			em = (Empleados) iter.next();
			System.out.println(em.getEmpNo() + " - " + em.getApellido() + " - " + em.getSalario());
		}

		session.close();
		System.exit(0);
	}
}