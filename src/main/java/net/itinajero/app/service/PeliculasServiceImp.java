package net.itinajero.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import net.itinajero.app.model.Pelicula;

@Service
public class PeliculasServiceImp implements IPeliculasService {
	
	private List<Pelicula> lista = null;
	
	public PeliculasServiceImp() {
		System.out.print("Creando una instancia de la clase PeliculasServiceImp");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		lista = new LinkedList<>();
		
		Pelicula pelicula1 = new Pelicula();
		pelicula1.setId(1);
		pelicula1.setTitulo("Power Rangers");
		pelicula1.setDuracion(120);
		pelicula1.setClasificacion("B");
		pelicula1.setGenero("Aventura");
		try {
			pelicula1.setFechaEstreno(formatter.parse("02-05-2017"));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Pelicula pelicula2 = new Pelicula();
		pelicula2.setId(2);
		pelicula2.setTitulo("La Bella y la Bestia");
		pelicula2.setDuracion(132);
		pelicula2.setClasificacion("A");
		pelicula2.setGenero("Infantil");
		try {
			pelicula2.setFechaEstreno(formatter.parse("20-05-2017"));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pelicula2.setImagen("bella.png");
		
		Pelicula pelicula3 = new Pelicula();
		pelicula3.setId(3);
		pelicula3.setTitulo("Contratiempo");
		pelicula3.setDuracion(106);
		pelicula3.setClasificacion("B");
		pelicula3.setGenero("Thriller");
		try {
			pelicula3.setFechaEstreno(formatter.parse("28-05-2017"));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pelicula3.setImagen("contratiempo.png");
		
		Pelicula pelicula4 = new Pelicula();
		pelicula4.setId(3);
		pelicula4.setTitulo("Kong");
		pelicula4.setDuracion(118);
		pelicula4.setClasificacion("B");
		pelicula4.setGenero("Accion y Aventura");
		try {
			pelicula4.setFechaEstreno(formatter.parse("06-06-2017"));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pelicula4.setImagen("kong.png");
		pelicula4.setEstatus("Inactiva");
		
		Pelicula pelicula5 = new Pelicula();
		pelicula5.setId(5);
		pelicula5.setTitulo("Life");
		pelicula5.setDuracion(104);
		pelicula5.setClasificacion("B");
		pelicula5.setGenero("Drama");
		try {
			pelicula5.setFechaEstreno(formatter.parse("10-06-2017"));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pelicula5.setImagen("estreno5.png");
		pelicula5.setEstatus("Activa");
		
		lista.add(pelicula1);
		lista.add(pelicula2);
		lista.add(pelicula3);
		lista.add(pelicula4);
		lista.add(pelicula5);	
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return lista;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for(Pelicula p : lista) {
			if (p.getId() == idPelicula) {
				return p;
			}
		}
		return null;
	}

	@Override
	public void insertar(Pelicula pelicula) {

		lista.add(pelicula);
	}

}
