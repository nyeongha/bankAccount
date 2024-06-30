package exception;

public enum ErrorMessage {
    NOT_ENOUGH_BALANCE("잔액이 부족합니다."),
    ALREADY_EXIST("이미 존재하는 계좌입니다."),
    NO_SUCH_ACCOUNT("존재하지 않는 계좌입니다."),
    NO_ACCOUNT("계좌가 존재하지 않습니다."),
    AMOUNT_UNDER_ZERO("0원 이하는 입금 불가능합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
