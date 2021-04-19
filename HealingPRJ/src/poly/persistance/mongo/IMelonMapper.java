package poly.persistance.mongo;

import java.util.List;

import poly.dto.MelonDTO;

public interface IMelonMapper {

   /**
    * MongoDB 컬렉션 생성
    */
   public boolean createCollection(String colnm) throws Exception;
   
   /**
    * MongoDB 데이터 저장
    */
   public int insertRank(List<MelonDTO> pList, String colNm) throws Exception;
   
}