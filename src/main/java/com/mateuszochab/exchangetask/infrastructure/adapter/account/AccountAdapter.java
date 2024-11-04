package com.mateuszochab.exchangetask.infrastructure.adapter.account;

import com.mateuszochab.exchangetask.domain.account.model.Account;
import com.mateuszochab.exchangetask.domain.account.port.AccountPort;
import com.mateuszochab.exchangetask.infrastructure.common.exception.AccountAlreadyExistsException;
import com.mateuszochab.exchangetask.infrastructure.persistence.account.mapper.AccountEntityMapper;
import com.mateuszochab.exchangetask.infrastructure.persistence.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountAdapter implements AccountPort {
   private final AccountRepository accountRepository;

    @Override
    public Account addUser(Account account) {
       //place of improvements - reducing database calls by using e.g Bloom filter + Redis
        if (accountRepository.existsByUuid(account.getUuid()))
            throw new AccountAlreadyExistsException();

       return AccountEntityMapper.MAPPER.mapAccountEntityToAccount(
               accountRepository.save(AccountEntityMapper.MAPPER.mapAccountToAccountEntity(account))) ;
    }
}
