package com.jose.projetofs.controllertest;

import com.jose.projetofs.controller.FarmController;
import com.jose.projetofs.dto.FarmDTO;
import com.jose.projetofs.model.Farm;
import com.jose.projetofs.service.IFarmService;
import com.jose.projetofs.service.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@WebMvcTest(controllers = FarmController.class)
public class FarmControllerTests {

    @Autowired
    private FarmController farmController;

    @MockBean
    private IFarmService farmService;

    private FarmDTO farmDTO;

    private List<FarmDTO> farmDTOs;

    private Farm farm;

    @BeforeEach
    public void setup(){
        standaloneSetup(this.farmController);


        farmDTO = new FarmDTO("id", "Farm", 4.0, 2.0, 2.0);

        farmDTOs = new ArrayList<>();
        farmDTOs.add(new FarmDTO("id1", "Farm", 4.0, 2.0, 2.0));
        farmDTOs.add(new FarmDTO("id2", "Farm2", 8.0, 4.0, 2.0));

        farm = new Farm ("Farm");

    }


    @Test
    public void getByNameSuccess(){

        Mockito.when(farmService.getByName("Farm2"))
                .thenReturn(farmDTOs);
        ResponseEntity<List<FarmDTO>> response = farmController.getByName("Farm2");

        Assertions.assertEquals(farmDTOs, response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getAll_Success(){

        Mockito.when(farmService.getAll())
                .thenReturn(farmDTOs);

        ResponseEntity<List<FarmDTO>> response = farmController.getAll();

        Assertions.assertEquals(farmDTOs, response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void getById_Success(){
        Mockito.when(farmService.getById("id"))
                .thenReturn(farmDTO);
        ResponseEntity<FarmDTO> response = farmController.getById("id");

        Assertions.assertEquals(farmDTO, response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void create_Created(){
        Farm farm = new Farm("Farm");
        FarmDTO farmDTOCreated = new FarmDTO("id", "Farm", 0, 0, Double.NaN);

        Mockito.when(farmService.create(farm)).thenReturn(farmDTOCreated);
        ResponseEntity<FarmDTO> response = farmController.create(farm);

        Assertions.assertEquals(farmDTOCreated, response.getBody());
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void delete_Success(){
        ResponseEntity<FarmDTO>  response = farmController.delete("id");
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }


}
