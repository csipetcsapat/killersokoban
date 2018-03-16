package sokoban;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Logger {
	private class FunctionCall {
		private String callDescription;
		private int depth;
		
		public FunctionCall(String callDescription, int depth) {
			this.callDescription = callDescription;
			this.depth = depth;
		}
		
		public int getDepth() {
			return depth;
		}
		
		public void print(boolean isReturning) {
			indent(depth);
			
			if(isReturning)
				System.out.print("<--");
			else
				System.out.print("-->");
			
			System.out.println(callDescription);
			
			if (isReturning)
				System.out.println();
		}
	}

	private Queue<FunctionCall> callQueue = new ArrayDeque<>();
	private int zeroDepth = 0;
	
	private void indent(int indentLevel) {
		for (int i = 0; i < indentLevel; ++i)
			System.out.print('\t');
	}
	
	public void reset() {
		callQueue.clear();
	}
	
	public void call() {
		StackTraceElement[] st = Thread.currentThread().getStackTrace();
		
		if (callQueue.isEmpty())
			zeroDepth = st.length;

		callQueue.add(
				new FunctionCall(st[2].getClassName() + ": " + st[2].getMethodName() + "()",
						st.length - zeroDepth));
	}
	
	public void printCallStack() {
		int lastDepth = -1;
		Stack<FunctionCall> callStack = new Stack<>();
		
		while (!callQueue.isEmpty()) {
			FunctionCall fc = callQueue.poll();
			int depth = fc.getDepth();
			
			if (depth <= lastDepth) {
				for (int i = 0; i < lastDepth - depth + 1; ++i)
					callStack.pop().print(true);
			}
			
			callStack.add(fc);
			
			fc.print(false);
			
			lastDepth = depth;
		}
		
		while (!callStack.isEmpty())
			callStack.pop().print(true);
	}
}
