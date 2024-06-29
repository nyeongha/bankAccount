package domain;

import java.util.List;
import java.util.Optional;

public class Bank {

  private List<Account> accounts;
  int totalAccount;

  public int getTotalAccount() {  //총 계좌수 반환 메서드
    totalAccount = accounts.size();
    return totalAccount;
  }


  public void addAccount(String accountNo, String name) {   //계좌생성 메서드
    Account account = new Account();
    account.setAccountNo(accountNo);
    account.setName(name);
    accounts.add(account);
  }

  public Account getAccount(String accountNo) {   //계좌 번호 명으로 계좌 찾는 메서드
    if (accounts.isEmpty()) {   //은행에 계좌가 없다면
      return null;
    } else {
      for (Account ac : accounts) {   //은행에 계좌리스트가 있으면 계좌를 돌면서
        if (ac.getAccountNo().equals(accountNo)) {    //해당계좌와 같은 계좌번호가 존재하면
          return ac;    //해당계좌를 반환
        }
      }
      return null;    //없으면 널을 반환
    }
  }

}
