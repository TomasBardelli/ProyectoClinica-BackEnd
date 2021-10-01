package com.example.ProyectoClinica;

import com.example.ProyectoClinica.model.Domicilio;
import com.example.ProyectoClinica.model.Paciente;
import com.example.ProyectoClinica.service.PacienteServiceImp;
import com.example.ProyectoClinica.util.Jsons;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class IntegracionPacienteTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PacienteServiceImp pacienteService;

    @Test
    public void registrarPaciente() throws Exception{
        Domicilio domicilio = new Domicilio("Calle Falsa","123","San Martin","Buenos Aires");
        Paciente paciente = pacienteService.guardarPaciente(new Paciente("Bardelli","Tomas","tomas@gmail.com","123",new Date(), domicilio));
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/pacientes/registrar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(Jsons.asJsonString(paciente)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        Assert.assertFalse((response.getResponse()).getContentAsString().isEmpty());
    }

    @Test
    public void listarPacientes() throws Exception{
        this.registrarPaciente();
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/pacientes", 1).accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());
    }
}
