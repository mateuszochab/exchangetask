package com.mateuszochab.exchangetask.domain.account.usecase;

import com.mateuszochab.exchangetask.domain.account.exception.CreateAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.model.Account;
import com.mateuszochab.exchangetask.domain.account.port.AccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Create Account use case
 */

@RequiredArgsConstructor
@Component
public non-sealed class CreateAccountUseCaseImpl implements CreateAccountUseCase {
    private final AccountPort accountPort;

    @Override
    public Account execute(Account account) throws CreateAccountProblemDomainException {
        account.setUuid(UUID.randomUUID());

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<Account> future = executor.submit(() -> {
                return accountPort.addUser(account);
            });

            return future.get();
        } catch (InterruptedException e){
            throw new CreateAccountProblemDomainException();
        } catch (ExecutionException e){
            throw new CreateAccountProblemDomainException();
        }
    }
}
