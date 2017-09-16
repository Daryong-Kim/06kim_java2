package DBLesson02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBLesson01.Word;

public class WordDAO {

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	ResultSet res = null;

	public int resistWords(ArrayList<Word> w) {
		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test_db?useUnicode=true&characterEncoding=utf8", "root", "");

			if(con != null){
				System.out.println("DB接続完了（getConnection後）\r\n----");
			}
			else{
				System.out.println("DB接続失敗\r\n----");
			}

			for(result = 0;result < w.size();result++){
			Word a = w.get(result);
			String E = a.getEnglish();
			String J = a.getJapanese();


			String SQL = "INSERT INTO dictionary (english, japanese) VALUES(?, ?)";
			st = con.prepareStatement(SQL);
			st.setString(1, E); //英語
			st.setString(2, J); //日本語
			st.executeUpdate();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;	// 結果を返す
	}

	public ArrayList<Word> gWords(){
		ArrayList<Word> list = new ArrayList<Word>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/test_db?useUnicode=true&characterEncoding=utf8", "root", "");

			if(con != null){
				System.out.println("DB接続完了（getConnection後）\r\n----");
			}
			else{
				System.out.println("DB接続失敗\r\n----");
			}

			String count = "SELECT count(word_id) FROM dictionary";
			st = con.prepareStatement(count);
			ResultSet rs = st.executeQuery();
			int num = rs.getInt(0);

			int i = 0;
			for(i = 0; i < num; i++){
			String SQL = "SELECT * FROM dictionary WHERE word_id = ?";
			st = con.prepareStatement(SQL);
			st.setInt(1, i);
			ResultSet res = st.executeQuery();
			String En = res.getString(2);
			String Jp = res.getString(3);
			Word wd2 = new Word(En,Jp);
			list.add(wd2);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;	// 結果を返す
	}

}
