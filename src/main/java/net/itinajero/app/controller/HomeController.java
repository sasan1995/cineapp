package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.tools.javac.parser.ReferenceParser.ParseException;

import net.itinajero.app.model.Pelicula;

@Controller
public class HomeController {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model){
		
		List <Pelicula> peliculas = getLista();

		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		
		return "home";
	}
	
	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula,@PathVariable("fecha") String fecha) {
		
		System.out.print("idPelicula: " + idPelicula);
		System.out.print("fecha: " + fecha);
		
		// TODO - Buscar en la base de datos
		
		/* String tituloPelicula = "Rapidos y furiosos";
		int duracion = 136;
		double precioEntrada = 50;
		
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);*/
		return "detalle";
	}
	
	private List<Pelicula> getLista() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Pelicula> lista = null;
		
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
			
			return lista;
		
	}
	
}
