package poly.persistance.mongo;

import java.util.List;

import poly.dto.MelonDTO;
import poly.dto.MelonRankDTO;
import poly.dto.MelonSingerDTO;
import poly.dto.MelonSongDTO;

public interface IMelonMapper {

   /**
    * MongoDB 컬렉션 생성
    */
   public boolean createCollection(String colnm) throws Exception;
   
   /**
    * MongoDB 멜론데이터 저장
    */
   public int insertRank(List<MelonDTO> pList, String colNm) throws Exception;
   
   /**
    * MongoDB 멜론데이터 가져오기
    */
   public List<MelonDTO> getRank(String colNm) throws Exception;
   
   /**
    * MongoDB 가수의 노래 데이터 가져오기
    */
   public List<MelonSongDTO> getSongForSinger(String colNm, String singer) throws Exception;

   /**
    * MongoDB 가수별 멜론 랭킹에 많이 등록된 순서대로 가져오기
    */
   public List<MelonSingerDTO> getRankForSinger(String colNm) throws Exception;
   
   /**
    * MongoDB 노래별 순위 변동 정보
    */
   public List<MelonRankDTO> getCompareRank(String curColNm, String preColNm) throws Exception;
   
}