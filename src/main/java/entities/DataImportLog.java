package entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by C06590861 on 03/03/2017.
 */

@Entity
@Table(name = "data_import_log")
public class DataImportLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "import_date")
	private Date importDate;
	@Column(name = "successful_import")
	private Boolean successfulImport;
	@Column(name = "number_imports")
	private Long numImports;

	public DataImportLog() {
	}

	public DataImportLog(Date importDate, Boolean successfulImport, Long numImports) {
		this.importDate = importDate;
		this.successfulImport = successfulImport;
		this.numImports = numImports;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public Boolean getSuccessfulImport() {
		return successfulImport;
	}

	public void setSuccessfulImport(Boolean successfulImport) {
		this.successfulImport = successfulImport;
	}

	public Long getNumImports() {
		return numImports;
	}

	public void setNumImports(Long numImports) {
		this.numImports = numImports;
	}
}
