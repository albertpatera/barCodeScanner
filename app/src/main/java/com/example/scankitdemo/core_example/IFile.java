package com.example.scankitdemo.core;


public interface IFile {

    public void loadData(android.content.Context context, String data, String filename);
    public void getCSV(android.content.Context context, String oldFile, String newFile);
    public void readCsv(String file, android.content.Context context);
}
