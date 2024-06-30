import domain.Account;
import domain.Bank;

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
          System.out.println("== 전체 계좌 목록 ==");
          for (Account account: bank.getAccounts()){
            System.out.printf("[계좌번호: "+ account.getAccountNo()+", 소유자 명: "+account.getName()+", 잔액"+account.getBalance()+"]\n");
          }
          break;

        case 2:
          System.out.println("= 해당 계좌번호의 계좌정보 =");
          Account accountFindByAccountNo = bank.getAccount(br.readLine());
          System.out.println("[계좌번호 :"+ accountFindByAccountNo.getAccountNo()+", 소유자 명 : "+ accountFindByAccountNo.getName()+", 잔액 : "+ accountFindByAccountNo.getBalance()+"]");
          break;

        case 3:
          System.out.println("= 해당 소유자명의 계좌 목록 =");
          List<Account> accounts = bank.findAccounts(br.readLine());
          for (Account accountFindByName:accounts){
            System.out.println("[계좌번호 :"+accountFindByName.getAccountNo()+", 소유자 명 : "+ accountFindByName.getName()+", 잔액 : "+ accountFindByName.getBalance()+"]");
          }
          break;
        case 4:
        case 5:
        case 6:
        case 7:
        default:





      }
    }

  }
}