package com.thuannd.test.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thuannd.xemdiemthi.dao.MonHocDAO;
import com.thuannd.xemdiemthi.dao.impl.MonHocDAOImpl;
import com.thuannd.xemdiemthi.entities.MonHoc;
import com.thuannd.xemdiemthi.utils.DBConnection;

public class TestMonHocDAOImpl {

	private static Connection connection;
	
	private static MonHocDAO monHocDAO;
	
	@BeforeClass
	public static void init() {
		connection = DBConnection.connect();
		monHocDAO = new MonHocDAOImpl();
	}
	
	@Test
	public void testGetMonHocById() {
		MonHoc monHoc = monHocDAO.getMonHocById(1);
		assertEquals("SQA", monHoc.getTenMonHoc());
	}
	
}
