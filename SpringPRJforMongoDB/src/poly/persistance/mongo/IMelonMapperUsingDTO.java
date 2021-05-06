package poly.persistance.mongo;

import java.util.List;

import poly.dto.MelonDTO;
import poly.dto.MelonRankDTO;
import poly.dto.MelonSingerDTO;
import poly.dto.MelonSongDTO;

public interface IMelonMapperUsingDTO {

   
   /**
    * MongoDB 멜론 노래 리스트 저장하기
    */
   public int insertSong(List<MelonDTO> pList, String colNm) throws Exception;
   
   /**
    * MongoDB 오늘 수집된 멜론 노래 리스트 가져오기
    */
   public List<MelonDTO> getSongList(String colNm) throws Exception;
   
   /**
    * MongoDB 가수별 수집된 노래의 수 가져오기
    */
   public List<MelonDTO> getSingerSongCnt(String colNm) throws Exception;

   
}