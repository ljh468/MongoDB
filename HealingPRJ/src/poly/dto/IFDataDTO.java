package poly.dto;

import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * 빅데이터 분석 및 처리 과정에 대한 히스토리 생성, MongoDB에 저장
 */
public class IFDataDTO {

	private String fileSeq;
	private String originalId;
	private String fileId;
	private String batteryModel;
	private String batteryType;
	private String batteryArch;
	private String fileDate;
	private String segTotCnt;

	private String fileGrpNm;
	private String dir;
	private String status; // ICommCont 정의된 상태 코드 참조
	private String createTime;

	private String StartTime;
	private String EndTime;

	private ObjectId mongoId;
	private Document soc;

	public String getFileSeq() {
		return fileSeq;
	}

	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}

	public String getOriginalId() {
		return originalId;
	}

	public void setOriginalId(String originalId) {
		this.originalId = originalId;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getBatteryModel() {
		return batteryModel;
	}

	public void setBatteryModel(String batteryModel) {
		this.batteryModel = batteryModel;
	}

	public String getBatteryType() {
		return batteryType;
	}

	public void setBatteryType(String batteryType) {
		this.batteryType = batteryType;
	}

	public String getBatteryArch() {
		return batteryArch;
	}

	public void setBatteryArch(String batteryArch) {
		this.batteryArch = batteryArch;
	}

	public String getFileDate() {
		return fileDate;
	}

	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}

	public String getSegTotCnt() {
		return segTotCnt;
	}

	public void setSegTotCnt(String segTotCnt) {
		this.segTotCnt = segTotCnt;
	}

	public String getFileGrpNm() {
		return fileGrpNm;
	}

	public void setFileGrpNm(String fileGrpNm) {
		this.fileGrpNm = fileGrpNm;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStartTime() {
		return StartTime;
	}

	public void setStartTime(String startTime) {
		StartTime = startTime;
	}

	public String getEndTime() {
		return EndTime;
	}

	public void setEndTime(String endTime) {
		EndTime = endTime;
	}

	public ObjectId getMongoId() {
		return mongoId;
	}

	public void setMongoId(ObjectId mongoId) {
		this.mongoId = mongoId;
	}

	public Document getSoc() {
		return soc;
	}

	public void setSoc(Document soc) {
		this.soc = soc;
	}

}
