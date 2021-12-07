package com.robertogreco.openbanking.controller;

import com.robertogreco.openbanking.dataModel.Merchant;
import com.robertogreco.openbanking.exception.MerchantAlreadyExistsException;
import com.robertogreco.openbanking.exception.MerchantNotFoundException;
import com.robertogreco.openbanking.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/openBanking")
public class MerchantController {


    MerchantServices merchantServices;

    private Merchant merchant;

    @Autowired
    public MerchantController(MerchantServices merchantServices) {
        this.merchantServices = merchantServices;
    }

    @GetMapping(path = "/merchant")
    public Merchant getMerchant( @RequestParam(name = "id",required = true, defaultValue = "1L") String id) {
        return merchantServices.findMerchantById(Long.valueOf(id));
    }

    @PostMapping(path = "/merchant")
    public Merchant createMerchant(@RequestBody Merchant inMerchant) throws MerchantAlreadyExistsException {
        return merchantServices.createMerchant(inMerchant);
    }

    @GetMapping(path = "/merchant/list")
    public List<Merchant> getMerchants() {
        return merchantServices.getMerchantList();
    }

    @PutMapping(path = "/merchant/{id}")
    public Merchant updateMerchant(@PathVariable("id") Long id, @RequestBody Merchant inMerchant) {

        return merchantServices.updateMerchant(id, inMerchant);

    }

    @ExceptionHandler(value = MerchantAlreadyExistsException.class)
    public ResponseEntity<String> handleMerchantAlreadyExistsException(MerchantAlreadyExistsException merchantAlreadyExistsException) {
        return new ResponseEntity<String>("merchant already exists", HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = MerchantNotFoundException.class)
    public ResponseEntity<String> handleMerchantNotFoundException(MerchantNotFoundException merchantNotFoundException) {
        return new ResponseEntity<String>(merchantNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
