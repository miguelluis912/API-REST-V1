package com.pruebas.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.dao.PersonaDAO;
import com.pruebas.model.Persona;

@RestController
@RequestMapping("personas")
public class PersonaRest {
	
	//inyectamos a persona DAO
	@Autowired 
	private PersonaDAO personaDAO;
	
	@PostMapping("/guardar")
	public void guardar(@RequestBody Persona persona) {
		personaDAO.save(persona);
	}
	
	@GetMapping("/show")
	public List<Persona> show(){
		return personaDAO.findAll();
	}
	
	@DeleteMapping("delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		personaDAO.deleteById(id);
	}
	
	@PutMapping("update")
	public void update(@RequestBody Persona persona) {
		personaDAO.save(persona);
		
	}

}
