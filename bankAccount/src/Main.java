import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import service.BankService;

public class Main {
    private static final int EXIT = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BankService bankService = new BankService();
        bankService.explainMenu();

        int menu = 0;
        while (menu != EXIT) {
            try {
                System.out.print("원하시는 업무를 선택해주세요: ");
                menu = Integer.parseInt(br.readLine());
                String output = switch (menu) {
                    case 1 -> bankService.accountList();
                    case 2 -> bankService.accountInfoByAccountNo();
                    case 3 -> bankService.accountListByName();
                    case 4 -> bankService.runDeposit();
                    case 5 -> bankService.runWithdraw();
                    case 6 -> bankService.browseTransactions();
                    case 7 -> bankService.createAccount();
                    case 8 -> "이용해 주셔서 감사합니다";
                    default -> "잘못 입력했습니다";
                };

                System.out.println(output);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}