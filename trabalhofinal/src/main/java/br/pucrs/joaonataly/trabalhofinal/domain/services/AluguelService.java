package br.pucrs.joaonataly.trabalhofinal.domain.services;

import br.pucrs.joaonataly.trabalhofinal.domain.model.*;
import org.springframework.stereotype.Service;

@Service
public class AluguelService {
    public static double calcularValorFinal(AluguelModel aluguelModel) {
        double valorAluguel = calcularValorJogo(aluguelModel.getJogo());
        return calcularAluguel(valorAluguel, aluguelModel.getCliente(), aluguelModel.getJogo(), aluguelModel.getPeriodo());
    }

    private static double calcularValorJogo(JogoModel jogo) {
        if (jogo instanceof JogoEletronicoModel eletronico) {
            return switch (eletronico.getTipo()) {
                case AVENTURA -> eletronico.getValorBase() * 1.05;
                case ESTRATEGIA -> eletronico.getValorBase() * 1.15;
                case SIMULACAO -> eletronico.getValorBase() * 1.25;
            };
        } else if (jogo instanceof JogoMesaModel mesa) {
            return switch (mesa.getTipo()) {
                case TABULEIRO -> mesa.getValorBase() * mesa.getNumeroPecas();
                case CARTAS -> mesa.getValorBase() * 1.2;
            };
        } else {
            throw new IllegalArgumentException("Tipo de jogo desconhecido");
        }
    }

    private static double calcularAluguel(double valorBase, ClienteModel cliente, JogoModel jogo, int periodo) {
        boolean ehEmpresarial = cliente instanceof EmpresarialModel;
        boolean ehIndividual = cliente instanceof IndividualModel;

        if (ehEmpresarial) {
            if (jogo instanceof JogoEletronicoModel) {
                return valorBase * periodo;
            } else if (jogo instanceof JogoMesaModel) {
                return valorBase * periodo * 0.85;
            }
        } else if (ehIndividual) {
            if (periodo < 7) {
                return valorBase * periodo * 0.90;
            } else if (periodo <= 14) {
                return valorBase * periodo * 0.80;
            } else {
                return valorBase * periodo * 0.75;
            }
        }

        throw new IllegalArgumentException("Cliente ou tipo de jogo inválido.");
    }

}
