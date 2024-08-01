package webhsy.board;

public class Board {
	private String title;
	private String content;
	private int boardNo;
	private String writer;
	private static int boardCnt = 1;

	public Board() {};
	public Board(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.boardNo = boardCnt++;
		this.writer = writer;
	};
	
	
	public Board builder() {
		return new Board();
	}
	public Board title(String title) {
		return builder().title(title);
	}
	public Board content(String content) {
		return builder().content(content);
	}
	public Board writer(String writer) {
		return builder().writer(writer);
	}
	public Board build() {
		return new Board(title, content, writer);
	}
}
