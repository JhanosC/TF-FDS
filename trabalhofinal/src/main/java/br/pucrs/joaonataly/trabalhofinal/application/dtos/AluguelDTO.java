package br.pucrs.joaonataly.trabalhofinal.application.dtos;

import br.pucrs.joaonataly.trabalhofinal.domain.model.AluguelModel;

public class AluguelDTO {
    private int identificador;
    private int clienteNumero;
    private int jogoCodigo;
    private int periodo;
    private String dataInicial;
    private ClienteDTO clienteDTO;
    private JogoDTO jogoDTO;

    public AluguelDTO(int identificador, int periodo, String dataInicial, ClienteDTO clienteDTO, JogoDTO jogoDTO) {
        this.identificador = identificador;
        this.periodo = periodo;
        this.dataInicial = dataInicial;
        this.clienteDTO = clienteDTO;
        this.jogoDTO = jogoDTO;
        this.clienteNumero = clienteDTO.getNumero();
        this.jogoCodigo = jogoDTO.getCodigo();
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public int getClienteNumero() {
        return clienteNumero;
    }

    public void setClienteNumero(int clienteNumero) {
        this.clienteNumero = clienteNumero;
    }

    public int getJogoCodigo() {
        return jogoCodigo;
    }

    public void setJogoCodigo(int jogoCodigo) {
        this.jogoCodigo = jogoCodigo;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }
    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }
    public JogoDTO getJogoDTO() {
        return jogoDTO;
    }
    public void setJogoDTO(JogoDTO jogoDTO) {
        this.jogoDTO = jogoDTO;
    }

    public AluguelModel toModel() {
        return new AluguelModel(
                identificador,
                periodo,
                java.time.LocalDate.parse(dataInicial),
                clienteDTO.toModel(),
                jogoDTO.toModel()
        );
    }
}
