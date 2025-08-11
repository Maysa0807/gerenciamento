package com.gerenciamento.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gerenciamento.api.apis.DateApi;
import com.gerenciamento.api.dto.PessoaDto;
import com.gerenciamento.api.entity.PessoaEntity;
import com.gerenciamento.api.mapper.PessoaMapper;
import com.gerenciamento.api.repository.PessoaRepository;

@Service

public class PessoaService {

	private final PessoaRepository pessoaRepository;
	private final PessoaMapper pessoaMapper;
	private final DateApi dateApi;

	public PessoaService(PessoaRepository pessoaRepository, PessoaMapper pessoaMapper, DateApi dateApi) {
		this.pessoaRepository = pessoaRepository;
		this.pessoaMapper = pessoaMapper;
		this.dateApi = dateApi;
	}

	@Transactional
	public List<PessoaDto> getPessoas() {
		System.out.println(dateApi.buscarData());
		return pessoaMapper.entitiesToDtos(pessoaRepository.findAllByActiveTrue());
	}

	@Transactional
	public PessoaDto save(PessoaDto pessoaDto) {
		PessoaEntity newPessoa = pessoaMapper.dtoToEntity(pessoaDto);
		newPessoa.setActive(true);
		return pessoaMapper.entityToDto(pessoaRepository.save(newPessoa));
	}

	@Transactional
	public PessoaDto update(PessoaDto pessoaDto) {
		PessoaEntity pessoa = pessoaRepository.findById(pessoaDto.getId())
				.orElseThrow(() -> new RuntimeException("Pessoa not found"));
		pessoa.setName(pessoaDto.getName());
		pessoa.setAge(pessoaDto.getAge());
		pessoa.setEmail(pessoaDto.getEmail());
		return pessoaMapper.entityToDto(pessoaRepository.save(pessoa));
	}

	@Transactional
	public void delete(String id) {
		pessoaRepository.deleteById(id);
	}
}
