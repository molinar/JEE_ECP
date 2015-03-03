package es.upm.miw.models.entities;

public class Tema {
    public static final String TABLE = "tema";

    public static final String ID = "ID";

    private Integer id;
    
    public static final String NOMBRE = "NOMBRE";
    
    private String nombre;
    
    public static final String PRENGUNTA = "PREGUNTA";
    
    private String pregunta;
    
    public Tema(){	
    }
    
    public Tema(Integer id, String nombre, String pregunta){
    	this.id = id;
    	this.nombre = nombre;
    	this.pregunta = pregunta;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	@Override
	public boolean equals(Object obj) {
		assert obj != null;
        Tema other = (Tema) obj;
        return id.equals(other.id) && nombre.equals(other.nombre)
                && pregunta.equals(other.pregunta);
    }

	@Override
	public String toString() {
		return "Tema [id=" + id + ", nombre=" + nombre + ", pregunta=" + pregunta + "]";
	}
    
    
    
}
