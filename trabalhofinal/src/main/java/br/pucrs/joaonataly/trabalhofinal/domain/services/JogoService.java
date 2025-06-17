package br.pucrs.joaonataly.trabalhofinal.domain.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucrs.joaonataly.trabalhofinal.adaptadorInterface.repositorio.IJogoRepo;
import br.pucrs.joaonataly.trabalhofinal.domain.model.JogoModel;

@Service
public class JogoService {
    private IJogoRepo jogoRepo;

    @Autowired
    public JogoService(IJogoRepo jogoRepo) {
        this.jogoRepo = jogoRepo;
    }
    public List<JogoModel> getAllJogos() {
        return jogoRepo.getAllJogos();
    }
}
