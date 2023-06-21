package OhShu.JDBC;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FOOD_API {
    public static void main(String[] args) {
        try {
            // API 호출 및 XML 파싱
            URL url = new URL("https://tour.chungnam.go.kr/_prog/openapi/?func=food");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            Document doc = dbFactory.newDocumentBuilder().parse(url.openStream());

            // DB 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##OhShu", "OhShu");
            // 삽입 쿼리 실행
            NodeList nodeList = doc.getElementsByTagName("item");
            String query = "INSERT INTO FOOD (food_location, food_source, food_name, food_address, food_tel, food_info, food_img) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            		//넣을 테이블 이랑 컬럼
            PreparedStatement stmt = conn.prepareStatement(query);

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element)nodeList.item(i);
                String food_location = element.getElementsByTagName("local_nm").item(0).getTextContent();// 여기서 nm이 xml파일 태그 종류
                String source = element.getElementsByTagName("type").item(0).getTextContent();
                String food_name = element.getElementsByTagName("nm").item(0).getTextContent();
                String food_address = element.getElementsByTagName("addr").item(0).getTextContent();
                String food_tel = element.getElementsByTagName("tel").item(0).getTextContent();
                String food_info = element.getElementsByTagName("desc").item(0).getTextContent();
                String food_img = element.getElementsByTagName("list_img").item(0).getTextContent();
                

                stmt.setString(1, food_location);
                stmt.setString(2, source);
                stmt.setString(3, food_name);
                stmt.setString(4, food_address);
                stmt.setString(5, food_tel);
                stmt.setString(6, food_info);
                stmt.setString(7, food_img);
                
                
                stmt.executeUpdate();
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}