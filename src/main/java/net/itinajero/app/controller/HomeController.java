package net.itinajero.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.tools.javac.parser.ReferenceParser.ParseException;

import net.itinajero.app.model.Pelicula;
import net.itinajero.app.service.IBannersService;
import net.itinajero.app.service.IPeliculasService;
import net.itinajero.app.util.Utileria;

@Controller
public class HomeController {

	@Autowired
	private IBannersService serviceBanners; 

	@Autowired
	private IPeliculasService servicePeliculas;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model){
		
		List<String> listaFechas = Utileria.getNextDays(4);
		List <Pelicula> peliculas = servicePeliculas.buscarTodas();
		
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("banners", serviceBanners.buscarTodos()); 
		
		System.out.println("buscando");
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model){
		
		List<String> listaFechas = Utileria.getNextDays(4);
		List <Pelicula> peliculas = servicePeliculas.buscarTodas();
		
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("banners", serviceBanners.buscarTodos()); 
		
		return "home";
	}
	
	//@RequestMapping(value="/detail", method=RequestMethod.GET)
	//public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula,@PathVariable("fecha") String fecha) {
	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int id,@PathVariable("fecha") String fecha) {

		model.addAttribute("pelicula", servicePeliculas.buscarPorId(id));
		
		return "detalle";
	}
	
}
