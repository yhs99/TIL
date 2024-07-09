
public class ScoreV1 {
	
	public static void main(String[] args) {
		// 성적표
		String name = "홍길동";
		int korean = 90, english = 38, math = 97;
		int total = korean + english + math;
		float average = (float) total/3;
		char grade = ' ';
		
		switch((int) (average/10)) {
			case 10:
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default:
				grade = 'F';
		}
		char grade1 = (average>=90) ? 'A' : (average >= 80) ? 'B' : (average >= 70) ? 'C' : (average >= 60) ? 'D' : 'F';
		
		System.out.println("이름 \t 국어 \t 영어 \t 수학 \t 총점 \t 평균 \t 학점");
		System.out.printf("%s \t %d \t %d \t %d \t %d \t %.2f \t %c", name, korean, english, math, total, average, grade1);
	}

}
