package org.fp024.study.algorithm.part05.chapter18;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

/**
 * static 메서드를 Mock 처리 없이 실행
 * static 메서드의 로직대로 수행된다.
 */
class RepositoryTest {
    @Test
    void testRepository() {
        assertEquals("MySQLDBResource", new Repository().getDBResourceName());
    }
}


/**
 * static 메서드를 Mock 처리 해서 실행
 * <p>
 * (참고) mockito-inline 라이브러리가 포함되야한다.
 * mockito-junit-jupiter 는 반드시 필수 좋건은 아닌 것 같은데.. 같이 넣음.
 *
 * @BeforeAll, @AfterAll 에서 정적 멤버로 Mock 대상을 정의하면 전역적이라..
 * try-resource 문에서 정의해도 괜찮아보임.
 * MockedStatic 은 AutoCloseable 을 구현함.
 */
class RepositoryMockTest {
    @Test
    void testRepository() {
        // 정적 메서드를 가진 DBResource 메서드를 Mocking
        try (MockedStatic<DBResource> mockDBResource = mockStatic(DBResource.class)) {
            // static 메서드가 반환하는 값을 다른 값으로 변경 조작
            mockDBResource.when(() -> DBResource.getMySQLDBResource()).thenReturn(new MySQLDBResource("NewMySQL8DBResource"));

            assertEquals("NewMySQL8DBResource", new Repository().getDBResourceName());

            // 호출 실행 후, 검증
            mockDBResource.verify(
                    DBResource::getMySQLDBResource,
                    times(1)
            );
        }
    }
}


class Repository {
    String getDBResourceName() {
        return DBResource.getMySQLDBResource().getName();
    }
}

class DBResource {
    static MySQLDBResource getMySQLDBResource() {
        return new MySQLDBResource("MySQLDBResource");
    }
}

@RequiredArgsConstructor
@Getter
class MySQLDBResource {
    private final String name;
}
