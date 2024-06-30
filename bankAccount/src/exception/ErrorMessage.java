package exception;

public enum ErrorMessage {
    NOT_ENOUGH_BALANCE("잔액이 부족합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
