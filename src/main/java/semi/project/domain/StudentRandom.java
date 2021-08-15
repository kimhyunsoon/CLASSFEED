package semi.project.domain;


public class StudentRandom {
	private final char[] digits = {
	        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
	        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 
	        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 
	        'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
	        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 
	        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
	        'Y', 'Z'
	    };
	
	public char[] ran() {
		long v = System.nanoTime();
		int shift = 6;
		char[] buf = new char[62];
		int charPos = 62;
		int radix = 1 << shift;
		long mask = radix-1;
		long number = v;
		
		try {
			do {
				buf[--charPos] = digits[(int) (number & mask)];
		        number >>>= shift;
			}while (number != 0);
			return buf;
		}catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
			return null;
		}
		
		
	}
	

}
