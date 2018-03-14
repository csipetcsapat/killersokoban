
public class Skeleton {

	public static void main(String[] args) {
		Logger log = new Logger();
		
		log.call("test1()");
		log.call("test2()");
		log.call("test3()");
		log.call("test4()");
		
		log.endCall();
		log.endCall();
		log.endCall();
		log.endCall();
	}

}
