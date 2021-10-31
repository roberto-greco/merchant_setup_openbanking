package com.robertogreco.openbanking.controller;

import com.robertogreco.openbanking.dataModel.Merchant;
import com.robertogreco.openbanking.services.MerchantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Merchant getMerchant() {
        return merchantServices.findMerchantById(1L);
    }

    @GetMapping(path = "/merchants")
    public List<Merchant> getMerchants() {
        return merchantServices.getMerchantList();
    }
}
