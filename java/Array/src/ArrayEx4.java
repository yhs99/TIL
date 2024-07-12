import java.util.Scanner;

public class ArrayEx4 {

	public static void main(String[] args) {
		//학생4명의 국어, 영어, 수학, 점수를 입력받아서 2차원에 저장하고 출력하기
		Scanner sc = new Scanner(System.in);
		int[][] student = new int[4][3];
		for(int i=0; i<student.length; i++) {
			for(int j=0; j<student[i].length; j++) {
				System.out.printf("%d 번째 학생의 %d 번째 과목 점수를 입력하세요", i+1, j+1);
				int inValue = sc.nextInt();
				student[i][j] = inValue;
			}
		}
		for(int l=0; l<student.length; l++) {
			int korean = student[l][0];
			int english = student[l][1];
			int math = student[l][2];
			int total = korean + english + math;
			float average = total / 3f;
			char grade = (average<=100 && average>=90) ? 'A' : (average < 90 && average >= 80) ? 'B' : (average < 80 && average >= 70) ? 'C' : (average < 70 && average >= 60) ? 'D' : 'F';
			System.out.println("=======================================================");
			System.out.printf("%d 번째 학생\n", l);
			System.out.printf("국어 : %d ", student[l][0]);
			System.out.printf("영어 : %d ", student[l][1]);
			System.out.printf("수학 : %d ", student[l][2]);
			System.out.printf("총점 : %d ", total);
			System.out.printf("평균 : %.2f ", average);
			System.out.printf("학점 : %c \n", grade);
			System.out.println("=======================================================");
		}
	}

}
