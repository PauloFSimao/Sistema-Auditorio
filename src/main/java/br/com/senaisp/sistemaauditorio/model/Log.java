package br.com.senaisp.sistemaauditorio.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Calendar logData;
	
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToOne
	private Agendamento agendamento;

	private TipoLog tipoLog;
	
	
	public Log(Usuario usuario, TipoLog tipoLog) {
		
		this.usuario = usuario;
		this.tipoLog = tipoLog;
	}
	
	public Log(Usuario usuario, TipoLog tipoLog, Agendamento agendamento) {
		
		this.agendamento = agendamento;
		this.usuario = usuario;
		this.tipoLog = tipoLog;
	}
}
