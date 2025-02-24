package com.example.rest.trainee;

import com.example.rest.rsponsehandler.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class JavaTraineeController {

    private JavaTraineeService javaTraineeService;

    public JavaTraineeController(JavaTraineeService javaTraineeService){
        this.javaTraineeService=javaTraineeService;
    }
@PostMapping(value="/post")
    public ResponseEntity<Object> registerJavaTrainee(@RequestBody JavaTraineeDto dto){
    JavaTraineeDto trainee= javaTraineeService.registerTrainee(dto);

    if(trainee!=null){
        ResponseEntity<Object> entity=ResponseHandler.requestHandling(HttpStatus.CREATED, true, "enteered successfully", trainee);
        return entity;
    }
    else{
        ResponseEntity<Object> entity= ResponseHandler.requestHandling(HttpStatus.BAD_REQUEST, false, "Failed", trainee);
        return entity;

    }
    //ResponseEntity<Object> mesage=new ResponseEntity<Object>(HttpStatus.CREATED);

    }
@PostMapping(value="/postall")
    public ResponseEntity<List<JavaTraineeDto>> registerAllJavaTrainee(@RequestBody List<JavaTraineeDto> dto){
    List<JavaTraineeDto> list = javaTraineeService.registerAllTrainee(dto);
        ResponseEntity<List<JavaTraineeDto>>responseEntity=
                ResponseEntity
                        .status(HttpStatus.OK)
                        .body(list);
    return responseEntity;
    }
    @GetMapping(value = "/getgall")
    public List<JavaTraineeDto>  getAllJavaTrainee(){
        List<JavaTraineeDto>dto=javaTraineeService.getAllTrainee();
        return dto;
    }
    @GetMapping(value="/get/{id}")

    public ResponseEntity<Object> getJavaTraineeById(@PathVariable String id){
    JavaTraineeDto dto=javaTraineeService.getTraineeByid(id);
        if(dto!=null){
            ResponseEntity<Object> entity=ResponseHandler.requestHandling(HttpStatus.CREATED, true, "enteered successfully", dto);
            return entity;
        }
        else {
            ResponseEntity<Object> entity = ResponseHandler.requestHandling(HttpStatus.BAD_REQUEST, false, "Failed", dto);
            return entity;
        }

    }
//    @ExceptionHandler(value = ResourceNotFoundException.class)
//    public ResponseEntity<Object> exceptionhandler(){
//        return ResponseHandler.requestHandling(HttpStatus.BAD_REQUEST, false, "Exception Error", null);
//
//    }
@PutMapping(value="/put/{id}")
    public ResponseEntity<Object> updateJavaTrainee(@RequestBody JavaTraineeDto dto, @PathVariable String id){
    JavaTraineeDto javaTraineeDto=javaTraineeService.updateTrainee(dto, id);
    return ResponseEntity.ok("updated");
    }
@DeleteMapping(value="/delete/{id}")
    public String deleteJavaTrainee(@PathVariable String id){
    String trainee=javaTraineeService.deleteTrainee(id);

    return trainee;
    }


}

