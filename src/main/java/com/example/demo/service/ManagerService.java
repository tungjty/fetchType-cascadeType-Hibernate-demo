package com.example.demo.service;

import com.example.demo.model.Manager;

import java.util.List;

public interface ManagerService {

    Manager getManager(String name);

    List<Manager> getManagers();
}
