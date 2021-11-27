package com.example.demo.controller;

import com.example.demo.model.Manager;
import com.example.demo.service.ManagerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
