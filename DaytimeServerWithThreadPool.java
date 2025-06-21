import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DaytimeServerWithThreadPool {

    private static final int PORT = 5000;
    private static final int THREAD_POOL_SIZE = 10;


   