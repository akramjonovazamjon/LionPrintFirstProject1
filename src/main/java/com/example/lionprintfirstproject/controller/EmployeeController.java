package com.example.lionprintfirstproject.controller;

import com.example.lionprintfirstproject.controller.vm.EmployeeVm;
import com.example.lionprintfirstproject.dto.ResponseData;
import com.example.lionprintfirstproject.dto.employee.CreateEmployee;
import com.example.lionprintfirstproject.dto.employee.UpdateEmployee;
import com.example.lionprintfirstproject.entity.Employee;
import com.example.lionprintfirstproject.mapper.EmployeeMapper;
import com.example.lionprintfirstproject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;
    private final EmployeeMapper mapper;


    @PostMapping
    public ResponseData<EmployeeVm> create(
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "middleName") String middleName,
            @RequestParam(name = "phoneNumber") String phoneNumber,
            @RequestParam(name = "address") String address,
            @RequestParam(name = "file") MultipartFile file,
            @RequestParam(name = "departmentId") Long departmentId,
            @RequestParam(name = "jobId") Long jobId
    ) throws IOException {
        Employee employee = service.create(new CreateEmployee(firstName, lastName, middleName, phoneNumber, address), file, departmentId, jobId);
        return ResponseData.of(mapper.asEmployeeVm(employee));
    }

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestParam(name = "firstName") String firstName,
            @RequestParam(name = "lastName") String lastName,
            @RequestParam(name = "middleName") String middleName,
            @RequestParam(name = "phoneNumber") String phoneNumber,
            @RequestParam(name = "address") String address,
            @RequestParam(name = "file") MultipartFile file,
            @RequestParam(name = "departmentId") Long departmentId,
            @RequestParam(name = "jobId") Long jobId
    ) throws IOException {
        service.update(new UpdateEmployee(firstName, lastName, middleName, phoneNumber, address), file, id, departmentId, jobId);
    }

    @GetMapping
    public ResponseData<List<EmployeeVm>> getAll(Pageable pageable) {
        List<Employee> employeeList = service.getAll(pageable);
        return ResponseData.of(mapper.asEmployeeList(employeeList));
    }

    @GetMapping("/{id}")
    public ResponseData<EmployeeVm> getById(@PathVariable Long id) {
        Employee employee = service.getById(id);
        return ResponseData.of(mapper.asEmployeeVm(employee));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/count")
    public ResponseData<Long> countAll() {
        Long count = service.getEmployeesCount();
        return ResponseData.of(count);
    }

}
