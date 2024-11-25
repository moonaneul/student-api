package com.hongik.studentapi.service;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.sql.Connection;
import java.sql.PreparedStatement;
import com.hongik.studentapi.database.DatabaseConnector;

public class StudentDataParser {
    public static void main(String[] args) {
        try {
            String phdHtml = "<ul class=\"n8H08c UVNKR\" style=\"list-style-type: square; margin-left: 0; margin-right: 0; padding: 0;\"><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">Michael Joran, <span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\" href=\"mailto:jordan@hongik.ac.kr\" target=\"_blank\">jordan@hongik.ac.kr</a></span>, 2030</p></li><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">Charles Barkley, <span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\" href=\"mailto:charles@hohoho.com\" target=\"_blank\">charles@hohoho.com</a></span>, 2028</p></li><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">Phil Jackson, <span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\" href=\"mailto:phil@horizon.io\" target=\"_blank\">phil@horizon.io</a></span>, 2025</p></li><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">B32, <span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\" href=\"mailto:b32@horizon.io\" target=\"_blank\">b32@horizon.io</a></span>, 2023</p></li></ul>";

            String masterHtml = "<ul class=\"n8H08c UVNKR\" style=\"list-style-type: square; margin-left: 0; margin-right: 0; padding: 0;\"><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">Snow White, <span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\" href=\"mailto:swhite@hongik.ac.kr\" target=\"_blank\">swhite@hongik.ac.kr</a></span>, 2022</p></li><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">Prince Ali, <span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\" href=\"mailto:ali@kakao.ai\" target=\"_blank\">ali@kakao.ai</a></span>, 2022</p></li><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">Mermaid Ariel, <span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\" href=\"mailto:ma@pajama.com\" target=\"_blank\">ma@pajama.com</a></span>, 2022</p></li><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">axl rose<span style=\"font-variant: normal;\">,</span><span class=\" aw5Odc\" style=\"font-variant: normal; text-decoration: underline;\"><a class=\"XqQF9c\"> </a></span><span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\">ax</a></span><span class=\" aw5Odc\" style=\"font-variant: normal; text-decoration: underline;\"><a class=\"XqQF9c\">@</a></span><span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\">yoyo.ac.kr</a></span><span style=\"font-variant: normal;\">, 2022</span></p></li><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">A48, <span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\" href=\"mailto:a48@pajama.com\" target=\"_blank\">a48@pajama.com</a></span>, 2031</p></li><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">B48, <span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\" href=\"mailto:b48@kakao.ai\" target=\"_blank\">b48@kakao.ai</a></span>, 2025</p></li></ul>";

            String undergradHtml = "<ul class=\"n8H08c UVNKR\" style=\"list-style-type: square; margin-left: 0; margin-right: 0; padding: 0;\"><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">Bradley Cooper, <span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\" href=\"mailto:bcooper@hello.world.gov\" target=\"_blank\">bcooper@hello.world.gov</a></span>, 2023</p></li><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">Sangmoon Park, <span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\" href=\"mailto:spark@hongik.ac.kr\" target=\"_blank\">spark@hongik.ac.kr</a></span>, 2022</p></li><li dir=\"ltr\" class=\"TYR86d zfr3Q\" style=\"margin-left: 15pt;\"><p dir=\"ltr\" class=\"CDt4Ke zfr3Q\" style=\"margin-left: 0; padding-left: 0; text-indent: 0;\">A43, <span class=\" aw5Odc\" style=\"text-decoration: underline;\"><a class=\"XqQF9c\" href=\"mailto:a43@horizon.io\" target=\"_blank\">a43@horizon.io</a></span>, 2024</p></li></ul>";

            parseStudents(phdHtml, "PhD Students", "PhD");
            parseStudents(masterHtml, "Master Students", "Master");
            parseStudents(undergradHtml, "Undergraduate Students", "Undergraduate");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // HTML 데이터 파싱 메서드
    private static void parseStudents(String html, String sectionName, String degree) {
        // HTML 데이터를 파싱
        Document doc = Jsoup.parse(html);

        // 학생 정보 추출
        try (Connection conn = DatabaseConnector.connect()) { // 데이터베이스 연결
            Elements studentElements = doc.select("li");
            for (Element studentElement : studentElements) {
                // 전체 텍스트에서 이름, 이메일, 졸업 연도 추출
                String fullText = studentElement.select("p").text();
                String[] parts = fullText.split(", ");

                if (parts.length < 3) continue; // 데이터가 불완전한 경우 건너뜀

                String name = parts[0].trim();
                String email = studentElement.select("a").attr("href").replace("mailto:", "").trim();
                int graduation = Integer.parseInt(parts[2].trim());

                // 데이터베이스에 저장
                saveToDatabase(conn, name, email, degree, graduation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void saveToDatabase(Connection conn, String name, String email, String degree, int graduation) {
        String sql = "INSERT INTO students (name, email, degree, graduation) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, degree);
            pstmt.setInt(4, graduation);

            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}