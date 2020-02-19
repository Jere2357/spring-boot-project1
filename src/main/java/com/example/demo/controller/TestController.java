package com.example.demo.controller;

import com.example.demo.dto.TestDTO;
import com.example.demo.entity.TestEntity;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController //contains rest endpoints
@RequestMapping(path = "test") //localhost:8080/test
public class TestController {

    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping     // get http command
    public String getTest() {
        return "Hello world";
    }

    @GetMapping(path = "sample") //localhost:8080/test/sample
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getSample(){
        return "This is Sample";
    }

    @GetMapping(path = "dto")   //localhost:8080/test/dto
    public ResponseEntity<TestDTO> getDTO() {
        TestDTO testDTO = new TestDTO(
                "Jeremiah",
                21,
                LocalDate.now()
        );
        return  ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
                .body(testDTO);
    }

    @PostMapping(path = "dto")  // post http command
    @ResponseStatus(HttpStatus.CREATED)
    public TestDTO postDTO(@RequestBody TestDTO testDTO) {
        System.out.println(testDTO);
        return testService.createTestDTO(testDTO);
    }

    @GetMapping(path = "dto/{id}")   //localhost:8080/test/dto/{id}
    public TestEntity getById(@PathVariable Long id) {
        return testService.getById(id);
    }

    @GetMapping(path = "dto/name/{name}")    //localhost:8080/test/dto/{name}
    public List<TestEntity> getAllByName(@PathVariable String name) {
        return testService.getAllByName(name);
    }
}

