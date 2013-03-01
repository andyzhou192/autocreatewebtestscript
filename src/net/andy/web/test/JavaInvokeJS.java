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
	 * 在Java中调用js文件中的function，传入调用参数，并获取返回值
	 * js文件中的merge函数将两个参数a，b相加，并返回c。
	 * @throws ScriptException 
	 * @throws NoSuchMethodException 
	 * @throws IOException 
	 */
	public static void javaInvokeJsFunctionInFile() throws ScriptException, NoSuchMethodException, IOException{
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
 
		String jsFileName = "js/expression.js";
		// 读取js文件
		FileReader reader = new FileReader(jsFileName);
		// 执行指定脚本
		engine.eval(reader);
		if(engine instanceof Invocable) {
			Invocable invoke = (Invocable)engine;
			// 调用merge方法，并传入两个参数
			// c = merge(2, 3);
			Double c = (Double)invoke.invokeFunction("merge", 2, 3);
			System.out.println("c = " + c);
		}
		reader.close();
	}
	
	/**
	 * 在Java中绑定js变量:在调用engine.get(key);时，如果key没有定义，则返回null
	 */
	public static void javaBindJsVarInJava(){
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		engine.put("a", 4);
		engine.put("b", 3);
		Bindings bindings = engine.getBindings(ScriptContext.ENGINE_SCOPE);
		try {
                        // 只能为Double，使用Float和Integer会抛出异常
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
	 * java中直接调用js代码
	 */
	public static void directInvokeJsCode(){
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("javascript");
		try {
			engine.eval("var a=3; var b=4;print (a+b);");
			// 不能调用浏览器中定义的js函数
			// engine.eval("alert(\"js alert\");");   // 错误，会抛出alert引用不存在的异常
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}

}
