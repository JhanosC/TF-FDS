package br.pucrs.joaonataly.trabalhofinal.domain.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucrs.joaonataly.trabalhofinal.domain.repository.IJogoRepository;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoModel;

@Service
public class JogoService {
    private IJogoRepository jogoRepo;

    @Autowired
    public JogoService(IJogoRepository jogoRepo) {
        this.jogoRepo = jogoRepo;
    }
    public List<JogoModel> getAllJogos() {
        return jogoRepo.getAllJogos();
    }
}
