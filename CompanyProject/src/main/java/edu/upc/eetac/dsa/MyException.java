package edu.upc.eetac.dsa;

public class MyException extends Exception {
    //crear una exception
    public MyException() { super(); }
    public MyException(String message) { super(message); }
    public MyException(String message, Throwable cause) { super(message, cause); }
    public MyException(Throwable cause) { super(cause); }
}
