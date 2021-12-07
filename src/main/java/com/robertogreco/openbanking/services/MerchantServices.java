package com.robertogreco.openbanking.services;

import com.robertogreco.openbanking.dataModel.Merchant;
import com.robertogreco.openbanking.exception.MerchantAlreadyExistsException;
import com.robertogreco.openbanking.exception.MerchantNotFoundException;
import com.robertogreco.openbanking.repository.MerchantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


/**
 * servizi gestione merchant
 *
 */
@Service
public class MerchantServices {

    private final MerchantRepository merchantRepository;
    Logger log = LoggerFactory.getLogger(MerchantServices.class);

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
    public Merchant createMerchant(Merchant newMerchant) {
        Optional<Merchant> merOpt = merchantRepository.findMerchantByVat(newMerchant.getVat(), newMerchant.getBankcode());
        if (merOpt.isPresent()) {
            throw new MerchantAlreadyExistsException("merchant already exists");
        }

        newMerchant.getShopList().forEach(shop -> shop.setMerchant(newMerchant));
        Merchant savedMerchant = merchantRepository.save(newMerchant);
        savedMerchant.getShopList().forEach(shop -> shop.setMerchant(null));
        return savedMerchant;
    }

    @Transactional
    public Merchant updateMerchant(Long id, Merchant inMerchant) {
        Merchant merchantToBeUpdated = merchantRepository.findById(id).
                orElseThrow(() -> new MerchantNotFoundException("Merchant id=" + id + " does not exists"));
        try {
            // see if name changed
            if (inMerchant.getName() != null
                    && inMerchant.getName().length() > 0
                    && !merchantToBeUpdated.getName().equals(inMerchant.getName())) {
                merchantToBeUpdated.setName(inMerchant.getName());
            }
            //see if mobile changed
            if (inMerchant.getMobile() != null
                    && inMerchant.getMobile().length() > 0
                    && !merchantToBeUpdated.getMobile().equals(inMerchant.getMobile())) {
                merchantToBeUpdated.setMobile(inMerchant.getMobile());
            }

            //see if VAT changed
            if (inMerchant.getVat() != null
                    && inMerchant.getVat().length() > 0
                    && !merchantToBeUpdated.getVat().equals(inMerchant.getVat())) {
                merchantToBeUpdated.setVat(inMerchant.getVat());
            }


        } catch (Exception e) {
            log.info("unexpected exception while trying to update merchant");
        }

        return merchantToBeUpdated;
    }


}
