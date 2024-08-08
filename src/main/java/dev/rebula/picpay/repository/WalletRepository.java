package dev.rebula.picpay.repository;

import dev.rebula.picpay.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
