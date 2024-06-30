import domain.Account;
import domain.Bank;

import domain.Transaction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    Bank bank = new Bank();
    StringBuilder sb = new StringBuilder();
    sb.append("1. 전체 계좌 출력\n")
            .append("2. 계좌로 계좌 정보 찾기\n")
            .append("3. 소유주명으로 계좌 찾기\n")
            .append("4. 입금\n")
            .append("5. 출금\n")
            .append("6. 거래내역 보기\n")
            .append("7. 계좌 개설\n")
            .append("8. 종료");

    System.out.println(sb);

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int menu = Integer.parseInt(br.readLine());

    while (menu != 8){
      switch (menu){
        case 1:

        case 2:
          break;
        case 3:
        case 4:
        case 5:
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




          break;
        case 7:
          System.out.println("개설할 계좌번호를 입력해주세요");
          String newAccountNo = br.readLine();


          System.out.println("이름을 입력해주세요");
          String name = br.readLine();

          bank.addAccount(newAccountNo, name);
          break;
        default:





      }
    }

  }
}