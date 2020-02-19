package com.example.demo.service;

import com.example.demo.dto.TestDTO;
import com.example.demo.entity.TestEntity;
import com.example.demo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TestService {

    private TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public TestDTO createTestDTO(TestDTO testDTO) {
        testDTO.setAge(testDTO.getAge() + 10);
        TestEntity testEntity = TestEntity.builder()
                .name(testDTO.getName())
                .birthDate(testDTO.getBirthDate())
                .age(testDTO.getAge())
                .build();
        testRepository.save(testEntity);
        System.out.println("I AM HERE" + testDTO.toString());
        return testDTO;
    }

    public TestEntity getById(Long id) {
        return testRepository
                .findById(id)
                .orElse(null);
    }

    public List<TestEntity> getAllByName(@PathVariable String name) {
        return testRepository.findAllByName(name);
    }

}
