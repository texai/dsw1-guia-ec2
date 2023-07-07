package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.lang.String;

@Controller
@RequestMapping(path="/api/curso")
public class ConDbController {

    @Autowired
    private CursoRepository cursoRepository;
    
    @GetMapping(path="/listar")
	public @ResponseBody Iterable<Curso> listar() {
		return cursoRepository.findAll();
	}

    @PostMapping(path="/nuevo")
	public @ResponseBody String nuevo (@RequestParam String nombre, @RequestParam Integer creditos) {
		Curso n = new Curso();
		n.setNombre(nombre);
		n.setCreditos(creditos);
		cursoRepository.save(n);
		return "Curso guardado";
	}

    @DeleteMapping(path="/eliminar")
	public @ResponseBody String eliminar (@RequestParam Integer id) {
		Curso n = new Curso();
		n.setId(id);
		cursoRepository.save(n);
		return "Curso Eliminado";
	}

}
