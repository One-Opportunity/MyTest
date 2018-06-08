package dto;

import java.util.Date;

public class MovieDTO {
	private Integer rno = null;
	private String mtitle = null;
	private String mwriter = null;
	private Float mscore = null;
	private String mreviews = null;
	private Date regdate = null;
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getMwriter() {
		return mwriter;
	}
	public void setMwriter(String mwriter) {
		this.mwriter = mwriter;
	}
	public Float getMscore() {
		return mscore;
	}
	public void setMscore(Float mscore) {
		this.mscore = mscore;
	}
	public String getMreviews() {
		return mreviews;
	}
	public void setMreviews(String mreviews) {
		this.mreviews = mreviews;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "MovieDTO [rno=" + rno + ", mtitle=" + mtitle + ", mwriter=" + mwriter + ", mscore=" + mscore
				+ ", mreviews=" + mreviews + ", regdate=" + regdate + "]";
	}

}
