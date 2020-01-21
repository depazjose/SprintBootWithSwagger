package com.mdt.infrastructure.entry_points.reactive_web;

import com.mdt.dto.EmployeeDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/Genesis/api/empleados")
public class EmployeeController {


    @GetMapping(value = "/{anio}/general", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDto> getEmployees(@PathVariable int anio){
        return employees();
    }


    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "retrieve one employee for ID", notes="send the employee ID", httpMethod = "GET", nickname = "nickname")
    public EmployeeDto getEmployee(@PathVariable int id){
        return new EmployeeDto(new String(String.valueOf(id)), "Jhon", "Doe");
    }


    @GetMapping(value = "/observable/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "retrieve one employee for ID using REACTOR", notes="REACTIVE", httpMethod = "GET", nickname = "nicknameRx")
    public Mono<EmployeeDto> getEmployeeRx(@PathVariable int id){
        return Mono.fromSupplier(() -> new EmployeeDto(new String(String.valueOf(id)), "Jhon", "Doe"));
    }


    private List<EmployeeDto> employees(){
        List<EmployeeDto> ret = new ArrayList<>();
        ret.add( new EmployeeDto("100", "Jhon", "Doe"));
        ret.add( new EmployeeDto("101", "Mary", "Doe"));
        ret.add( new EmployeeDto("102", "Napoleon", "Dynamite"));
        return ret;
    }
}
