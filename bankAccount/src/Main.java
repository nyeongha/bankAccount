import domain.Account;
import domain.Bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  private static final int EXIT = 8;
  public static void main(String[] args) throws IOException {
    Bank bank = new Bank();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    sb.append("1. 전체 계좌 출력\n")
            .append("2. 계좌로 계좌 정보 찾기\n")
            .append("3. 소유주 명으로 계좌 찾기\n")
            .append("4. 입금\n")
            .append("5. 출금\n")
            .append("6. 거래내역 보기\n")
            .append("7. 계좌 개설\n")
            .append("8. 종료");

    System.out.println(sb);

    int menu = Integer.parseInt(br.readLine());
    while (menu != EXIT){
      switch (menu){
        case 1:

        case 2:
          break;
        case 3:

        case 4:
          System.out.println("입금할 계좌를 입력해주세요: ");
          String depositAccount = br.readLine();
          Account findDepositAccount = bank.getAccount(depositAccount);
          System.out.println("입금할 금액을 입력해주세요: ");
          long depositAmount = Long.parseLong(br.readLine());
          findDepositAccount.deposit(depositAmount);
          System.out.println(depositAccount + "원 입금하셨습니다.");
          System.out.println("현재 잔액은: " + findDepositAccount.getBalance() + "입니다.");
          break;
        case 5:
          try{
            System.out.println("출금할 계좌를 입력해주세요: ");
            String account = br.readLine();
            Account findWithdrawAccount = bank.getAccount(account);
            System.out.println("출금할 금액을 입력해주세요: ");
            long withDrawAmount = Long.parseLong(br.readLine());
            findWithdrawAccount.withdraw(withDrawAmount);
            System.out.println(withDrawAmount + "원 출금하셨습니다.");
            System.out.println("현재 잔액은: " + findWithdrawAccount.getBalance() + "입니다.");
            break;
          }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
          }
        case 6:
          break;
        case 7:
        default:
      }
    }

  }
}