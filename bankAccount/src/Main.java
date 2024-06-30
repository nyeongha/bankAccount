import static exception.ErrorMessage.ALREADY_EXIST;

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
        while (menu != EXIT) {
            try {
                System.out.print("원하시는 업무를 선택해주세요: ");
                menu = Integer.parseInt(br.readLine());
                StringBuilder sb = new StringBuilder();
                String output = switch (menu) {
                    case 1 -> accountList(sb);
                    case 2 -> accountInfoByAccountNo();
                    case 3 -> accountListByName(sb);
                    case 4 -> runDeposit(sb);
                    case 5 -> runWithdraw(sb);
                    case 6 -> browseTransactions(sb);
                    case 7 -> createAccount();
                    case 8 -> "이용해 주셔서 감사합니다";
                    default -> "잘못 입력했습니다";
                };

                System.out.println(output);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String accountListByName(StringBuilder sb) throws IOException {
        System.out.print("찾으실 계좌의 소유자명을 입력하세요: ");
        List<Account> accounts = bank.findAccounts(br.readLine());

        sb.append("= 해당 소유자명의 계좌 목록 =\n");
        for (Account accountFindByName : accounts) {
            sb.append(accountFindByName.toString()).append("\n");
        }
        return sb.toString();
    }

    private static String accountInfoByAccountNo() throws IOException {
        System.out.print("찾으실 계좌번호를 입력하세요: ");
        Account accountFindByAccountNo = bank.getAccount(br.readLine());
        System.out.println("= 해당 계좌번호의 계좌정보 =");
        return accountFindByAccountNo.toString();
    }

    private static String accountList(StringBuilder sb) {
        sb.append("== 전체 계좌 목록 ==").append("\n");
        for (Account account : bank.getAccounts()) {
            sb.append(account.toString()).append("\n");
        }
        return sb.toString();
    }

    private static String runWithdraw(StringBuilder sb) throws IOException {
        System.out.print("출금할 계좌를 입력해주세요: ");
        Account findWithdrawAccount = bank.getAccount(br.readLine());
        System.out.print("출금할 금액을 입력해주세요: ");
        long withDrawAmount = Long.parseLong(br.readLine());
        findWithdrawAccount.withdraw(withDrawAmount);
        sb.append(withDrawAmount + "원 인출하셨습니다.").append("\n")
                .append("현재 잔액은 " + findWithdrawAccount.getBalance() + "원 입니다.");
        return sb.toString();
    }

    private static String runDeposit(StringBuilder sb) throws IOException {
        System.out.print("입금할 계좌를 입력해주세요: ");
        Account findDepositAccount = bank.getAccount(br.readLine());
        System.out.print("입금할 금액을 입력해주세요: ");
        long depositAmount = Long.parseLong(br.readLine());
        findDepositAccount.deposit(depositAmount);

        sb.append(depositAmount + "원 입금하셨습니다.").append("\n")
                .append("현재 잔액은 " + findDepositAccount.getBalance() + "원 입니다.");
        return sb.toString();
    }

    private static String createAccount() throws IOException {
        System.out.print("개설할 계좌번호를 입력해주세요: ");
        String newAccountNo = br.readLine();

        if (bank.accountExists(newAccountNo)) {
            throw new IllegalArgumentException(ALREADY_EXIST.getMessage());
        }

        System.out.print("이름을 입력해주세요: ");
        String name = br.readLine();
        bank.addAccount(newAccountNo, name);
        return "계좌를 개설했습니다.";
    }

    private static String browseTransactions(StringBuilder sb) throws IOException {
        System.out.print("계좌번호를 입력해주세요: ");
        List<Transaction> transactions = bank.getAccount(br.readLine()).getTransactions();

        if (transactions.isEmpty()) {
            sb.append("거래내역이 비었습니다.");
        } else {
            sb.append("= 거래내역 =");
            for (Transaction transaction : transactions) {
                sb.append(transaction.toString());
            }
        }
        return sb.toString();
    }
}