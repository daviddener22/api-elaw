package com.david.myapi.resources.exceptions;

public class StandardError {

	private Integer status;
	private Long tempo;
	private String menssagem;

	public StandardError() {
		super();
	}

	public StandardError(Integer status, Long tempo, String menssagem) {
		super();
		this.status = status;
		this.tempo = tempo;
		this.menssagem = menssagem;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getTempo() {
		return tempo;
	}

	public void setTempo(Long tempo) {
		this.tempo = tempo;
	}

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}

}
