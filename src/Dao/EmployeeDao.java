package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.EmployeeDispBean;

public class EmployeeDao
{
    private Connection con;

    public EmployeeDao(Connection con)
    {
        super();
        this.con = con;
    }

	//-------------------------------

	private static final String FIND_ALL_SQL =
			"SELECT * "
			+ "FROM employees";

	//-------------------------------
	public List<EmployeeDispBean> findAll() throws SQLException
	{
		List<EmployeeDispBean> eList = new ArrayList<EmployeeDispBean>();

		PreparedStatement stmt1 = con.prepareStatement( FIND_ALL_SQL );
		ResultSet rs = stmt1.executeQuery();

		while( rs.next() )
		{
			EmployeeDispBean ret = new EmployeeDispBean();

			ret.setEmployeeID( 		rs.getInt(			"EmployeeID" ) 				);
			ret.setEmployeeName(	rs.getString(		"employeeName" ) 			);
			ret.seteMail(			rs.getString(		"eMail" )					);
			ret.setHeight(			rs.getBigDecimal(	"height" )					);
			ret.setWeight(			rs.getBigDecimal(	"weight" )					);
			ret.setHireFiscalYear(	rs.getInt(			"hireFiscalYear" )			);
			ret.setBirthday(		rs.getDate(			"birthday" ).toLocalDate()	);
			ret.setBloodType(		rs.getString(		"bloodType")				);

			eList.add(ret);
		}
		return eList;
	}

}