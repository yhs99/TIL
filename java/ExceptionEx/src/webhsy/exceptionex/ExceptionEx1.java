package webhsy.exceptionex;

public class ExceptionEx1 {

	public static void main(String[] args) {
		try {
			install();
		}catch(InstallException e) {
			e.printStackTrace();
		}
	}
	
	private static void install() throws InstallException {
		try {
			startInstall();
			copyFiles();
		}catch(DiskNotEnoughException | MemoryNotEnoughException e) {
			System.out.println(e.getMessage());
			InstallException ie = new InstallException("설치중 예외 발생");
			ie.initCause(e); // 원인예외
			ie.getCause();
			throw ie;
		}finally {
			deleteDumpFiles();
		}
	}
	
	private static void startInstall() throws DiskNotEnoughException, MemoryNotEnoughException {
		System.out.println("설치를 시작합니다.");
		if(!calSpace()) {
			throw new DiskNotEnoughException("디스크 공간이 부족합니다.");
		}
		if(!calMemory()) {
			throw new MemoryNotEnoughException("메모리가 부족합니다.");
		}
	}
	
	private static boolean calMemory() {
		return false;
	}
	
	private static boolean calSpace() {
		return true;
	}
	
	private static void copyFiles() {
		System.out.println("파일 복사를 시작합니다.");
	}
	
	private static void deleteDumpFiles() {
		System.out.println("덤프 파일 삭제를 시작합니다.");
	}
}

@SuppressWarnings("serial")
class DiskNotEnoughException extends Exception {
	DiskNotEnoughException(String message) {
		super(message);
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}

@SuppressWarnings("serial")
class InstallException extends Exception {
	InstallException(String message) {
		super(message);
	}
}

@SuppressWarnings("serial")
class MemoryNotEnoughException extends Exception {
	MemoryNotEnoughException(String message) {
		super(message);
	}
}