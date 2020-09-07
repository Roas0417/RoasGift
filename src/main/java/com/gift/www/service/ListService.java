package com.gift.www.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gift.www.common.FileUtils;
import com.gift.www.dto.ImgReqResDto;
import com.gift.www.dto.ListResponseDto;
import com.gift.www.dto.ListSaveRequestDto;
import com.gift.www.dto.ListUpdateRequestDto;
import com.gift.www.entity.ImgEntity;
import com.gift.www.entity.ListEntity;
import com.gift.www.repository.ImgRepository;
import com.gift.www.repository.ListRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ListService {
	
	private final ListRepository listRepository;
	private final ImgRepository imgRepository;
	private final FileUtils fileUtils;
	
	@Transactional
	public void save(ListSaveRequestDto requestDto, MultipartHttpServletRequest multipartHttpServletRequest) 
	throws Exception {
		
		
		Long giftId = listRepository.save(requestDto.toEntity()).getGiftId();
		ImgReqResDto dto = fileUtils.parseFileImg(giftId, multipartHttpServletRequest);
		if(ObjectUtils.isEmpty(dto) == false) {
			imgRepository.save(dto.toImgEntity());
		}
		
		//dto를 list로  받아오기
			
	}
	//등록
	
	@Transactional
	public Long update(Long giftId, ListUpdateRequestDto requestDto) {
		ListEntity listEntity = listRepository.findById(giftId)
				.orElseThrow(() -> new 
						IllegalArgumentException("해당 게시글이 없습니다. id = " + giftId));
		
		listEntity.update(requestDto.getGiftName(), requestDto.getGiftBrand(), 
				requestDto.getGiftCategory(), requestDto.getGiftPrice(), 
				requestDto.getGiftSold(), requestDto.getGiftContent());
		
		return giftId;
	}
	//수정
	
	@Transactional
	public ListResponseDto findById(Long id) {
		ListEntity listEntity = listRepository.findById(id)
				.orElseThrow(() -> new 
						IllegalArgumentException("해당 게시글이 없습니다 id = " + id));
		
		return new ListResponseDto(listEntity);
	}
	//조회
	
	@Transactional
	public ImgReqResDto findByGiftId(Long giftId) {
		ImgReqResDto imgDto = imgRepository.findByGiftId(giftId);
		
		return imgDto;
	}
	
	@Transactional(readOnly = true)
	public List<ListResponseDto> findAllDesc(int startIndex, int pageSize){
		Pageable pageable = PageRequest.of(startIndex, pageSize);

		return listRepository.findAllDesc(pageable).stream()
				.map(ListResponseDto::new)
				.collect(Collectors.toList());
	}
	//목록
	
	@Transactional
	public int findAllCnt() {
		return listRepository.findAllCnt();
	}
	
	@Transactional
	public void delete(Long giftId) {
		ListEntity listEntity = listRepository.findById(giftId)
				.orElseThrow(() -> new 
						IllegalArgumentException("해당 게시글이 없습니다. id = " + giftId));
		
		listRepository.delete(listEntity);
	}
	//삭제
	
	@Transactional(readOnly = true)
	public List<ListResponseDto> findAllSearch(String keyword, String category, int startIndex, int pageSize) {
		
		Pageable pageable = PageRequest.of(startIndex, pageSize);
		
		return listRepository.findAllSearch(keyword, category, pageable).stream()
				.map(ListResponseDto::new)
				.collect(Collectors.toList());
	}
}
