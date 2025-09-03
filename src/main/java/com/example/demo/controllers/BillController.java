package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Bill;
import com.example.demo.services.BillService;

import java.util.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/v1/bills")
public class BillController {
    
    @Autowired
    BillService billService;

    @GetMapping
    public List<Bill> getAllBills() {
        System.out.println("All Bills");
        return billService.getAllBills(); 
    }
    @GetMapping("/{id}")
    public Bill getBillById(@PathVariable Long id) {
        System.out.println(id);
        return billService.getBillById(id);
    }
    
    @PostMapping()
    public Bill createBill(@RequestBody Bill bill) {
        System.out.println("New Bill created");
        return billService.createBill(bill);
    }
    
    @PutMapping("/{id}")
    public Bill updateBill(@PathVariable Long id, @RequestBody Bill bill) {
        System.out.println("Bill with id: "+id+" updated");
        return billService.updateBill(id, bill);
    }

    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id) {
        billService.deleteBill(id);
        System.out.println("Bill Deleted Successfully");
    }
}
