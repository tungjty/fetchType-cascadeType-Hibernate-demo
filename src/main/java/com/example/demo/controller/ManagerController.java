package com.example.demo.controller;

import com.example.demo.model.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping(path = "manager")
    public Manager getManagerByName(@RequestParam("name") String name) {
        return managerService.getManager(name);
    }

    @GetMapping(path = "manager/all")
    public List<Manager> getAllManagers() {
        return managerService.getManagers();
    }

    @DeleteMapping(path = "manager/delete/{id}")
    public String deleteManager(@PathVariable("id") Long id) {
        managerService.deleteMangerById(id);
        return "MANAGER WAS REMOVED SUCCESSFULLY";
    }
}
