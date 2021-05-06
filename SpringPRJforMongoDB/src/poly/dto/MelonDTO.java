package poly.dto;

public class MelonDTO {
	private String collect_time; // 수집시간
	private String song; // 노래 제목
	private String singer; // 가수
	private int singerCnt;
	
	public int getSingerCnt() {
		return singerCnt;
	}
	public void setSingerCnt(int singerCnt) {
		this.singerCnt = singerCnt;
	}
	public String getCollect_time() {
		return collect_time;
	}
	public void setCollect_time(String collect_time) {
		this.collect_time = collect_time;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	
}
