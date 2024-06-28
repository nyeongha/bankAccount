package domain;
/*
 * todo
 * toString 메서드
 * 코드 테스트와 하는 방법 공부하기
 * */

import java.util.List;

public class Account {

  // 필드 변수 정의
  private String accountNo;
  private String name;
  private long balance;
  private List<Transaction> transactions;

  // 게터세터 메서드
  public String getAccountNo() {
    return accountNo;
  }

  public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // 과제메서드
  public void deposit(long amount) {

  }

  public void withdraw(long amount) {
  }


}
