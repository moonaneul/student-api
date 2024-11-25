package com.hongik.studentapi.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {

    public static Connection connect() {
        Connection conn = null;
        try {
            // PostgreSQL 연결 정보
            String url = "jdbc:postgresql://localhost:5432/hongik"; // DB 이름 확인
            String user = "postgres"; // 사용자명 확인
            String password = "1234"; // 비밀번호 확인

            // 데이터베이스 연결 생성
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}