package net.andy.web.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JavaInvokeJS {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NoSuchMethodException 
	 * @throws ScriptException 
	 */
	public static void main(String[] args) throws ScriptException, NoSuchMethodException, IOException {
		directInvokeJsCode();
		javaBindJsVarInJava();
		javaInvokeJsFunctionInFile();

	}
	
	/**
	 * ��Java�е���js�ļ��е�function��������ò���������ȡ����ֵ
	 * js�ļ��е�merge��������������a��b��ӣ�������c��
	 * @throws ScriptException 
	 * @throws NoSuchMethodException 
	 * @throws IOException 
	 */
	public static void javaInvokeJsFunctionInFile() throws ScriptException, NoSuchMethodException, IOException{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
 
		String jsFileName = "js/expression.js";
		// ��ȡjs�ļ�
		FileReader reader = new FileReader(jsFileName);
		// ִ��ָ���ű�
		engine.eval(reader);
		if(engine instanceof Invocable) {
			Invocable invoke = (Invocable)engine;
			// ����merge��������������������
			// c = merge(2, 3);
			Double c = (Double)invoke.invokeFunction("merge", 2, 3);
			System.out.println("c = " + c);
		}
		reader.close();
	}
	
	/**
	 * ��Java�а�js����:�ڵ���engine.get(key);ʱ�����keyû�ж��壬�򷵻�null
	 */
	public static void javaBindJsVarInJava(){
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		engine.put("a", 4);
		engine.put("b", 3);
		Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);
		try {
                        // ֻ��ΪDouble��ʹ��Float��Integer���׳��쳣
			Double result = (Double) engine.eval("a+b");   
			System.out.println("result = " + result);
			engine.eval("c=a+b");
			Double c = (Double)engine.get("c");
			System.out.println("c = " + c);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * java��ֱ�ӵ���js����
	 */
	public static void directInvokeJsCode(){
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		try {
			engine.eval("var a=3; var b=4;print (a+b);");
			// ���ܵ���������ж����js����
			// engine.eval("alert(\"js alert\");");   // ���󣬻��׳�alert���ò����ڵ��쳣
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

}
