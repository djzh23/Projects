package logic;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board myBoard = new Board();
		
		for(int i = 0; i < myBoard.myBoard.length; i++) {
			for(int j = 0 ; j < myBoard.myBoard[i].length ; j++) {
				myBoard.myBoard[i][j].setValue('x');
				System.out.print("["+myBoard.myBoard[i][j].getValue()+"]");			
			}
			System.out.println();
		}
	}

}
