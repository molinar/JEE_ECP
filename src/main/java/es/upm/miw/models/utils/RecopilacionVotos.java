package es.upm.miw.models.utils;

import java.util.List;

import es.upm.miw.models.entities.Tema;

public class RecopilacionVotos {

	private Tema tema;

	private int numeroVotos;

	private List<RecopilacionMedias> recopilacionMediasTema;

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public int getNumeroVotos() {
		return numeroVotos;
	}

	public void setNumeroVotos(int numeroVotos) {
		this.numeroVotos = numeroVotos;
	}

	public List<RecopilacionMedias> getRecopilacionMediasTema() {
		return recopilacionMediasTema;
	}

	public void setRecopilacionMediasTema(
			List<RecopilacionMedias> recopilacionMediasTema) {
		this.recopilacionMediasTema = recopilacionMediasTema;
	}
}
