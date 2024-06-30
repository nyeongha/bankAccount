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
  public Account() {
    this.balance = 0L;  // 기본 잔고 0원
    this.transactions = new ArrayList<Transaction>();  // 계좌 생성시 거래내역 Arraylist 생성

    // Bank클래스에서 addAccount메서드로 계좌를 생성할 때 인자를 주어서 name과 accountNo를 삽입하도록
    // 과제가 설정되어 있으므로 accountNo와 name은 기본값을 주지 않았습니다.
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
    System.out.println("현재 잔액은" + balance + "원 입니다.");
    return balance;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }

  public List<Transaction> getTransactions() {
    System.out.println("= 거래내역 =");

    // 거래내역 출력
    for (Transaction transaction : transactions) {
      System.out.printf("[거래금액:%d원, 잔액:%d원 /%s%s]", transaction.amount, transaction.balance,
          transaction.transactionDate, transaction.transactionTime);

      // 날짜 : yyyy년mm월dd일 형태로 리턴하도록 구현해주세요
      // 시간 : hh시mm분 형태로 리턴하도록 구현해주세요

      /*
      notice: 거래내역 출력 예시
      = 거래 내역 =
      [거래금액:200000, 잔액:200000원 /2020년08월26일11시53분]
      [거래금액:200000, 잔액:400000원 /2020년08월26일11시53분]
      [거래금액:5500, 잔액:394500원 /2020년08월26일11시53분]
       */
      System.out.println();
    }
    return transactions;
  }

  public void deposit(long amount) {
    // 잔고 입금
    this.balance += amount;

    // 거래내역 객체 생성 및 필드값 설정
    Transaction transaction = new Transaction();

    transaction.transactionDate = "오늘";  // 날짜처리 클래스 구현 후 "오늘" 자리에 오늘 날짜 인스턴스 삽입 필요
    transaction.transactionTime = "지금";  // 날짜처리 클래스 구현 후 "지금" 자리에 지금 시간 인스턴스 삽입 필요
    transaction.kind = "입금";
    transaction.amount = amount;
    transaction.balance = this.balance;

    // 거래내역 리스트에 추가
    transactions.add(transaction);

    // 입금내역 출력
    System.out.println(amount + "원 입금하셨습니다.");
  }

  public void withdraw(long amount) {
    // 잔고 출금
    this.balance -= amount;

    // 거래내역 객체 생성 및 필드값 설정
    Transaction transaction = new Transaction();

    transaction.transactionDate = "오늘";  // 날짜처리 클래스 구현 후 "오늘" 자리에 오늘 날짜 인스턴스 삽입 필요
    transaction.transactionTime = "지금";  // 날짜처리 클래스 구현 후 "지금" 자리에 지금 시간 인스턴스 삽입 필요
    transaction.kind = "출금";
    transaction.amount = amount;
    transaction.balance = this.balance;

    // 거래내역 리스트에 추가
    transactions.add(transaction);

    // 입금내역 출력
    System.out.println(amount + "원 출금하셨습니다.");
  }
}
