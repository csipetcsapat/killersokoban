package sokoban;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * a logolást megvalósító osztály
 */

public class Logger {
	/**
	 * egy függvényhívást reprezentáló osztály
	 */
	private class FunctionCall {
		private String callDescription;
		private int depth;

		/**
		 * @param callDescription a hívást leíró string
		 * @param depth a stack mélysége a függvény hívásakor
		 */
		public FunctionCall(String callDescription, int depth) {
			this.callDescription = callDescription;
			this.depth = depth;
		}

		/**
		 * @return visszaadja a mélységet
		 */
		public int getDepth() {
			return depth;
		}

		/**
		 * megjeleníti a függvényhívást
		 * @param isReturning eldönti, hogy ez a függvény visszatérése, vagy hívása-e
		 */
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

	/**
	 * @param indentLevel az indentálás szintjét határozza meg
	 */
	private void indent(int indentLevel) {
		for (int i = 0; i < indentLevel; ++i)
			System.out.print('\t');
	}

	/**
	 * kiüríti az eddigi hívásokat
	 */
	public void reset() {
		callQueue.clear();
	}

	/**
	 * regisztálja a hívást
	 * @param obj az az objektum, ami épp a függvényt hívja
	 */
	public void call(Loggable obj) {
		StackTraceElement[] st = Thread.currentThread().getStackTrace();
		
		if (callQueue.isEmpty())
			zeroDepth = st.length;

		callQueue.add(
				new FunctionCall(obj.getClass().getSimpleName() + " " + obj.GetObjName() + ": " + st[2].getMethodName() + "()",
						st.length - zeroDepth));
	}

	/**
	 * megjeleníti a hívások sorrendjét
	 */
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
