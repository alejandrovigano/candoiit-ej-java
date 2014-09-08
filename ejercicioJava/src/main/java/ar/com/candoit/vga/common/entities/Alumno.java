package ar.com.candoit.vga.common.entities;

import java.util.Date;

/**
 * Info de alumno
 * 
 * @author Usuario
 *
 */
public class Alumno {

    /** Id */
    private Long id;
    /** Nombre */
    private String nombre;
    /** Apellido */
    private String apellido;
    /** Dni */
    private long dni;
    /** FechaNacimiento */
    private Date fechaNacimiento;
    /** Fecha alta al sistema */
    private Date fechaAlta;
    /** Fecha baja al sistema */
    private Date fechaBaja;

    public Alumno() {
    }
    
    public Alumno(Long id) {
	this.id = id;
    }
    
    public Date getFechaNacimiento() {
	return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaAlta() {
	return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
	this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
	return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
	this.fechaBaja = fechaBaja;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getApellido() {
	return apellido;
    }

    public void setApellido(String apellido) {
	this.apellido = apellido;
    }

    public long getDni() {
	return dni;
    }

    public void setDni(long dni) {
	this.dni = dni;
    }
}
