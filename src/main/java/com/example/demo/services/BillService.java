package com.example.demo.services;

import com.example.demo.models.Bill;
import com.example.demo.repositories.BillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BillService {

    @Autowired
    BillRepository billRepository;

    public List<Bill> getAllBills() {
        try {
            return billRepository.findAll();
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Bill getBillById(Long id) {
        try {
            return billRepository.findById(id).orElse(null);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Bill createBill(Bill bill) {
        try {
            billRepository.save(bill);
            return bill;
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public Bill updateBill(Long id, Bill bill) {
        try {
            Optional<Bill> existingBill=billRepository.findById(id);
            if(existingBill.isPresent())
            {
                Bill b=existingBill.get();
                b.setPatientId(bill.getPatientId());
                b.setAmount(bill.getAmount());
                b.setStatus(bill.getStatus());
                billRepository.save(b);
                return b;
            }
            else
            {
                System.out.println("Bill doesn't exist");
                return null;
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    public void deleteBill(long id) {
        try {
            billRepository.deleteById(id);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
