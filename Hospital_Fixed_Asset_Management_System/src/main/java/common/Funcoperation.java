package common;




import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Funcoperation {

	public static void main(String[] args) throws Exception
	{
		String expr = "(1+2/5)*3";
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result = engine.eval(expr);
		System.out.println(result);
	}
	public double average(Double price,Integer expected_life){
		return price-((1 - 0.05)/expected_life/12*price);
	}
}
