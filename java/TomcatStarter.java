import jakarta.servlet.ServletException;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.IOException;

public class TomcatStarter {

    private static int port = 8080;
    private static String contextPath = "/demo";

    public static void start() throws LifecycleException, IOException, ServletException {

        Tomcat tomcat = new Tomcat();
        String baseDir = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        System.out.println(baseDir);

        tomcat.setBaseDir(baseDir);
        tomcat.setPort(port);
        tomcat.setHostname("127.0.0.1");

        tomcat.getConnector().setPort(port);
        tomcat.addWebapp(contextPath, baseDir);
        tomcat.enableNaming();
        //手动创建
        //tomcat.getConnector();

        tomcat.start();
        //tomcat.getServer().await();
    }

    public static void main(String[] args) throws IOException, LifecycleException, ServletException {
        start();
    }
}
