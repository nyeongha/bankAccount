package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bank {

  private List<Account> accounts;
  private int totalAccount = 0;

  public Bank() {
    this.accounts = new ArrayList<>();
  }

  public int getTotalAccount() {  //총 계좌수 반환 메서드
    return totalAccount;
  }


  public void addAccount(String accountNo, String name) {   //계좌생성 메서드
    Account account = new Account();
    account.setAccountNo(accountNo);
    account.setName(name);
    accounts.add(account);
    totalAccount += 1;
  }


  public Optional<Account> getAccount(String accountNo) { //계좌번호로 계좌찾는 메서드

    for (Account account : accounts) {    //accounts에 계좌가 있다면 for문 실행
      if (account.getAccountNo().equals(accountNo)) {   //해당계좌번호가 있다면
        return Optional.of(account);  //계좌객체 반환
      }
    }
    return Optional.empty();    //계좌가 없다면 Optional.empty()반환
  }


  public List<Account> getAccounts() {   //계좌 목록 반환 메서드
    return accounts;
  }

  public Optional<List<Account>> findAccounts(String name) { // 소유자명으로 계좌 찾는 메서드
    List<Account> accountFindByName = new ArrayList<>();
    for (Account ac : accounts) { // 은행에 계좌 리스트가 있으면 계좌를 돌면서
      if (ac.getName().equals(name)) { // 해당 소유주의 이름과 같은 계좌가 있다면
        accountFindByName.add(ac); // accountFindByName 리스트에 추가
      }
    }
    return accountFindByName.isEmpty() ? Optional.empty() : Optional.of(accountFindByName);
  }

}
