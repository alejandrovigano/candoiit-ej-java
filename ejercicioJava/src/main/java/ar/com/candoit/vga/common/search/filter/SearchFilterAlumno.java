package ar.com.candoit.vga.common.search.filter;

import java.util.Date;

import ar.com.candoit.vga.common.search.SearchFilter;

public class SearchFilterAlumno extends SearchFilter {

    private String nombre;
    private String apellido;
    private Long dni;
    private Long id;
    private Date fechaNacimientoDesde;
    private Date fechaNacimientoHasta;

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

    public Long getDni() {
	return dni;
    }

    public void setDni(Long dni) {
	this.dni = dni;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Date getFechaNacimientoDesde() {
	return fechaNacimientoDesde;
    }

    public void setFechaNacimientoDesde(Date fechaNacimientoDesde) {
	this.fechaNacimientoDesde = fechaNacimientoDesde;
    }

    public Date getFechaNacimientoHasta() {
	return fechaNacimientoHasta;
    }

    public void setFechaNacimientoHasta(Date fechaNacimientoHasta) {
	this.fechaNacimientoHasta = fechaNacimientoHasta;
    }

}
