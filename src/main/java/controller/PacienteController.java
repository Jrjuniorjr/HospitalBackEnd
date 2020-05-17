package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Paciente;
import service.PacienteService;

@CrossOrigin("*")
@RestController
@RequestMapping("/paciente")
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	

	@PostMapping("/cadastrarPaciente")
	public ResponseEntity<?> criarPaciente(@RequestBody Paciente paciente) {
		return pacienteService.cadastrarPaciente(paciente);
	}
	
	@DeleteMapping("/removerPaciente/{id}")
	public ResponseEntity<?> removerPaciente(@PathVariable("id") Integer id){
		return pacienteService.removerPaciente(id);
	}

	
	@GetMapping("/listarPacientes")
	public ResponseEntity<?> listarPacientes() {
		return pacienteService.listarPacientes();
	}
	
	@GetMapping("/consultarPaciente/{id}")
	public ResponseEntity<?> consultarPaciente(@PathVariable Integer id) {
		return pacienteService.consultarPaciente(id);
	}

	@PutMapping("editarPaciente")
	public ResponseEntity<?> editarPaciente(@RequestBody Paciente paciente) {
		return pacienteService.editarPaciente(paciente);

	}
	

}
