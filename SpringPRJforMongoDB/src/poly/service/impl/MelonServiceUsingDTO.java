package poly.service.impl;

import static poly.util.CmmUtil.nvl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import poly.dto.MelonDTO;
import poly.persistance.mongo.IMelonMapperUsingDTO;
import poly.service.IMelonServiceUsingDTO;
import poly.util.DateUtil;

@Service("MelonServiceUsingDTO")
public class MelonServiceUsingDTO implements IMelonServiceUsingDTO {

	@Resource(name = "MelonMapperUsingDTO")
	private IMelonMapperUsingDTO melonMapper; // MongoDB에 저장할 Mapper

	// 로그 파일 생성
	private Logger log = Logger.getLogger(this.getClass());

	@Override
	public int collectMelonSong() throws Exception {

		// 로그찍기
		log.info(this.getClass().getName() + "collectMelonSong Start!!");

		int res = 0;

		List<MelonDTO> pList = new LinkedList<MelonDTO>();

		// 멜론 Top100 중 50위 까지 정보 가져오는 페이지
		String url = "https://www.melon.com/chart/day/index.htm";

		// JSOUP 라이브러리를 통해 사이트 접속되면, 그사이트의 전체 HTML 소스 저장할 변수
		Document doc = null;

		doc = Jsoup.connect(url).get();

		// <div class="service_list_song"> 이 태그 내에서 있는 HTML소스만 element에저장됨
		Elements element = doc.select("div.service_list_song");

		// Iterator를 사용하여 멜론 Top100의 50위까지 순위정보 가져오기
		Iterator<Element> songList = element.select("div.wrap_song_info").iterator(); // 멜론 50위 까지 체크

		// 순위는 1위부터 50위까지 수집되기 때문에 반복문을 통해 데이터 저장
		while (songList.hasNext()) {

			Element songInfo = songList.next();

			// 크롤링을 통해 데이터 저장하기
			String song = nvl(songInfo.select("div.ellipsis.rank01 a").text()); // 노래
			String singer = nvl(songInfo.select("div.ellipsis.rank02 a").eq(0).text()); // 가수
			
			log.info("song : " + song);
			log.info("singer : " + singer);
			
			// 가수와 노래 정보가 모두 수집되었다면, 저장함
			if ((song.length() > 0 && (singer.length() > 0))) {

			// MongoDB에 저장할 List 형태의 맞는 DTO 데이터 저장하기
			MelonDTO pDTO = new MelonDTO();
			
			pDTO.setCollect_time(DateUtil.getDateTime("yyyyMMddhhmmss"));
			pDTO.setSong(song);
			pDTO.setSinger(singer);

			// 한번에 여러개의 데이터를 MongoDB에 저장할 List 형태의 데이터 저장하기
			pList.add(pDTO);
			
			// 사용이 완료되면 메모리 비우기
			pDTO = null;
		}
		
		songInfo = null;
		
	}
		doc = null;
		
		// 생성할 컬렉션 명
		String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");
		
		// MongoDB에 데이터 저장하기
		melonMapper.insertSong(pList, colNm);
		
		log.info(this.getClass().getName() + "collectMelonSong end!!");
		
		return res;
	}

	@Override
	public List<MelonDTO> getSingerSongCnt() throws Exception {

		log.info(this.getClass().getName() + ".getSingerSongCnt Start!");

		// 죄회할 컬렉션 이름
		String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

		List<MelonDTO> rList = melonMapper.getSingerSongCnt(colNm);

		if (rList == null) {
			rList = new LinkedList<MelonDTO>();

		}

		log.info(this.getClass().getName() + ".getSingerSongCnt end!");

		return rList;
	}

	@Override
	public List<MelonDTO> getSongList() throws Exception {

		log.info(this.getClass().getName() + ".getSongList Start!");

		// 죄회할 컬렉션 이름
		String colNm = "MELON_" + DateUtil.getDateTime("yyyyMMdd");

		List<MelonDTO> rList = melonMapper.getSongList(colNm);

		if (rList == null) {
			rList = new LinkedList<MelonDTO>();

		}

		log.info(this.getClass().getName() + ".getSongList end!");

		return rList;
	}

	


}