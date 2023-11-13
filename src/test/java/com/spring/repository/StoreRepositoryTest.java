package com.spring.repository;

import com.spring.entity.Store;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
@Transactional
class StoreRepositoryTest {

    @Autowired
    private StoreRepository storeRepository;
    @Test
    void 매장_생성_성공() {
        Store store = new Store(1,"음식점","이름","햄버거","3000원","010-2222-2222","서림길123","123.1212312313","234.213123123");
        int result = storeRepository.insert(store);
        Assertions.assertThat(result).isEqualTo(1);
    }
}