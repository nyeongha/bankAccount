package domain;

public class Transaction {
    private String transactionDate;
    private String transactionTime;
    private String kind;
    private long amount;
    private long balance;

    public Transaction(String kind, long amount, long balance) {
        Date date = new Date();
        this.transactionDate = date.getDate();
        this.transactionTime = date.getTime();
        this.kind = kind;
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "[거래금액: " + amount + ", 잔액: " + balance + "원 /"
                + transactionDate  + transactionTime + "]";
    }
}
