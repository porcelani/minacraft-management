package com.openhack.util;

public class Run {
    public static void main(String args[]) {

        ExecuteShellCommand com = new ExecuteShellCommand();
        System.out.println(com.executeCommand("kubectl get pods"));

    }}