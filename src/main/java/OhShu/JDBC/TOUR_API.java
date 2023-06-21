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
         URL url = new URL("https://tour.chungnam.go.kr/_prog/openapi/?func=tour&start=1&end=460");
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         Document doc = dbFactory.newDocumentBuilder().parse(url.openStream());

         // DB 연결

         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##OhShu", "OhShu");
         // 삽입 쿼리 실행
         NodeList nodeList = doc.getElementsByTagName("item");
         String query = "INSERT INTO TOUR (tour_no ,tour_location ,tour_category ,tour_name ,tour_sub_title ,tour_address ,tour_x ,tour_y ,tour_tel ,tour_home_url ,tour_info ,tour_img)"
               + "VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?)";
         // 넣을 테이블 이랑 컬럼
         PreparedStatement stmt = conn.prepareStatement(query);

         for (int i = 0; i < nodeList.getLength(); i++) {
            Element element = (Element) nodeList.item(i);
            String tour_no = element.getElementsByTagName("mng_no").item(0).getTextContent();
            String tour_location = element.getElementsByTagName("local_nm").item(0).getTextContent();
            String tour_category = element.getElementsByTagName("type").item(0).getTextContent();
            String tour_name = element.getElementsByTagName("nm").item(0).getTextContent();
            String tour_sub_title = element.getElementsByTagName("nm_sub").item(0).getTextContent();
            String tour_address = element.getElementsByTagName("addr").item(0).getTextContent();
            String tour_x = element.getElementsByTagName("lat").item(0).getTextContent();
            String tour_y = element.getElementsByTagName("lng").item(0).getTextContent();
            String tour_home_url = element.getElementsByTagName("h_url").item(0).getTextContent();
            String tour_tel = element.getElementsByTagName("tel").item(0).getTextContent();
            String tour_info = element.getElementsByTagName("desc").item(0).getTextContent();
            String tour_img = element.getElementsByTagName("list_img").item(0).getTextContent();

            stmt.setString(1, tour_no);
            stmt.setString(2, tour_location);
            stmt.setString(3, tour_category);
            stmt.setString(4, tour_name);
            stmt.setString(5, tour_sub_title);
            stmt.setString(6, tour_address);
            stmt.setString(7, tour_x);
            stmt.setString(8, tour_y);
            stmt.setString(9, tour_home_url);
            stmt.setString(10, tour_tel);
            stmt.setString(11, tour_info);
            stmt.setString(12, tour_img);

            stmt.executeUpdate();
         }
         stmt.close();
         conn.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}