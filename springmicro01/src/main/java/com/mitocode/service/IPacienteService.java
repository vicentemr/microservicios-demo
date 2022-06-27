package com.mitocode.service;

import com.mitocode.model.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPacienteService extends ICRUD<Paciente, Integer>{

	Page<Paciente> listarPageable(Pageable pageable);

}
