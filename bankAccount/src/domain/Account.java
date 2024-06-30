package domain;

import static exception.ErrorMessage.AMOUNT_UNDER_ZERO;
import static exception.ErrorMessage.NOT_ENOUGH_BALANCE;

import java.util.ArrayList;
import java.util.List;

public class Account {
  private static final int MIN_AMOUNT = 0;
  private static final String DEPOSIT = "입금";
  private static final String WITHDRAW = "출금";
    private String accountNo;
    private String name;
    private long balance;
    private List<Transaction> transactions;

    public Account(String accountNo, String name) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = 0L;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNo() {
        return accountNo;
    }

    public String getName() {
        return name;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(long amount) {
        if (amount <= MIN_AMOUNT) {
            throw new IllegalArgumentException(AMOUNT_UNDER_ZERO.getMessage());
        }

        balance += amount;  // 잔고 입금
        Transaction transaction = new Transaction(DEPOSIT, amount, balance);  // 거래내역 객체 생성 및 필드값 설정
        transactions.add(transaction);// 거래내역 리스트에 추가
    }

    public void withdraw(long amount) {
        if (balance < amount) {
            throw new IllegalArgumentException(NOT_ENOUGH_BALANCE.getMessage());
        }
        balance -= amount;
        Transaction transaction = new Transaction(WITHDRAW, amount, balance); // 거래내역 객체 생성 및 필드값 설정
        transactions.add(transaction);  // 거래내역 리스트에 추가
    }

    @Override
    public String toString() {
        return "[계좌번호: " + accountNo +
                ", 소유자 명: " + name +
                ", 잔액: " + balance + "]";
    }
}
