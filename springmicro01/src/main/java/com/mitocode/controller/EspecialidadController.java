package com.mitocode.controller;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Especialidad;
import com.mitocode.service.IEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {
	
	@Autowired
	private IEspecialidadService service;
	
	@GetMapping
	public ResponseEntity<List<Especialidad>> listar() throws Exception{
		List<Especialidad> lista = service.listar();
		return new ResponseEntity<List<Especialidad>>(lista, HttpStatus.OK);
	}

	@GetMapping("/hateoas/{id}")
	public EntityModel<Especialidad> listarPorIdHateoas(@PathVariable("id") Integer id) throws Exception{
		Especialidad obj = service.listarPorId(id);

		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		
		//localhost:8080/pacientes/{id}
		EntityModel<Especialidad> recurso = EntityModel.of(obj);
		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		recurso.add(linkTo.withRel("especialidad-recurso"));
		
		return recurso;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidad> listarPorId(@PathVariable("id") Integer id) throws Exception{  //@RequestParam
		Especialidad obj = service.listarPorId(id);		
			
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		return new ResponseEntity<Especialidad>(obj, HttpStatus.OK);
	}
	
	/*@PostMapping
	public ResponseEntity<Especialidad> registrar(@Valid @RequestBody Especialidad especialidad) {
		Especialidad obj = service.registrar(especialidad);
		return new ResponseEntity<Especialidad>(obj, HttpStatus.CREATED);
	}*/

	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Especialidad especialidad) throws Exception{		
		Especialidad obj = service.registrar(especialidad);
		
		//localhost:8080/pacientes/7
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEspecialidad()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Especialidad> modificar(@Valid @RequestBody Especialidad especialidad) throws Exception{
		Especialidad obj = service.modificar(especialidad);
		return new ResponseEntity<Especialidad>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Especialidad obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
