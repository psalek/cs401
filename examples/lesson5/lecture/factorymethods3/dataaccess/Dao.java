package lesson5.lecture.factorymethods3.dataaccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Dao {
	public DataAccess getDataAccessSystem();
	public String getSql();
	public void unpackResultSet(ResultSet rs) throws SQLException;
	public List<?> getResults();
}
