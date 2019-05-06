package com.thuannd.test.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.thuannd.xemdiemthi.dao.UserDAO;
import com.thuannd.xemdiemthi.dao.impl.UserDAOImpl;
import com.thuannd.xemdiemthi.entities.Diem;
import com.thuannd.xemdiemthi.entities.SinhVien;
import com.thuannd.xemdiemthi.entities.diemTKMonHoc;
import com.thuannd.xemdiemthi.utils.DBConnection;

public class TestUserDAOImpl {

	private static Connection conn;
	private static UserDAO userDAO;
	private static UserDAOImpl userDAOImpl;
	

	@BeforeClass
	public static void init() {
		conn = DBConnection.connect();
		userDAO = new UserDAOImpl();
		userDAOImpl = new UserDAOImpl();
	}

	@Test
	public void testLogin() {
		SinhVien sinhVien = userDAO.login("b15dccn545", "123");
		assertEquals("b15cqcn6", sinhVien.getLop());
	}

	@Test
	public void testGetResultPoint() {
		ArrayList<Diem> diems = (ArrayList<Diem>) userDAO.getResultPoint(1, 1);
		assertEquals("Đại Số", diems.get(0).getMonHoc().getTenMonHoc());
		assertEquals("Giải Tích 1", diems.get(1).getMonHoc().getTenMonHoc());
		assertEquals("THCS 1", diems.get(2).getMonHoc().getTenMonHoc());
	}

	@Test
	public void testGetDiemTongKetMonHocTheoKy() {
		ArrayList<diemTKMonHoc> tkMonHocs = userDAO.getDiemTongKetMonHocTheoKy(1, 1);
		assertEquals(7.9000000432133675f, tkMonHocs.get(0).getDiemTK());
		assertEquals(7.800000041723251f, tkMonHocs.get(1).getDiemTK());
		assertEquals(7.300000041723251f, tkMonHocs.get(2).getDiemTK());
	}
	
	@Test
	public void testDiemTBHocKy() {
		float actual = userDAO.diemTBHocKy(1, 1);
		assertEquals(7.6666665f, actual);
	}

	@Test
	public void testGetDiemTongKetMonHoc() {
		ArrayList<diemTKMonHoc> actual = userDAO.getDiemTongKetMonHocTheoKy(1, 1);
		assertEquals(7.9000000432133675f, actual.get(0).getDiemTK());
		assertEquals(7.800000041723251f, actual.get(1).getDiemTK());
		assertEquals(7.300000041723251f, actual.get(2).getDiemTK());
	}
	
	@Test
	public void testDiemTBTichLuy() {
		float actual = userDAO.diemTBTichLuy(1, 2);
		assertEquals(7.625f, actual);
	}
	
	@Test
	public void testSoTinChiDatDuoc() {
		int actual = userDAO.soTinChiDatDuoc(1, 2);
		assertEquals(3, actual);
	}
	
	@Test
	public void testSoTinChiTichLuy() {
		int actual = userDAO.soTinChiTichLuy(1, 2);
		assertEquals(12, actual);
	}
	
	@Test
	public void testDiemTBHocKyHe4() {
		float actual = userDAO.diemTBHocKyHe4(1, 1);
		assertEquals(3.0f, actual);
	}
	
	@Test
	public void testDiemTBTichLuyHe4() {
		float actual = userDAO.diemTBTichLuyHe4(1, 2);
		assertEquals(3.0f, actual);
	}
	
	@Test
	public void testDiemHe4() {
		float actual1 = userDAOImpl.diemHe4(3.9f);
		assertEquals(0, actual1);
		float actual2 = userDAOImpl.diemHe4(4.9f);
		assertEquals(1, actual2);
		float actual3 = userDAOImpl.diemHe4(5.4f);
		assertEquals(1.5f, actual3);
		float actual4 = userDAOImpl.diemHe4(6.4f);
		assertEquals(2, actual4);
		float actual5 = userDAOImpl.diemHe4(6.9f);
		assertEquals(2.5, actual5);
		float actual6 = userDAOImpl.diemHe4(7.9f);
		assertEquals(3, actual6);
		float actual7 = userDAOImpl.diemHe4(8.4f);
		assertEquals(3.5, actual7);
		float actual8 = userDAOImpl.diemHe4(8.9f);
		assertEquals(3.7, actual8);
		float actual9 = userDAOImpl.diemHe4(9.9f);
		assertEquals(4, actual9);
	}
	
}
