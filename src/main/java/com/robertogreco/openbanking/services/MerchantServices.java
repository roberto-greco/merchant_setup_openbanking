package com.robertogreco.openbanking.services;

import com.robertogreco.openbanking.dataModel.Merchant;
import com.robertogreco.openbanking.exception.MerchantAlreadyExistsException;
import com.robertogreco.openbanking.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * servizi gestione merchant
 *
 */
@Service
public class MerchantServices {

    private final MerchantRepository merchantRepository;

    @Autowired
    public MerchantServices(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    /**
     * recupera il merchant cercandolo per ID
     *
     * @param id
     * @return
     */
    public Merchant findMerchantById(Long id) {

        return merchantRepository.findById(id).get();
    }

    /**
     * recupera la lista dei merhant
     *
     * @return
     */
    public List<Merchant> getMerchantList() {
       return merchantRepository.findAll();
    }

    /**
     * aggiunge un merchant all base dati
     * @param newMerchant
     * @return
     */
    public Merchant createMerchant(Merchant newMerchant)
    {
        Optional<Merchant> merOpt=merchantRepository.findMerchantByVat(newMerchant.getVat(), newMerchant.getBankcode());
        if(merOpt.isPresent()){
           throw new MerchantAlreadyExistsException("merchant already exists");
        }
        return merchantRepository.save(newMerchant);
    }

    public Merchant updateMerchant()
    {
        return null;
    }


}
