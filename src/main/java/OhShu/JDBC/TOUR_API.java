package OhShu.JDBC;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TOUR_API {
    public static void main(String[] args) {
        try {
            // API 호출 및 XML 파싱
            URL url = new URL("https://tour.chungnam.go.kr/_prog/openapi/?func=tour");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            Document doc = dbFactory.newDocumentBuilder().parse(url.openStream());

            // DB 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##OhShu", "OhShu");
            // 삽입 쿼리 실행
            NodeList nodeList = doc.getElementsByTagName("item");
            String query = "INSERT INTO tour (tour_location, tour_category, tour_name, tour_sub_title, tour_address, tour_x, tour_y, tour_tel, tour_content, tour_img) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            		//넣을 테이블 이랑 컬럼
            PreparedStatement stmt = conn.prepareStatement(query);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element)nodeList.item(i);
                String stay_location = element.getElementsByTagName("local_nm").item(0).getTextContent();// 여기서 nm이 xml파일 태그 종류
                String stay_category = element.getElementsByTagName("type").item(0).getTextContent();
                String stay_name = element.getElementsByTagName("nm").item(0).getTextContent();
                String stay_address = element.getElementsByTagName("nm_sub").item(0).getTextContent();
                String stay_x = element.getElementsByTagName("addr").item(0).getTextContent();
                String stay_y = element.getElementsByTagName("lat").item(0).getTextContent();
                String stay_tel = element.getElementsByTagName("lng").item(0).getTextContent();
                String stay_home_url = element.getElementsByTagName("tel").item(0).getTextContent();
                String stay_content = element.getElementsByTagName("desc").item(0).getTextContent();
                String stay_img = element.getElementsByTagName("list_img").item(0).getTextContent();
                

                stmt.setString(1, stay_location);
                stmt.setString(2, stay_category);
                stmt.setString(3, stay_name);
                stmt.setString(4, stay_address);
                stmt.setString(5, stay_x);
                stmt.setString(6, stay_y);
                stmt.setString(7, stay_tel);
                stmt.setString(8, stay_home_url);
                stmt.setString(9, stay_content);
                stmt.setString(10, stay_img);
                
                
                stmt.executeUpdate();
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}