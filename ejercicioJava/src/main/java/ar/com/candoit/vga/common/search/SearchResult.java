package ar.com.candoit.vga.common.search;

import java.util.List;

public class SearchResult<E> {

    private List<E> results;
    private boolean truncated;
    private Long totalResults;

    public List<E> getResults() {
	return results;
    }

    public void setResults(List<E> results) {
	this.results = results;
    }

    public boolean isTruncated() {
	return truncated;
    }

    public void setTruncated(boolean truncated) {
	this.truncated = truncated;
    }

    public Long getTotalResults() {
	return totalResults;
    }

    public void setTotalResults(Long totalResults) {
	this.totalResults = totalResults;
    }

}
