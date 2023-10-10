package com.medicine.controller;

import com.medicine.model.Admin;
import com.medicine.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v4")
@RestController
public class AdminController {

  @Autowired
  private AdminService adminService;

  @GetMapping("/loginAdmin")
  public ResponseEntity<Object> validateAdminLogin(
    @RequestBody Admin adminlogin
  ) {
    Admin admin = adminService.validateAdmin(adminlogin);
    if (admin == null) return new ResponseEntity<>(
      "Invalid credentials",
      HttpStatus.NOT_FOUND
    ); else return new ResponseEntity<>("Successful login", HttpStatus.OK);
  }
}
