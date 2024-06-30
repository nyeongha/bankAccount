import domain.Account;
import domain.Bank;

import domain.Transaction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static Bank bank = new Bank();
  private static final int EXIT = 8;
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder mainSb = new StringBuilder();
    mainSb.append("1. 전체 계좌 출력\n")
            .append("2. 계좌로 계좌 정보 찾기\n")
            .append("3. 소유주 명으로 계좌 찾기\n")
            .append("4. 입금\n")
            .append("5. 출금\n")
            .append("6. 거래내역 보기\n")
            .append("7. 계좌 개설\n")
            .append("8. 종료");

    System.out.println(mainSb);

    int menu = 0;
    while (menu != EXIT){
      menu = Integer.parseInt(br.readLine());

      StringBuilder sb=new StringBuilder();


      String output = switch (menu) {
        case 1  -> accountList(sb);
        case 2  -> accountInfoByAccountNo(sb);

        case 3  -> accountListByName(sb);
        case 4 -> runDeposit(sb);
        case 5 -> runWithdraw(sb);
        case 6:
          System.out.println("계좌번호를 입력해주세요");
          String excistingAccountNo = br.readLine();

          System.out.println("= 거래내역 =");
          List<Transaction> transactions = bank.getAccount(excistingAccountNo).getTransactions();

          if (transactions.isEmpty()){
            System.out.println("거래내역이 비었습니다.");
          } else{
            for (Transaction transaction : transactions) {
              System.out.println(transaction.toString());
            }
          }
        case 7:
          System.out.println("개설할 계좌번호를 입력해주세요");
          String newAccountNo = br.readLine();


          System.out.println("이름을 입력해주세요");
          String name = br.readLine();

          bank.addAccount(newAccountNo, name);
      };

      System.out.println(output);
    }
  }

    private static String accountListByName(StringBuilder sb) throws IOException {
        System.out.println("= 해당 소유자명의 계좌 목록 =");
        List<Account> accounts = bank.findAccounts(br.readLine());
        for (Account accountFindByName:accounts){
          sb.append(accountFindByName.toString()).append("\n");
        }
        return sb.toString();
    }


    private static String accountInfoByAccountNo(StringBuilder sb) throws IOException {
    System.out.println("= 해당 계좌번호의 계좌정보 =");
    Account accountFindByAccountNo = bank.getAccount(br.readLine());
    sb.append(accountFindByAccountNo.toString());
    return sb.toString();
  }

  private static String accountList(StringBuilder sb) {
    System.out.println("== 전체 계좌 목록 ==");
    for (Account account: bank.getAccounts()){
      sb.append(account.toString());
    }
    return sb.toString();
  }

  private static String runWithdraw(StringBuilder sb) throws IOException {
    try{
      System.out.println("출금할 계좌를 입력해주세요: ");
      String account = br.readLine();
      Account findWithdrawAccount = bank.getAccount(account);
      System.out.println("출금할 금액을 입력해주세요: ");
      long withDrawAmount = Long.parseLong(br.readLine());
      findWithdrawAccount.withdraw(withDrawAmount);
      sb.append(withDrawAmount + "원 인출하셨습니다.").append("\n")
              .append("현재 잔액은: " + findWithdrawAccount.getBalance() + "원 입니다.");
      return sb.toString();
    }catch (IllegalArgumentException e){
      return e.getMessage();
    }
  }

  private static String runDeposit(StringBuilder sb) throws IOException {
    System.out.println("입금할 계좌를 입력해주세요: ");
    String depositAccount = br.readLine();
    Account findDepositAccount = bank.getAccount(depositAccount);
    System.out.println("입금할 금액을 입력해주세요: ");
    long depositAmount = Long.parseLong(br.readLine());
    findDepositAccount.deposit(depositAmount);

    sb.append(depositAccount + "원 입금하셨습니다.").append("\n")
            .append("현재 잔액은: " + findDepositAccount.getBalance() + "원 입니다.");

    return sb.toString();
  }
}