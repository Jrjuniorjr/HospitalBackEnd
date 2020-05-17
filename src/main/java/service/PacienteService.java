package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import model.Paciente;
import repository.PacienteRepository;

@Service
public class PacienteService {
	@Autowired
	PacienteRepository pacienteRepository;
	
	public ResponseEntity<?> cadastrarPaciente(Paciente paciente) {

		
		Paciente pacienteExist = pacienteRepository.findById(paciente.getId()).orElse(null);

		if (pacienteExist != null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Paciente já cadastrado!");
		}

		pacienteRepository.save(paciente);

		return ResponseEntity.ok().build();

	}
	
	public ResponseEntity<?> listarPacientes() {

		return ResponseEntity.ok(pacienteRepository.findAll());
	
	}
	
	public ResponseEntity<?> consultarPaciente(Integer id) {

		return ResponseEntity.ok(pacienteRepository.findById(id));

	}

	public ResponseEntity<?> editarPaciente(Paciente paciente) {

		Paciente pacienteExist = pacienteRepository.findById(paciente.getId()).orElse(null);

		if (pacienteExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}

		return ResponseEntity.ok(pacienteRepository.save(paciente));
	}

	public ResponseEntity<?> removerPaciente(Integer id) {
		Paciente pacienteExist = pacienteRepository.findById(id).orElse(null);

		if (pacienteExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		pacienteRepository.delete(pacienteExist);
		return ResponseEntity.ok(pacienteExist);
	}


}
