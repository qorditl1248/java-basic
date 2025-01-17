package dev.study.immutable;

/*
    은행 계좌 클래스 구현 (계좌번호, 잔액)
    필드: String accountNumber, double balance

    잔액 변경할 때 기존 객체 값 바꾸지 말고 새로운 객체를 반환
    새로운 잔액을 설정하는 메서드이름: withUpdatedBalance(double newBalance)

 */
public final class ImmutableExample {
    private final String accountNumber;
    private final double balance;

    public ImmutableExample(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public ImmutableExample withUpdatedBalance(double newBalance) {
        return new ImmutableExample(accountNumber, newBalance);
    }

    @Override
    public String toString() {
        return "ImmutableExample{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
