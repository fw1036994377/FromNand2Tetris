package com.wayne;

import sun.tools.jar.CommandLine;

import javax.smartcardio.CommandAPDU;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class Parser {

    private BufferedReader bufferedReader;

    private String line;

    private String command;

    private String arg1;

    private String arg2;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public Parser(BufferedReader bufferedReader){
        this.bufferedReader = bufferedReader;
    }

    public void close() throws IOException {
        bufferedReader.close();
    }


    public boolean hasMoreCommands() throws IOException {
        line = bufferedReader.readLine();
        if (line==null){
            return false;
        }else {
            return true;
        }
    }

    private boolean preHandleLine(){
        line = line.trim();
        if(line.startsWith("//")){
            return false;
        }
        if(line.equals("")){
            return false;
        }
        return true;
    }

    public void advance(CodeWriter writer) throws IOException {
        //todo 根据line解析出东西
        //预处理一下line
        if(preHandleLine()){
            String[] strings = line.split(" ");
            if(strings.length>=1) setCommand(strings[0]);
            if(strings.length>=2) setArg1(strings[1]);
            if(strings.length>=3) setArg2(strings[2]);
            //开始一顿ifelse了,先写，再看着优化吧
            if(getCommand().equalsIgnoreCase("push")){
                writer.writePushPop(getCommand(),getArg1(),Integer.valueOf(getArg2()));



            } else if (getCommand().equalsIgnoreCase("add")) {
                writer.writeArithmetic(getCommand());

            }


        }
    }
}