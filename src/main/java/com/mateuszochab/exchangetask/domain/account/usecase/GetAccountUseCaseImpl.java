package com.mateuszochab.exchangetask.domain.account.usecase;

import com.mateuszochab.exchangetask.domain.account.exception.GetAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.model.Account;
import com.mateuszochab.exchangetask.domain.account.port.AccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RequiredArgsConstructor
@Component
public non-sealed class GetAccountUseCaseImpl implements GetAccountUseCase {
    private final AccountPort accountPort;

    @Override
    public Account execute(UUID accountId) throws GetAccountProblemDomainException {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<Account> future = executor.submit(() -> {
                return accountPort.getAccount(accountId);
            });

            return future.get();
        } catch (InterruptedException e) {
            throw new GetAccountProblemDomainException();
        } catch (ExecutionException e) {
            throw new GetAccountProblemDomainException();
        }
    }
}
