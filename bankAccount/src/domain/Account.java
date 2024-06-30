package domain;

import static exception.ErrorMessage.AMOUNT_UNDER_ZERO;
import static exception.ErrorMessage.NOT_ENOUGH_BALANCE;

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
        if (amount <= 0) {
            throw new IllegalArgumentException(AMOUNT_UNDER_ZERO.getMessage());
        }
        // 잔고 입금
        balance += amount;

        // 거래내역 객체 생성 및 필드값 설정
        Transaction transaction = new Transaction("입금", amount, balance);

        // 거래내역 리스트에 추가
        transactions.add(transaction);
    }

    public void withdraw(long amount) {
        // 잔고 출금
        if (balance < amount) {
            throw new IllegalArgumentException(NOT_ENOUGH_BALANCE.getMessage());
        }
        balance -= amount;
        //예외처리 필요할듯

        // 거래내역 객체 생성 및 필드값 설정
        Transaction transaction = new Transaction("출금", amount, balance);

        // 거래내역 리스트에 추가
        transactions.add(transaction);
    }

    @Override
    public String toString() {
        return "[계좌번호: " + accountNo +
                ", 소유자 명: " + name +
                ", 잔액: " + balance + "]";
    }
}
