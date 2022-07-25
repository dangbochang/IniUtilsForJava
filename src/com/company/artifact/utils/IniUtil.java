package com.company.artifact.utils;

import java.io.IOException;

public class IniUtil {

	/**
	 * 从ini配置文件中读取变量的值
	 * 
	 * @param file         配置文件的路径
	 * @param section      要获取的变量所在段名称
	 * @param key          要获取的变量名称
	 * @param defaultValue 变量名称不存在时的默认值
	 * @return 变量的值
	 * @throws IOException 抛出文件操作可能出现的io异常
	 */

	public static String read(String file, String section, String key, String defaultValue) throws IOException {
		try {
			IniEditor iniEditor = new IniEditor(new char[] { '#', ';' }, true);
			String fileEncode = EncodingDetect.getJavaEncode(file);
			iniEditor.load(file, fileEncode);
			if (!iniEditor.hasSection(section)) {
				return defaultValue;
			}
			String value = iniEditor.get(section, key);
			if (value == null || "".equals(value)) {
				return defaultValue;
			}

			return value;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return defaultValue;
	}

	/**
	 * 修改ini配置文件中变量的值
	 * 
	 * @param file    配置文件的路径
	 * @param section 要修改的变量所在段名称
	 * @param key     要修改的变量名称
	 * @param value   变量的新值
	 * @throws Exception
	 * @throws IOException 抛出文件操作可能出现的io异常
	 */
	public static boolean write(String file, String section, String key, String value) throws Exception {
		try {
			IniEditor iniEditor = new IniEditor(true);
			String fileEncode = EncodingDetect.getJavaEncode(file);
			iniEditor.load(file, fileEncode);
			if (!iniEditor.hasSection(section)) {
				iniEditor.addSection(section);
			}
			iniEditor.set(section, key, value);
			iniEditor.addBlankLine(section);
			iniEditor.save(file);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 修改ini配置文件中变量的值
	 * 
	 * @param file    配置文件的路径
	 * @param section 要修改的变量所在段名称
	 * @param key     要修改的变量名称
	 * @param value   变量的新值
	 * @param comment key的注释
	 * @throws Exception
	 * @throws IOException 抛出文件操作可能出现的io异常
	 */
	public static boolean write(String file, String section, String key, String value, String comment) throws Exception {
		try {
			IniEditor iniEditor = new IniEditor(true);
			String fileEncode = EncodingDetect.getJavaEncode(file);
			iniEditor.load(file, fileEncode);
			if (!iniEditor.hasSection(section)) {
				iniEditor.addSection(section);
			}

			if (!iniEditor.hasOption(section, key)) {
				iniEditor.addComment(section, comment);
			}
			iniEditor.set(section, key, value);

			iniEditor.addBlankLine(section);
			iniEditor.save(file);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}
