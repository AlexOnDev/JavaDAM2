package clases;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		Transaction tx = session.beginTransaction();
		
	
		ArrayList<Partidos> lista=(ArrayList<Partidos>) session.createQuery("FROM Partidos").list();
		
		System.out.println(lista.size());
		/*for(Equipos e: lista) {
			
			System.out.println(e.getNombre());
			for(Object o: e.getJugadoreses()) {
				Jugadores j=(Jugadores) o;
				Double media=(Double) session.createQuery("SELECT round(avg(e.puntosPorPartido),2) FROM Estadisticas as e WHERE e.jugadores.codigo= :cod").setParameter("cod", j.getCodigo()).uniqueResult();
			System.out.println(j.getCodigo() + " - " + j.getNombre() + " - " + media);
			}
		}*/
		
	
		/*Query q = session.createQuery("Select avg(altura) from Jugadores");
		Double suma=(Double) q.uniqueResult();
		System.out.println("Salario medio: " + suma);		
		
		session.close();
		System.exit(0);*/
		
		
		for(Partidos e: lista) {
			if(e.getTemporada().equals("99/00")) {
				session.delete(e);
			}
		}
		/*String hql="DELETE Partidos where temporada = :nombre";
		Query consulta=session.createQuery(hql);
		consulta.setString("nombre", "98/99");
		int filas=consulta.executeUpdate();
		System.out.println(filas);
	*/
		
		String hql="SELECT e.nombre, count(j.codigo) FROM Jugadores as j right join Equipos as e";
		Query consulta=session.createQuery(hql);
		
		tx.commit();
		session.close();
		
		
		
	}

}
