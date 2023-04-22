package co.crisi.employee.controller;

import co.crisi.employee.data.EmployeeInfo;
import co.crisi.employee.port.api.EmployeeServicePort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServicePort employeeServicePort;

    @PostMapping
    public Long save(
            @RequestBody
                    EmployeeInfo employeeInfo) {
        return employeeServicePort.add(employeeInfo).getId();
    }

    @PutMapping("/{employeeId}")
    public EmployeeInfo update(
            @PathVariable(name = "employeeId")
                    Long employeeId,
            @RequestBody
                    EmployeeInfo employeeInfo) {
        return employeeServicePort.update(employeeId, employeeInfo);
    }

    @GetMapping("/{id}")
    public EmployeeInfo findById(
            @PathVariable
                    Long id) {
        return employeeServicePort.getById(id);
    }

    @GetMapping("/age/{id}")
    public int getAge(
            @PathVariable
                    Long id) {
        return employeeServicePort.getAgeByDate(id);
    }

    @GetMapping("/seniority/{id}")
    public int getSeniority(
            @PathVariable
                    Long id) {
        return employeeServicePort.getSeniority(id);
    }

    @GetMapping("/benefits/{id}")
    public double getBenefits(
            @PathVariable
                    Long id) {
        return employeeServicePort.getBenefits(id);
    }

    @GetMapping
    public List<EmployeeInfo> findAll() {
        return employeeServicePort.findAll();
    }

}
