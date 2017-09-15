package DBLesson01;;

public class Word{
	private String english;
	private String japanese;

	public Word(String english, String japanese){
		super();
		this.english = english;
		this.japanese = japanese;
	}


	public String getEnglish(){
		return this.english;
	}
	public void setEnglish(String english) {
		 this.english = english;
		}

	public String getJapanese(){
		return this.japanese;
	}
	public String setJapanese (String japanese){
		return this.japanese = japanese;
	}


	public String toString(){
		return ("英単語："
				+this.english
				+"　日本語："
				+this.japanese);

	}

}

