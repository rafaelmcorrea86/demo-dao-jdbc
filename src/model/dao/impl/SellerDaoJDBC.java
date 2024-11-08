package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbExceptions;
import model.dao.SellerDao;
import model.entitie.Department;
import model.entitie.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(
					"SELECT seller.*,department.Name as DepName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?"
					);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				Seller sell = instantiateSeller(rs, dep);
				return sell;
			}
							
		} catch (SQLException e) {
			throw new DbExceptions(e.getMessage());
		} finally {
			DB.closedStatement(ps);
			DB.closedResultSet(rs);
		}
		
		return null;
	}

	private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {		
		Seller sell = new Seller();
		sell.setId(rs.getInt("Id"));
		sell.setName(rs.getString("Name"));
		sell.setEmail(rs.getString("Email"));
		sell.setBirthDate(rs.getDate("BirthDate"));
		sell.setBaseSalary(rs.getDouble("BaseSalary"));
		sell.setDepartment(dep);
		return sell;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
