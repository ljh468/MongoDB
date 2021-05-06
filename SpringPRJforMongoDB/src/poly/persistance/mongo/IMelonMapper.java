package poly.persistance.mongo;

import java.util.List;
import java.util.Map;

public interface IMelonMapper {

   /**
    * 멜론 노래 리스트 저장하기
    */
   public int insertSong(List<Map<String, Object>> pList, String colNm) throws Exception;
   
   /**
    * 오늘 수집된 멜론 노래리스트 가져오기
    */
   public List<Map<String, String>> getSongList(String colNm) throws Exception;
   
   /**
    * 가수별 수집된 노래의 수 가져오기
    */
   public List<Map<String, String>> getSingerSongCnt(String colNm) throws Exception;
   
   
  
   
}