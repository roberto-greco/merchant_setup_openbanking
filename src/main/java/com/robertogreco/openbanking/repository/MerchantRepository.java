package com.robertogreco.openbanking.repository;

import com.robertogreco.openbanking.dataModel.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
