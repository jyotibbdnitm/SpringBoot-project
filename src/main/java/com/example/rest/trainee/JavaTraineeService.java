package com.example.rest.trainee;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface JavaTraineeService {
    public JavaTraineeDto registerTrainee(JavaTraineeDto dto);
    public List<JavaTraineeDto> registerAllTrainee(List<JavaTraineeDto>dto);
    public List<JavaTraineeDto> getAllTrainee();
    public JavaTraineeDto getTraineeByid(String id);
    public String deleteTrainee(String id);
    public JavaTraineeDto updateTrainee(JavaTraineeDto dto, String id);

}
