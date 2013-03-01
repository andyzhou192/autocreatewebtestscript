package net.andy.web.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import net.andy.web.util.BaseInfoData;
import net.andy.web.util.SelectorInfoData;

public class GenerateScriptOfJava {
	private static File baseModel = new File("src/net/andy/web/model/BaseModel.txt");
	private static File caseModel = new File("src/net/andy/web/model/CaseModel.txt");
	private static BaseInfoData bid = new BaseInfoData();
	private SelectorInfoData sid = new SelectorInfoData();

	private static String packageName = bid.getPackageNameInput();
	private static String className = bid.getClassNameInput();

	private static File file;

	public static void writeFile() {
		FileOutputStream out = null;
		try {
			file = new File(packageName.replace("\\", "/").replace(".", "/")
					+ "/" + className + ".java");
			if (!file.exists()) {
				file = OperateFile.createFile(packageName, className + ".java");

				out = new FileOutputStream(file, true);
				StringBuffer sb = new StringBuffer();
				String str = OperateFile
						.readTxtFile(baseModel)
						.replace("$_PACKAGE_", packageName.replace("/", "."))
						.replace("$_CLASS_NAME_", className)
						.replace("$_TESTCASE_DESCRIPTION_",bid.getScriptDescInput().replace("\n","\r\n  * "))
						.replace("$_AUTHOR_", bid.getScriptAuthInput())
						.replace("$_TESTCASE_NAME_", bid.getScriptNameInput());
				sb.append(str);
				out.write(sb.toString().getBytes("utf-8"));
				out.close();
			} else {
				String oldStr = OperateFile.readTxtFile(file);
				out = new FileOutputStream(file, true);
				StringBuffer sb = new StringBuffer();
				String newStr = OperateFile.readTxtFile(caseModel)
						.replace("$_TESTCASE_DESCRIPTION_",bid.getScriptDescInput().replace("\n","\r\n  * "))
						.replace("$_AUTHOR_", bid.getScriptAuthInput())
						.replace("$_TESTCASE_NAME_", bid.getScriptNameInput());
				
				oldStr.substring(0, oldStr.lastIndexOf("}"));
				sb.append(oldStr + newStr);
				out.write(sb.toString().getBytes("utf-8"));
				out.close();
			}
			/**
			 * sb.append( "package " + packageName.replace("/",
			 * ".").replace("\\", ".") ); sb.append( "\r\n\r\n" ); sb.append(
			 * "/**\r\n  * " + bid.getScriptDescInput().replace("\n",
			 * "\r\n  * ") ); sb.append( "\r\n\r\n" ); sb.append( "  * @author "
			 * + bid.getScriptAuthInput() + "\r\n** /" ); sb.append( "\r\n\r\n"
			 * ); sb.append( "public class " + className +
			 * " extends WebUIBaseCase {" ); sb.append( "\r\n" );
			 **/

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
