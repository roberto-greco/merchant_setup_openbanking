package com.robertogreco.openbanking.services;

import com.robertogreco.openbanking.dataModel.Merchant;
import com.robertogreco.openbanking.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MerchantServices {

    private final MerchantRepository merchantRepository;

    @Autowired
    public MerchantServices(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public Merchant findMerchantById(Long id) {
        return new Merchant(1L, "tesco", "vat12345", "+35123456", "12098");
    }

    public List<Merchant> getMerchantList() {
       return merchantRepository.findAll();
    }


}
