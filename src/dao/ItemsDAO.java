package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBHelper;

import entity.Items;

//Business Logic Object for Items
public class ItemsDAO {

	// Get all items' informations
	public ArrayList<Items> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>();
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from items;";// SQL code
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Items items = new Items();
				items.setId(rs.getInt("id"));
				items.setName(rs.getString("name"));
				items.setCity(rs.getString("city"));
				items.setNumber(rs.getInt("number"));
				items.setPrice(rs.getInt("price"));
				items.setPicture(rs.getString("picture"));
				// Add the items to the list
				list.add(items);
			}
			// return items list;
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// Release resource:data set object
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// Release resource: SQL code object
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	// Get item's information by id
	public Items getItemsById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConnection();
			String sql = "select * from items where id = ?;";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Items items = new Items();
				items.setId(rs.getInt("id"));
				items.setName(rs.getString("name"));
				items.setCity(rs.getString("city"));
				items.setNumber(rs.getInt("number"));
				items.setPrice(rs.getInt("price"));
				items.setPicture(rs.getString("picture"));
				return items;
			} else {
				return null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			// Release resource:data set object
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			// Release resource: SQL code object
			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// Get recently infos of first five items
	public ArrayList<Items> getViewList(String list) {
		int count = 5;
		ArrayList<Items> item = new ArrayList<Items>();

		if (list != null && list.length() > 0) {
			String[] array = list.split(",");

			if (array.length >= 5) {
				for (int i = array.length - 1; i >= array.length - count; i--) {
					item.add(getItemsById(Integer.parseInt(array[i])));
				}
			} else {
				for (int i = array.length - 1; i >= 0; i--) {
					item.add(getItemsById(Integer.parseInt(array[i])));
				}
			}
			return item;
		} else {
			return null;
		}

	}
	/*
	 * public static void main(String[] args){
	 * 
	 * ArrayList<Items> list = new ArrayList<Items>();
	 * 
	 * ItemsDAO itemsDAO = new ItemsDAO(); list = itemsDAO.getAllItems();
	 * 
	 * for(Items i : list){ System.out.println(i.getId() + " " + i.getName() +
	 * i.getCity() + " " + i.getNumber()); } }
	 */
}