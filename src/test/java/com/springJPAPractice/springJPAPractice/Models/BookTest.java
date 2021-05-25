package com.springJPAPractice.springJPAPractice.Models;

import com.springJPAPractice.springJPAPractice.DAO.BookDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

// 모든 클래스패스에 대해 테스트를 수행하는게 아니라 데이터에 관련된 내용만 스캔하여 수행
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookTest extends ResetDatabase {
    @Autowired
    private BookDAO bookDAO;

    @Test
    public void createSuccess() {
        // 1. TEST DB 를 바라봐야 한다. > build.gralde 에서 설정 완료
        // 2. 테스트를 수행할 때마다 DB가 초기화되어야 한다. (데이터의 상태에 따라 결과가 달라지는 것을 방지) : extends ResetDatabase
        // 3. Book 개체가 DB 에 생성되는지 테스트

        // 테스트 수행 단계
        // Given (사전 준비) : Book 생성을 위한 사전 준비
        Book book = new Book();
        book.setId((long) 1);
        book.setName("Flyway 정복");
        book.setAuthor("LHWN");

        // When (테스트 수행 시점) : Book 생성
        bookDAO.save(book);

        // Then (이후 테스트 검증 결과) : 제대로 생성되었는지 검증
        Optional<Book> bookFromDB = bookDAO.findById((long) 1);

        assertThat(bookFromDB.get().getId()).isEqualTo(book.getId());
        assertThat(bookFromDB.get().getName()).isEqualTo(book.getName());
        assertThat(bookFromDB.get().getAuthor()).isEqualTo(book.getAuthor());

        System.out.println("here"+bookFromDB.get().getName());
    }
}
