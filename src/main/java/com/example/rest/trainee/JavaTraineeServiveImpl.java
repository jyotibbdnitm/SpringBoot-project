package com.example.rest.trainee;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class JavaTraineeServiveImpl implements JavaTraineeService {

    private JavaTraineeRepository javaTraineeRepository;


   private ObjectMapper mapper;

   public JavaTraineeServiveImpl(JavaTraineeRepository javaTraineeRepository, ObjectMapper mapper){
       this.javaTraineeRepository=javaTraineeRepository;
       this.mapper=mapper;
       this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
   }

    @Override
    public JavaTraineeDto registerTrainee(JavaTraineeDto dto) {
        JavaTraineeEntity convetedValue= mapper.convertValue(dto, JavaTraineeEntity.class);
        JavaTraineeEntity javaTraineeEntity=javaTraineeRepository.save(convetedValue);
        JavaTraineeDto dtoo=mapper.convertValue(javaTraineeEntity, JavaTraineeDto.class);
        return dtoo;
    }

    @Override
    public List<JavaTraineeDto> registerAllTrainee(List<JavaTraineeDto> dto) {
        List<JavaTraineeEntity> entities= Arrays.asList(mapper.convertValue(dto, JavaTraineeEntity[].class));
        List<JavaTraineeEntity>javaTraineeEntities=javaTraineeRepository.saveAll(entities);
        List<JavaTraineeDto>javaTraineeDtos=Arrays.asList(mapper.convertValue(javaTraineeEntities, JavaTraineeDto[].class));
        return javaTraineeDtos;
    }

    @Override
    public List<JavaTraineeDto> getAllTrainee() {
        List<JavaTraineeEntity> all=javaTraineeRepository.findAll();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<JavaTraineeDto> dto=Arrays.asList(mapper.convertValue(all, JavaTraineeDto[].class));
        return dto;
    }

    @Override
    public JavaTraineeDto getTraineeByid(String id) {
        JavaTraineeEntity entity= javaTraineeRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JavaTraineeDto dto=mapper.convertValue(entity, JavaTraineeDto.class);
        //JavaTraineeDto dto= mapper.convertValue(entity, JavaTraineeDto.class);
        return dto;
    }

    @Override
    public String deleteTrainee(String id) {
        javaTraineeRepository.deleteById(id);
        return "Trainee deleted succesfully";
    }

    @Override
    public JavaTraineeDto updateTrainee(JavaTraineeDto dto, String id) {
        Optional<JavaTraineeEntity>eOptional=javaTraineeRepository.findById(id);
        JavaTraineeEntity convetedValue= mapper.convertValue(dto, JavaTraineeEntity.class);
        convetedValue.setId(id);
        JavaTraineeEntity javaTraineeEntity=javaTraineeRepository.save(convetedValue);
        JavaTraineeDto javaTraineeDto=mapper.convertValue(javaTraineeEntity, JavaTraineeDto.class);


        return javaTraineeDto;
    }
}
