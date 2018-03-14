
public class Skeleton {

	public static void main(String[] args) {
		Logger log = new Logger();
		
		log.call("Test", "t1", "test()");
		log.call("Test", "t1", "test()");
		log.call("Test", "t1", "test()");
		log.call("Test", "t1", "test()");
		
		log.endCall();
		log.endCall();
		log.endCall();
		log.endCall();
	}

}
