package es.upm.miw.models.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import es.upm.miw.models.utils.NivelEstudios;

@Entity
public class Votacion {
	public static final String TABLE = "votacion";

	public static final String ID = "ID";

	@Id
	@GeneratedValue
	private Integer id;

	public static final String IP_USUARIO = "IP_USUARIO";

	private String ipUsuario;

	public static final String NIVEL_ESTUDIOS = "NIVEL_ESTUDIOS";

	@Enumerated(EnumType.STRING)
	private NivelEstudios nivelEstudios;

	public static final String VALORACION = "VALORACION";

	private Integer valoracion;

	public static final String TEMA = "ID_TEMA";

	@ManyToOne
	@JoinColumn
	private Tema tema;
	
	public Votacion(){
	}
	    
	public Votacion(String ipUsuario, NivelEstudios nivelEstudios, Integer valoracion, Tema tema){
	    this.ipUsuario = ipUsuario;
	    this.nivelEstudios = nivelEstudios;
	    this.valoracion = valoracion;
	    this.tema = tema;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIpUsuario() {
		return ipUsuario;
	}

	public void setIpUsuario(String ipUsuario) {
		this.ipUsuario = ipUsuario;
	}

	public NivelEstudios getNivelStudios() {
		return nivelEstudios;
	}

	public void setNivelStudios(NivelEstudios nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	@Override
	public boolean equals(Object obj) {
		assert obj != null;
		Votacion other = (Votacion) obj;

		return ipUsuario.equals(other.ipUsuario)
				&& nivelEstudios.equals(other.nivelEstudios)
				&& tema.equals(other.tema);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ipUsuario == null) ? 0 : ipUsuario.hashCode());
		result = prime * result	+ ((nivelEstudios == null) ? 0 : nivelEstudios.hashCode());
		result = prime * result + valoracion;
		result = prime * result + ((tema == null) ? 0 : tema.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Votacion [id=" + id + ", ip usuario=" + ipUsuario
				+ ", nivel de estudios=" + nivelEstudios + ", valoracion="
				+ valoracion + ", id tema=" + tema.getId() + "]";
	}
}
