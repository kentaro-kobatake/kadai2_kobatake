package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dao.Dao;
import Dao.EmployeeDao;
import bean.EmployeeDispBean;
import bean.EmployeeListDispBean;

public class EmployeeService
{

	public EmployeeListDispBean findAll()
	{
		EmployeeListDispBean bean = new EmployeeListDispBean();

		//オートクローズ
		try( Connection con= Dao.getConnection() )
		{
			EmployeeDao dao = new EmployeeDao(con);

			List<EmployeeDispBean> eList = dao.findAll();

			bean.setEmpList(eList);

//			System.out.println("従業員の情報は以下です。\n"
//								+ eList.toString()
//								);
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		return bean;
	}

	//--------------------------------------------
	public List<EmployeeDispBean> findAll(String strId)
	{

		List<EmployeeDispBean> emp = null;
		try( Connection con = Dao.getConnection() )
		{

			//int id= Integer.parseInt( strId );

			EmployeeDao dao = new EmployeeDao(con);

			emp =  dao.findAll();


		}
		catch( SQLException | ClassNotFoundException e1 )
		{
			e1.printStackTrace();
			throw new RuntimeException( e1 );
		}

		return emp;
	}


}