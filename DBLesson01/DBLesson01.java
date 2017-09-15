package DBLesson01;

import java.util.ArrayList;
import java.util.Scanner;

public class DBLesson01 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// Wordクラスのインスタンス配列
		ArrayList<Word> words = new ArrayList<Word>();
		WordDAO wordDAO = new WordDAO();

		System.out.println("英単語と日本語をスペースで区切って入力して下さい。");
		Scanner sc  = new Scanner(System.in);

		int index = 0;
		try{
		while(true){
			String input = sc.nextLine();
			if(input.equals("e")){
				break;
			}
			String[] tmp = new String[2];
			tmp = input.split(" ");
			Word wd = new Word(tmp[0], tmp[1]);
			words.add(wd);
			index++;

			/*wordDAO.setBoth(words.get(index));*/
			/*System.out.println(words);*/
			System.out.println("次の単語を入力してください。\"e\"で終了します。");
		}

		}
		catch(ArrayIndexOutOfBoundsException e){
			e.printStackTrace();
		}

		int r = wordDAO.resistWords(words);

		/*for(Word wd : words){
			System.out.println(wd);
		}*/

		System.out.println(
				r
				+"件登録しました。");
	}
}
