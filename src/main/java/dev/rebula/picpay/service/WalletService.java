package dev.rebula.picpay.service;

import dev.rebula.picpay.controller.dto.CreateWalletDto;
import dev.rebula.picpay.entity.Wallet;
import dev.rebula.picpay.exception.WalletDataAlreadyExistsException;
import dev.rebula.picpay.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet createWallet(CreateWalletDto dto) {

        var walletDb = walletRepository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.cpfCnpj());
        if (walletDb.isPresent()) {
            throw new WalletDataAlreadyExistsException("CpfCnpj or email already exists");
        }

        return walletRepository.save(dto.toWallet());
    }
}
