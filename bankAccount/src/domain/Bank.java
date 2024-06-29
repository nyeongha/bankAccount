package domain;

import java.util.List;

public class Bank {

  private List<Account> accounts;
  int totalAccount;

  public int getTotalAccount() {

    return totalAccount;
  }

  public void setTotalAccount(int totalAccount) {

    this.totalAccount = totalAccount;
  }

  public void addAccount(String accountNo, String name) {   //계좌생성 메서드
    Account account=new Account();
    account.setAccountNo(accountNo);
    account.setName(name);
    accounts.add(account);

  }

  public Account getAccount(String accountNo) {
    return null;

  }


}
