package com.example.lionprintfirstproject.controller.vm;

public record EmployeeResponse(
        Long id,
        String firstName,
        String lastName,
        String middleName,
        String phoneNumber,
        String address,
        String imageUrl,
        DepartmentVm department,
        JobVm job
) {
}