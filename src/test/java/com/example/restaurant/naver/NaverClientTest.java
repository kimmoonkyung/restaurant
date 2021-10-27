package com.example.restaurant.naver;

import com.example.restaurant.naver.dto.SearchImageReq;
import com.example.restaurant.naver.dto.SearchLocalReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NaverClientTest {

    @Autowired
    private NaverClient naverClient;

    @Test
    public void searchLocalTest() {

        var search = new SearchLocalReq();
        search.setQuery("산본 상무초밥");

        var result = naverClient.localSearch(search);
        System.out.println(result);
        Assertions.assertNotNull(result.getItems().stream().findFirst().get().getCategory());

    }

    @Test
    public void searchImageTest() {
        var search = new SearchImageReq();
        search.setQuery("산본 상무초밥");

        var result = naverClient.imageSearch(search);
        System.out.println(result);
    }
}
