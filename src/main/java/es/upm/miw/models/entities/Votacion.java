package es.upm.miw.models.entities;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import es.upm.miw.models.utils.NivelEstudios;

public class Votacion {
	public static final String TABLE = "votacion";
	
	public static final String ID = "ID";

    private Integer id;
    
    public static final String IP_USUARIO = "IP_USUARIO";
	
	private String ipUsuario;
	
	public static final String NIVEL_ESTUDIOS = "NIVEL_ESTUDIOS";
	
	@Enumerated(EnumType.STRING) 
    private NivelEstudios nivelStudios;
	
	public static final String VALORACION = "VALORACION";
	
	private Integer valoracion;
	
	public static final String TEMA = "ID_TEMA";
	
	private Tema tema;

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
		return nivelStudios;
	}

	public void setNivelStudios(NivelEstudios nivelStudios) {
		this.nivelStudios = nivelStudios;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoración) {
		this.valoracion = valoración;
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
        return id.equals(other.id) && ipUsuario.equals(other.ipUsuario)
                && nivelStudios.equals(other.nivelStudios) && valoracion.equals(other.valoracion)
                && tema.equals(other.tema);
	}

	@Override
	public String toString() {
		return "Votacion [id=" + id + ", ip usuario=" + ipUsuario + ", nivel de estudios=" 
				+ nivelStudios + ", valoracion=" + valoracion + ", id tema=" + tema.getId() +"]";
	}	
}
