package net.itinajero.app.service;

import org.springframework.stereotype.Service;
import net.itinajero.app.model.Noticia;

@Service
public class NoticiasServiceImpl implements INoticiasService {

	public NoticiasServiceImpl() {
		System.out.println("Creando una instancia de la clase NoticiasServiceImpl");
	}
	
	@Override
	public void guardar(Noticia noticia) {
		System.out.println("Guadando el objeto " + noticia + " en la base de datos.");
	}
	
}