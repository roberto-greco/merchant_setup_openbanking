package com.robertogreco.openbanking.repository;

import com.robertogreco.openbanking.dataModel.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    @Query("SELECT m FROM Merchant m WHERE m.vat=?1 AND m.bankcode=?2")
    Optional<Merchant> findMerchantByVat(String vat, String bankcode);
}
