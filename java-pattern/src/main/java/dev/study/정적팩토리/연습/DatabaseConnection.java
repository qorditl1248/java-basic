package dev.study.정적팩토리.연습;

import java.util.HashMap;
import java.util.Map;

/**
 * 	데이터베이스 연결 객체를 생성하는 DatabaseConnection 클래스를 구현하세요.
 * 	•	이 클래스는 항상 동일한 인스턴스를 반환해야 합니다.
 * 	•	생성자는 private으로 설정하고, 정적 팩토리 메서드 getInstance()를 통해 객체를 반환하세요.
 */


public class DatabaseConnection {
    private static final Map<String, DatabaseConnection> cache = new HashMap<>();
    private final String dataName;

    private DatabaseConnection(String dataName) {
        this.dataName = dataName;
    }

    public static DatabaseConnection getInstance(String dataName) {
        return cache.computeIfAbsent(dataName, DatabaseConnection::new);
    }

    @Override
    public String toString() {
        return "DatabaseConnection{" +
                "dataName='" + dataName + '\'' +
                '}';
    }
}
