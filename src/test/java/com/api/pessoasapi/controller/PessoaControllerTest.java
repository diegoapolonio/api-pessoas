package com.api.pessoasapi.controller;

import com.api.pessoasapi.model.Endereco;
import com.api.pessoasapi.model.Pessoa;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(0)
    public void deveCadastrarComSucesso() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Diego");
        pessoa.setCpf("064549507");
        pessoa.setRg("14983585");
        pessoa.setEmail("rpbs@gmail.com");
        Endereco endereco = new Endereco();
        endereco.setLogradouro("123123");
        endereco.setRua("asadsasd");
        endereco.setNumero("123123");
        pessoa.setId(1);
        pessoa.setEndereco(endereco);

        String json = objectMapper.writeValueAsString(pessoa);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/pessoas")
                    .contentType("application/json")
                    .content(json)
                ).andExpect(MockMvcResultMatchers.status().isOk());
    }

   @Test
   @Order(3)
    public void deveAtualizarComSucesso() throws Exception {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Apolo");
        pessoa.setCpf("0645588507");
        pessoa.setRg("149832352");
        pessoa.setEmail("aped@gmail.com");
        Endereco endereco = new Endereco();
        endereco.setLogradouro("123");
        endereco.setRua("asadsasd");
        endereco.setNumero("13");
        pessoa.setId(1);
        pessoa.setEndereco(endereco);

        String json = objectMapper.writeValueAsString(pessoa);

        mockMvc.perform(
                MockMvcRequestBuilders.put("/api/pessoas/1")
                        .contentType("application/json")
                        .content(json)

        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
   @Test
   @Order(2)
   public void naoDeveDeletarComSucesso() throws Exception {

       mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/pessoas/6")
                       .contentType("application/json")
        ).andExpect(MockMvcResultMatchers.status().isNotFound());
    }
    @Test
    @Order(5)
    public void deveDeletarComSucesso() throws Exception {

        mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/pessoas/1")
                        .contentType("application/json")

        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    @Order(4)
    public void devePegarNomeComSucesso() throws Exception {
      Pessoa pessoa = new Pessoa();
      pessoa.setNome("Apolo");
      pessoa.setCpf("0645588507");
      pessoa.setRg("149832352");
      pessoa.setEmail("aped@gmail.com");
      Endereco endereco = new Endereco();
      endereco.setLogradouro("123");
      endereco.setRua("asadsasd");
      endereco.setNumero("13");
      pessoa.setId(1);
      pessoa.setEndereco(endereco);

      String json = objectMapper.writeValueAsString(pessoa);
       mockMvc.perform(
               MockMvcRequestBuilders.get("/api/pessoas/buscarPorNome?nome=Apolo")
                       .contentType("application/json")
                       .content(json)

        ).andExpect(MockMvcResultMatchers.status().isOk());
   }

}
