package ar.com.candoit.vga.common.search.filter;

import ar.com.candoit.vga.common.search.SearchFilter;

public class SearchFilterCurso extends SearchFilter {

    private Long id;
    private String denominacion;

    /**
     * @return the id
     */
    public Long getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * @return the denominacion
     */
    public String getDenominacion() {
	return denominacion;
    }

    /**
     * @param denominacion
     *            the denominacion to set
     */
    public void setDenominacion(String denominacion) {
	this.denominacion = denominacion;
    }

}
