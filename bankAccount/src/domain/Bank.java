package domain;

import java.util.ArrayList;
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


  public Optional<Account> getAccount(String accountNo) { //계좌번호로 계좌찾는 메서드
    for (Account ac : accounts) {
      if (ac.getAccountNo().equals(accountNo)) {
        return Optional.of(ac);
      }
    }
    return Optional.empty();
  }


  public List<Account> getAccounts(){   //계좌 목록 반환 메서드
    return accounts;
  }

  public List<Account> findAccounts(String name){   //소유자명으로 계좌찾는 메서드
    List<Account> accountFindByName=new ArrayList<>();
    if (accounts.isEmpty()) {   //은행에 계좌가 없다면
      return null;
    } else {
      for (Account ac : accounts) {   //은행에 계좌리스트가 있으면 계좌를 돌면서
        if (ac.getName().equals(name)) {    //해당소유주의 이름과 같은 계좌가 있다면
          accountFindByName.add(ac);    //accountFindByName리스트에 추가
        }
      }
      if (accountFindByName.isEmpty()){ //accountFindByName리스트가 비어있다면
        return null;    //널을 반환하고
      }else{    //accountFindByName리스트에 Account객체가 있다먄
        return accountFindByName;    //accountFindByName리스트를 반환
      }

    }

  }

}
