
public class ArrayEx3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2차원 배열 선언과 생성
		int[][] arr = new int[3][4];
		int[][] arr1 = {{1,2,3}, {4,5,6}};
		
		for(int r = 0; r < arr1.length; r++) {
			for(int c = 0; c < arr1[r].length; c++) {
				System.out.print(arr1[r][c]+" ");
			}
			System.out.println();
		}
		int idx = 1;
		// arr 배열에 1부터 1씩 증가된 값을 요소에 할당
		for(int r = 0; r < arr.length; r++) {
			for(int c = 0; c < arr[r].length; c++) {
				arr[r][c] = idx++;
				System.out.println(arr[r][c]+" ");
			}
		}
	}

}
