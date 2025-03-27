package com.javier.cc.bank.repositories;

import com.javier.cc.bank.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, QueryByExampleExecutor<Account> {

    public List<Account> findAllByTypeAccount(Account.TypeAccount typeAccount);
    public List<Account> findAllByNumber(Long number);
    public List<Account> findAllByCustomerId(Long customerId);
}
