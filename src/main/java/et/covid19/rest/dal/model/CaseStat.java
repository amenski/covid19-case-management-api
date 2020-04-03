package et.covid19.rest.dal.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the case_stat database table.
 * 
 */
@Entity
@Table(name="case_stat")
@NamedQuery(name="CaseStat.findAll", query="SELECT c FROM CaseStat c")
public class CaseStat implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CASE_STAT_gen")
	@SequenceGenerator(name="CASE_STAT_gen", sequenceName = "CASE_STAT_SEQ", allocationSize=1)
	private Integer id;

	@Column(name="active_cases")
	private Integer activeCases;

	@Column(name="new_cases")
	private Integer newCases;

	@Column(name="new_deaths")
	private Integer newDeaths;

	@Column(name="report_date")
	private LocalDate reportDate;

	@Column(name="serious_critical_cases")
	private Integer seriousCriticalCases;

	@Column(name="total_cases")
	private Integer totalCases;

	@Column(name="total_deaths")
	private Integer totalDeaths;

	@Column(name="total_recovered")
	private Integer totalRecovered;

	public CaseStat() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActiveCases() {
		return this.activeCases;
	}

	public void setActiveCases(Integer activeCases) {
		this.activeCases = activeCases;
	}

	public Integer getNewCases() {
		return this.newCases;
	}

	public void setNewCases(Integer newCases) {
		this.newCases = newCases;
	}

	public Integer getNewDeaths() {
		return this.newDeaths;
	}

	public void setNewDeaths(Integer newDeaths) {
		this.newDeaths = newDeaths;
	}

	public LocalDate getReportDate() {
		return this.reportDate;
	}

	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}

	public Integer getSeriousCriticalCases() {
		return this.seriousCriticalCases;
	}

	public void setSeriousCriticalCases(Integer seriousCriticalCases) {
		this.seriousCriticalCases = seriousCriticalCases;
	}

	public Integer getTotalCases() {
		return this.totalCases;
	}

	public void setTotalCases(Integer totalCases) {
		this.totalCases = totalCases;
	}

	public Integer getTotalDeaths() {
		return this.totalDeaths;
	}

	public void setTotalDeaths(Integer totalDeaths) {
		this.totalDeaths = totalDeaths;
	}

	public Integer getTotalRecovered() {
		return this.totalRecovered;
	}

	public void setTotalRecovered(Integer totalRecovered) {
		this.totalRecovered = totalRecovered;
	}

}