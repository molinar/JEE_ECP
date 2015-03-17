package es.upm.miw.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tema {
    public static final String TABLE = "tema";

    public static final String ID = "ID";
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    public static final String NOMBRE = "NOMBRE";
    
    private String nombre;
    
    public static final String PRENGUNTA = "PREGUNTA";
    
    private String pregunta;
    
    public Tema(){	
    }
    
    public Tema(String nombre, String pregunta){
    	this.nombre = nombre;
    	this.pregunta = pregunta; 
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
        boolean result;
        
        if (this.nombre == null){
        	result = other.nombre == null;
        }else{
        	result = other.nombre != null && this.nombre.equals(other.nombre);
        }
        return result && nombre.equals(other.nombre);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0: nombre.hashCode());
        result = prime * result + ((pregunta == null) ? 0: pregunta.hashCode()); 
        return result;
	}

	@Override
	public String toString() {
		return "Tema [id=" + id + ", nombre=" + nombre + ", pregunta=" + pregunta + "]";
	}
    
    
    
}
