package domain;

import java.util.ArrayList;
import java.util.List;

public class Account {

  // 필드 변수 정의
  private String accountNo;
  private String name;
  private long balance;
  private List<Transaction> transactions;

  // 생성자 정의 및 기본값 설정
  public Account(String accountNo, String name) {
    this.accountNo = accountNo;
    this.name = name;
    this.balance = 0L;  // 기본 잔고 0원
    this.transactions = new ArrayList<Transaction>();
  }

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

  public long getBalance() {
    return balance;
  }

  public List<Transaction> getTransactions() {
       return transactions;
  }

  public void deposit(long amount) {
    // 잔고 입금
    this.balance += amount;

    // 거래내역 객체 생성 및 필드값 설정
    Transaction transaction = new Transaction("입금", amount, balance);

    // 거래내역 리스트에 추가
    transactions.add(transaction);
  }

  public void withdraw(long amount) {
    // 잔고 출금
    this.balance -= amount;

    // 거래내역 객체 생성 및 필드값 설정
    Transaction transaction = new Transaction("출금", amount, balance);

    // 거래내역 리스트에 추가
    transactions.add(transaction);
  }

  @Override
  public String toString() {
    return "[계좌번호: " + accountNo+
            ", 소유자 명: " + name + '\'' +
            ", 잔액: " + balance +"]";
  }
}
