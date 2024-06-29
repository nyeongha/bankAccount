package domain;

import java.util.List;

public class Bank {

  private List<Account> accounts;
  int totalAccount;

  public int getTotalAccount() {  //총 계좌수 반환 메서드
    totalAccount=accounts.size();
    return totalAccount;
  }


  public void addAccount(String accountNo, String name) {   //계좌생성 메서드
    Account account=new Account();
    account.setAccountNo(accountNo);
    account.setName(name);
    accounts.add(account);
  }

  public Account getAccount(String accountNo) {   //계좌 번호 명으로 계좌 찾는 메서드

    return null;

  }


}
