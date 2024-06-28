package domain;

public class Bank {
    Account[] accounts;
    int totalAccount;

    public int getTotalAccount() {
        return totalAccount;
    }
    public void setTotalAccount(int totalAccount) {
        this.totalAccount = totalAccount;
    }
    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }
    public void addAccount(String accountNo,String name) {


    }
    public Account getAccount(String accountNo) {
        return null;

    }

    public Account[] findAccounts(String name) {
        return accounts;

    }
    public Account[] getAccounts() {
        return accounts;

    }
}
