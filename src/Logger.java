import java.util.Stack;

public class Logger {
	private int indentLevel = 0;
	private Stack<String> callStack = new Stack<>();
	
	private void indent(int indentLevel) {
		for (int i = 0; i < indentLevel; ++i)
			System.out.print('\t');
	}
	
	public void call(String function) {
		callStack.push(function);
		System.out.print("->");
		
		indent(indentLevel++);
		
		System.out.println(function);
	}
	
	public void endCall() {
		System.out.print("<-");
		
		indent(--indentLevel);
		
		System.out.println(callStack.pop());
	}
}
