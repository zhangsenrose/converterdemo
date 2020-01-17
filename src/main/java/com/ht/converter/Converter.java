package com.ht.converter;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Converter  implements IStringGetter{

    public Converter() {
    }

    public  void convert(String toFilePath) {
        String exe = "\"C:\\Program Files\\HoteamSoft\\SViewConverter(64bit)\\Converters\\SVL1.0\\CadConverter\\CadConverter.exe\" ";
        String fromPath = "\"C:\\Users\\admin-zsw\\Desktop\\转换问题图\\3333333\\CS-2000-06-00 R1搅拌机构.SLDASM\" ";
        //String toPath = "\"E:\\svl\"";
        String conf = "\"C:\\Users\\admin-zsw\\Documents\\HoteamSoft\\SViewConverter\\default.config\"";
        String cfg = "\"C:\\Users\\admin-zsw\\Desktop\\User3.config\"";
        String toPath = "E:\\svl";
        toPath = toPath + "\\" + toFilePath;
        File file = new File(toPath);
        if ( !file.exists()) {
            file.mkdirs();
        }
        toPath = "\"" + toPath + "\"";

        String cmd = exe +fromPath +toPath + " " + cfg;

        List<String> cmds = new ArrayList<String>();
        cmds.add(cmd);
        exec(cmds, null);

    }


    /*public  void convert2(String toFilePath) {
        String exe = "\"C:\\Program Files\\HoteamSoft\\SViewConverter(64bit)\\Converters\\SVL2.0\\CadConverter\\CadConverter.exe\" ";
        String fromPath = "\"C:\\Users\\admin-zsw\\Desktop\\精雕科技tiuve转换错误的图\\TIUVE转换测试，注油嘴装配可以正常转换，真空台面不能转换，\\真空台面组件P\" ";
        String conf = "\"C:\\Users\\admin-zsw\\Documents\\HoteamSoft\\SViewConverter\\default.config\"";
        String toPath = "\"C:\\Users\\admin-zsw\\Desktop\\华天转换图验证（不能验证的图）\\transform1\\真空台面组件P\"";

    }*/




    public void exec(List<String> cmd, IStringGetter getter ){
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(cmd);
            builder.redirectErrorStream(true);
            Process proc = builder.start();
            BufferedReader stdout = new BufferedReader(new InputStreamReader(
                    proc.getInputStream()));
            String line;
            while ((line = stdout.readLine()) != null) {
                if (getter != null)
                    getter.dealString(line);
            }
            proc.waitFor();
            stdout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dealString(String str) {

    }
}
