# IniUtilsForJava
--Enghish

Ini java util that supporting Chinese and section comments.
Based on the IniEditor.java of a great foreigner, I made some modifications:

1. Add automatic detection of file coding type, which coding type the source file is, and what type it will still be after saving. Support GB2312, UTF-8, other formats have not been tested, interested friends can test by themselves.

Ps:ini files are generally used by the windows platform, while the "NOTEPAD" program in the windows system is relatively flawed: if the text file is UTF-8 encoded, it will become "UTF-8 BOM" format after being opened and saved with Notepad. and The API related to reading and writing ini in Windows does not support "UTF-8 BOM" format files. This is too stupid. Therefore, for INI files, it is recommended that you use GB2312 encoding.

2. IniEditor.Java originally does not support writing comments after section. Even if you write comments, you will lose them as soon as you saved them. My modified version is already supported.

There are three files in the util kit: IniEditor.java, EncodingDetect.java (file format detection), IniUtil.java (encapsulation class)

Examples of usage:
boolean writeRet = IniUtil.Write (filepath, "section", "key", "value", "write comments here");

String value = IniUtil.read(filePath, "Section", "key", "default value");

--Chinese

支持中文、支持Section注释的Java工具类包。
本人在老外大神的IniEditor.java基础之上，做了一些修改：

1. 增加了文件编码类型自动检测，源文件是什么编码类型，保存后仍然是什么类型。支持GB2312, UTF-8，其它格式没测试过，有兴趣的朋友可以自行测试。
ps:INI文件一般是Windows平台在使用，而Windows系统中的“记事本”程序比较坑：如果文本文件是UTF-8编码，在用记事本打开并保存后，会变成“UTF-8 Bom”格式。而
Windows中读写INI的相关API又不支持“UTF-8 Bom”格式的文件。这个太坑了。所以INI文件，建议你就使用GB2312编码的。

2. IniEditor.java原本不支持Section后面写注释，你即使写了注释，用IniEditor一保存注释就给弄没了。我修改后的版本已经可以支持。
工具包中共3个文件，IniEditor.java，EncodingDetect.java（文件格式检测），IniUtil.java（封装类）

使用方法示例：

    boolean writeRet = IniUtil.write(filePath, "Section", "key", "value", "这里写注释");
	String value =  IniUtil.read(filePath, "Section", "key", "default value");
