package com.cyh.s4.model;

import java.util.List;

public class BoardQnaVO extends BoardVO {

	private List<QnaFilesVO>files;
	
	public List<QnaFilesVO>getFiles(){
		
		return files;
	}
	
	public void setFiles(List<QnaFilesVO>files) {
		this.files=files;
	}
	
	private int ref;
	private int step;
	private int depth;
	
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
}
