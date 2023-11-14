package com.spring.repository;

import com.spring.entity.Store;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/applicationContext.xml"})
@Transactional
class StoreRepositoryTest {

    @Autowired
    private StoreRepository storeRepository;
    @Test
    void 매장_생성_성공() {
        List<Store> storeList = new ArrayList<>();
        Store store1 = new Store(1,"음식점1","이름","햄버거","3000원","010-2222-2222","서림길123","123.1212312313","234.213123123");
        storeList.add(store1);
        Store store2 = new Store(2,"음식점2","이름","햄버거","3000원","010-2222-2222","서림길123","123.1212312313","234.213123123");
        storeList.add(store2);
        Store store3 = new Store(3,"음식점3","이름","햄버거","3000원","010-2222-2222","서림길123","123.1212312313","234.213123123");
        storeList.add(store3);

        int result = storeRepository.insertList(storeList);
        Assertions.assertThat(result).isEqualTo(3);
    }
}