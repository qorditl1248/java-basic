package dev.study.정적팩토리.caching;

import java.util.HashMap;
import java.util.Map;

/**
 *  객체 캐싱 구현
 *  - 동일한 입력값으로 동일한 객체를 반환하여 메모리 사용을 최적화 한다.
 *  - 이미 생성된 객체는 저장소(Map)에서 가져오고, 새로 생성해야 할 경우에 저장소에 추가
 *
 *  캐싱이라는 것이 의미하는게 값이있으면 그값을 가져오고
 *  없으면 생성하거나 데이터베이스등에서 가져와서 준다 라는 것으로 이해하면 됨
 */

public class ConnectionPool {
    // connectionName(키)을 기준으로 ConnectionPool 객체(값)를 저장
    // Map<key, value> - 키의 타입, 각 키에 대응하는 값 ConnectionPool
    private static final Map<String, ConnectionPool> cache = new HashMap<>();
    private final String connectionName;

    private ConnectionPool(String connectionName) {
        this.connectionName = connectionName;
    }

    // 정적 팩토리 메서드
    public static ConnectionPool getInstance(String connectionName) {
        return cache.computeIfAbsent(connectionName, ConnectionPool::new);
    }
    /*
        computeIfAbsent() 맵에서 특정 키의 값을 확인하고
        키가 있으면 ->  기존 값을 반환
        키가 없으면 ->  지정된 함수를 사용해 값을 계산하고 맵에 추가한 뒤 반환.
     */

    @Override
    public String toString() {
        return "ConnectionPool{" +
                "connectionName='" + connectionName + '\'' +
                '}';
    }

}
