package co.com.webapps.screenplay.utils.driver;

import co.com.webapps.screenplay.exceptions.DriverFailException;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;

public class Driver {

    public static WindowsDriver<WindowsElement> myDriver;


    public static RemoteWebDriver calculator(){
        if(myDriver==null) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("deviceName", "WindowsPC");
                capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
                myDriver = new WindowsDriver<>(new URL("http://127.0.0.1:4723"), capabilities);
            } catch (IOException e) {
                throw new DriverFailException(DriverFailException.FAILED_CONNECTION_DRIVER, e);
            }
        }
        return myDriver;
    }


    public WindowsDriver<WindowsElement> getMyDriver() {
        return myDriver;
    }

    public static void closeDriver(){
        if(myDriver!=null){
            myDriver.close();
            myDriver=null;
        }
    }
}
