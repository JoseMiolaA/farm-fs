package com.jose.projetofs.controllertest;

import com.jose.projetofs.controller.FarmController;
import com.jose.projetofs.dto.FarmDTO;
import com.jose.projetofs.service.IFarmService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest(controllers = FarmController.class)
public class FarmControllerTests {

    @Autowired
    private FarmController farmController;

    @MockBean
    private IFarmService farmService;

    @BeforeEach
    public void setup(){
        standaloneSetup(this.farmController);
    }

    public void getByNameSuccess(){
        //implementar
    }
    public void getAllSuccess(){
        //implementar
    }



    @Test
    public void getByIdSuccess(){
        FarmDTO farmDTO = new FarmDTO("id", "Farm1", 2.0, 2.0,1.0);
        Mockito.when(farmService.getById("id"))
                .thenReturn(farmDTO);
        ResponseEntity<FarmDTO> response = farmController.getById("id");

        Assertions.assertEquals(farmDTO, response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    public void createSuccess(){
        //implementar
    }

    public void deleteSuccess(){
        //implementar
    }


}
