package poly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.dto.MelonDTO;
import poly.dto.MelonRankDTO;
import poly.dto.MelonSingerDTO;
import poly.dto.MelonSongDTO;
import poly.service.IMelonService;

/*
 * Controller 선언해야만 Spring 프레임워크에서 Controller인지 인식가능
 * 자바 서블릿ㄴ 역할 수정
 */
@Controller
public class MelonController {

   /*
    * 비즈니스 로직 ( 중용 로직을 수행하기 위해 사용되는 서비스를 메모리에 적재( 싱글톤 패턴 적용됨 )
    */
   private Logger log = Logger.getLogger(this.getClass());
   
   @Resource(name = "MelonService")
   private IMelonService melonService;
   
   /**
    * 컬렉션 생성 TEST
    */
   @RequestMapping(value = "melon/collectMelonRank")
   @ResponseBody
   public String test(HttpServletRequest request, HttpServletResponse response) throws Exception{
      log.info(this.getClass().getName() + ".collectMelonRank Start!");
      
      melonService.collectMelonRank();
      
      log.info(this.getClass().getName() + ".collectMelonRank end!");
      return "success";
   }
   
   @RequestMapping(value = "melon/melonTop100")
   public String melonTop100(HttpServletResponse resonse, HttpServletResponse request) throws Exception{
	   log.info(this.getClass().getName() + ".melon Start");
	   log.info(this.getClass().getName() + ".melonT end");
	   
	   return "/melon/melonTop100";
   }
   
   @RequestMapping(value="melon/getRank")
   @ResponseBody
   public List<MelonDTO> getRank(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   
	   log.info(this.getClass().getName() + ".getRank Start");
	   
	   List<MelonDTO> rList = melonService.getRank();
	   log.info("rList ==null?" + rList == null );
	   if (rList == null ) {
		   rList = new ArrayList<MelonDTO>();
	   }
	   
	   log.info(this.getClass().getName() + ".getRank End");
	   
	   return rList;
   }
   
   /**
    * 가수의 노래 데이터 가져오는 일반 화면
    */
   @RequestMapping(value="melon/melonSongForSinger")
   public String melonSongForSinger(HttpServletResponse response, HttpServletRequest request)throws Exception{
	   log.info("melonSongForSinger Start");
	   
	   
	   log.info("melonSongForSinger End");
	   
	   return "/melon/melonSongForSinger";
   }
   
   /**
    * 가수의 노래 데이터 가져오기
    */
   @RequestMapping(value="melon/getSongForSinger")
   @ResponseBody
   public List<MelonSongDTO> getSongForSinger(HttpServletResponse response, HttpServletRequest request)throws Exception{
	   log.info("getSongForSinger Start");
	   
	   List<MelonSongDTO> rList = melonService.getSongForSinger();
	   
	   if(rList == null) {
		   rList = new ArrayList<MelonSongDTO>();
		   
	   }
	   
	   log.info("getSongForSinger End");
	   
	   return rList;
   }
   
   /**
    * 가수별 멜론 랭킹에 많이 등록된 순서대로 가져오는 일반화면
    */
   @RequestMapping(value = "melon/melonSingerRank")
   public String melonSingerRank(HttpServletRequest request, HttpServletResponse response)
   			throws Exception{
	   
	   log.info("melonSingerRank Sart!! ");
	   
	   log.info("melonSingerRank End!! ");
	   
	   return "/melon/melonSingerRank";
   }
   
   /**
    * 가수별 멜론 랭킹에 많이 등록된 순서대로 가져오기
    */
   @RequestMapping(value = "melon/getRankForSinger")
   @ResponseBody
   public List<MelonSingerDTO> getRankForSinger(HttpServletRequest request, HttpServletResponse response)
   			throws Exception{
	   log.info("getRankForSinger Start !!");
	   
	   List<MelonSingerDTO> rList = melonService.getRankForSinger();
	   
	   if(rList == null) {
		   rList = new ArrayList<MelonSingerDTO>();
	   }
	   
	   
	   log.info("getRankForSinger End !!");
	   
	   return rList;
   }
   
   /**
    * 가수별 멜론 랭킹에 많이 등록된 순서대로 가져오는 일반화면
    */
   @RequestMapping(value = "melon/melonCompareRank")
   public String melonCompareRank(HttpServletRequest request, HttpServletResponse response)
   			throws Exception{
	   
	   log.info("melonCompareRank Sart!! ");
	   
	   log.info("melonCompareRank End!! ");
	   
	   return "/melon/melonCompareRank";
   }
   
   
   /**
    * 노래별 순위 변동 정보
    */
   @RequestMapping(value = "melon/getCompareRank")
   @ResponseBody
   public List<MelonRankDTO> getCompareRank(HttpServletRequest request, HttpServletResponse response)
   			throws Exception{
	   
	   log.info(this.getClass().getName() + ".getcompareRank Start!!");
	   
	   List<MelonRankDTO> rList = melonService.getCompareRank();
	   
	   if (rList == null) {
		   rList = new ArrayList<MelonRankDTO>();
	   }
	   log.info(this.getClass().getName() + ".getcompareRank End!!");
	   
	   return rList;
   }
   
   
}