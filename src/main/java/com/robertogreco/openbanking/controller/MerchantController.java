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

    /**
     * Get Merchant Details by Id
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/merchant")
    public Merchant getMerchant(@RequestParam(name = "id", required = true, defaultValue = "1L") String id) {
        return merchantServices.findMerchantById(Long.valueOf(id));
    }

    /**
     * Create 1 Merchant with (at least) 1 shop and (at least 1 POI)
     *
     * @param inMerchant JSON object representing merchant to be enroled into the platform
     * @return
     */
    @PostMapping(path = "/merchant")
    public Merchant createMerchant(@RequestBody Merchant inMerchant) throws MerchantAlreadyExistsException {
        return merchantServices.createMerchant(inMerchant);
    }

    /**
     * Get Merchants List with all detail
     *
     * @return
     */
    @GetMapping(path = "/merchant/list")
    public List<Merchant> getMerchants() {
        return merchantServices.getMerchantList();
    }

    /**
     * Modify 1 Merchant
     *
     * @param inMerchant JSON object representing merchant to be updated
     * @return
     */
    @PutMapping(path = "/merchant/{id}")
    public Merchant updateMerchant(@PathVariable("id") Long id, @RequestBody Merchant inMerchant) {

        return merchantServices.updateMerchant(id, inMerchant);

    }

    /**
     * Delete 1 Merchant
     *
     * @param
     * @return
     */
    @DeleteMapping(path = "/merchant")
    public ResponseEntity<String> deleteMerchant(@RequestParam(name = "id", required = true) Long id) {

        merchantServices.delete(id);
        return new ResponseEntity<String>("resource deleted", HttpStatus.OK);

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
