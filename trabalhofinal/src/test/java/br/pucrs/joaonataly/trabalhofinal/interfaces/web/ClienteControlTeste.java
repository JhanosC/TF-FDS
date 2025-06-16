package br.pucrs.joaonataly.trabalhofinal.interfaces.web;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import br.pucrs.joaonataly.trabalhofinal.controladores.ClienteControlador;
import br.pucrs.joaonataly.trabalhofinal.dominio.entidades.Cliente;
import br.pucrs.joaonataly.trabalhofinal.dominio.entidades.Empresarial;
import br.pucrs.joaonataly.trabalhofinal.dominio.entidades.Individual;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.repositorio.EmpresarialRepositorio;
import br.pucrs.joaonataly.trabalhofinal.infraestrutura.repositorio.IndividualRepositorio;

public class ClienteControlTeste {    
private EmpresarialRepositorio empresarialRepositorio;
    private IndividualRepositorio individualRepositorio;
    private ClienteControlador clienteControlador;

    @BeforeEach
    public void setUp() {
        // Cria mocks dos repositórios
        empresarialRepositorio = mock(EmpresarialRepositorio.class);
        individualRepositorio = mock(IndividualRepositorio.class);

        // Injeta os mocks no controlador
        clienteControlador = new ClienteControlador(empresarialRepositorio, individualRepositorio);
    }

    @Test
    public void deveRetornarTodosOsClientesComSucesso() {
        // Arrange
        Individual cliente1 = new Individual("João", "Rua A, 111", "11122233344");
        Empresarial cliente2 = new Empresarial("TechCorp", "Rua B, 222", "TechCorp", "11222333444455");

        when(individualRepositorio.findAll()).thenReturn(Arrays.asList(cliente1));
        when(empresarialRepositorio.findAll()).thenReturn(Arrays.asList(cliente2));

        // Act
        List<Cliente> resultado = clienteControlador.listarTodosClientes();

        // Assert
        assertEquals(2, resultado.size());
        assertEquals("João", ((Individual) resultado.get(0)).getNome());
        assertEquals("TechCorp", ((Empresarial) resultado.get(1)).getNomeFantasia());
    }
}