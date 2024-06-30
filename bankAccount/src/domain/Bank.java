package domain;

import static exception.ErrorMessage.NO_ACCOUNT;
import static exception.ErrorMessage.NO_SUCH_ACCOUNT;

import java.util.ArrayList;
import java.util.List;


public class Bank {

    private List<Account> accounts;
    private int totalAccount;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.totalAccount = 0;
    }

    public List<Account> getAccounts() {   //계좌 목록 반환 메서드
        return accounts;
    }

    public int getTotalAccount() {  //총 계좌수 반환 메서드
        return totalAccount;
    }

    public void addAccount(String accountNo, String name) {
        Account account = new Account(accountNo, name);
        accounts.add(account);
        totalAccount++;
    }

    public boolean accountExists(String accountNo) {
        try {
            getAccount(accountNo);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public Account getAccount(String accountNo) { //계좌번호로 계좌찾는 메서드
        for (Account account : accounts) {
            if (account.getAccountNo().equals(accountNo)) {
                return account;
            }
        }
        throw new IllegalArgumentException(NO_SUCH_ACCOUNT.getMessage());
    }

    public List<Account> findAccounts(String name) { // 소유자명으로 계좌 찾는 메서드
        List<Account> accountFindByName = new ArrayList<>();

        for (Account account : accounts) {
            if (account.getName().equals(name)) {
                accountFindByName.add(account);
            }
        }

        if (accountFindByName.isEmpty()) {
            throw new IllegalArgumentException(NO_ACCOUNT.getMessage());
        }

        return accountFindByName;
    }
}
