package com.gift.www.controller;

/*import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.gift.www.dto.ListSaveRequestDto;
import com.gift.www.entity.ListEntity;
import com.gift.www.repository.ListRepository;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ListApiControllerTest {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private ListRepository listRepository;
	
	@After
	public void tearDown() throws Exception {
		listRepository.deleteAll();
	}
	
	@Test
	public void List_save() throws Exception {
		//given
		String giftName = "name";
		String giftBrand = "brand";
		String giftCategory = "category";
		String giftPrice = "price";
		String giftContent = "content";
		
		ListSaveRequestDto requestDto = ListSaveRequestDto.builder()
				.giftName(giftName)
				.giftBrand(giftBrand)
				.giftCategory(giftCategory)
				.giftPrice(giftPrice)
				.giftContent(giftContent)
				.build();
		
		String url = "http://localhost:" + port + "/create/v1/gift";
		
		//when
		ResponseEntity<Long> responseEntity = restTemplate.postForEntity
				(url, requestDto, Long.class);
		
		//then
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isGreaterThan(0L);
		
		List<ListEntity> all = listRepository.findAll();
		assertThat(all.get(0).getGiftName()).isEqualTo(giftName);
		assertThat(all.get(0).getGiftBrand()).isEqualTo(giftBrand);
		assertThat(all.get(0).getGiftCategory()).isEqualTo(giftCategory);
		assertThat(all.get(0).getGiftPrice()).isEqualTo(giftPrice);
		assertThat(all.get(0).getGiftContent()).isEqualTo(giftContent);
		
	}
}*/
