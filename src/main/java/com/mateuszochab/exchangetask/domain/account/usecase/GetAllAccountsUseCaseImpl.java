package com.mateuszochab.exchangetask.domain.account.usecase;

import com.mateuszochab.exchangetask.domain.account.exception.GetAccountProblemDomainException;
import com.mateuszochab.exchangetask.domain.account.model.Account;
import com.mateuszochab.exchangetask.domain.account.port.AccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
@RequiredArgsConstructor
public non-sealed class GetAllAccountsUseCaseImpl implements GetAllAccountsUseCase {
    private final AccountPort accountPort;

    @Override
    public List<Account> execute() throws GetAccountProblemDomainException {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            Future<List<Account>> future = executor.submit(() -> {
                return accountPort.getAllAccounts();
            });

            return future.get();
        } catch (InterruptedException e) {
            throw new GetAccountProblemDomainException();
        } catch (ExecutionException e) {
            throw new GetAccountProblemDomainException();
        }
    }
}
