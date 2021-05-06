package poly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.MelonDTO;
import poly.service.IMelonServiceUsingDTO;

/*
 * Controller 선언해야만 Spring 프레임워크에서 Controller인지 인식가능
 * 자바 서블릿ㄴ 역할 수정
 */
@Controller
public class MelonController2 {

	/*
	 * 비즈니스 로직 ( 중용 로직을 수행하기 위해 사용되는 서비스를 메모리에 적재( 싱글톤 패턴 적용됨 )
	 */
	private Logger log = Logger.getLogger(this.getClass());



	@Resource(name = "MelonServiceUsingDTO")
	private IMelonServiceUsingDTO melonServiceUsingDTO;

	@RequestMapping(value = "/melon/collectMelonSongUsingDTO")
	@ResponseBody
	public String collectMelonRankUsingDTO(HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.info(this.getClass().getName() + ".getSongListUsingDTO start");

		melonServiceUsingDTO.collectMelonSong();

		log.info(this.getClass().getName() + ".getSongListUsingDTO end");

		return "success";

	}

	/**
	 * 오늘 수집된 멜론 노래리스트 가져오기
	 */
	@RequestMapping(value = "/melon/getSongListUsingDTO")
	@ResponseBody
	public List<MelonDTO> getSongListUsingDTO(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.info(this.getClass().getName() + ".getSongListUsingDTO start");

		List<MelonDTO> rList = melonServiceUsingDTO.getSongList();

		log.info(this.getClass().getName() + ".getSongListUsingDTO end");

		return rList;

	}
	
	
	/**
	 * 가수별 수집된 노래의 수 가져오기
	 */
	@RequestMapping(value = "/melon/getSingerSongCntUsingDTO")
	@ResponseBody
	public List<MelonDTO> getSingerSongCntUsingDTO(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		log.info(this.getClass().getName() + ".getSingerSongCntUsingDTO start");

		List<MelonDTO> rList = melonServiceUsingDTO.getSingerSongCnt();

		log.info(this.getClass().getName() + ".getSingerSongCntUsingDTO end");

		return rList;

	}
	
	
}