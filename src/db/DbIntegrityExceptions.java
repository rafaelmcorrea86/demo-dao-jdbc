package db;

public class DbIntegrityExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DbIntegrityExceptions (String msg) {
		super(msg);
	}

}
