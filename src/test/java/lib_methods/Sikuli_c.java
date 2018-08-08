package lib_methods;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class Sikuli_c {

	public WebDriver driver;
	public Screen s;

	public Sikuli_c(WebDriver drv) {
		s = new Screen();
		this.driver = drv;
	}

	public void click_setM2Slogo() throws FindFailed {

		s.click("E:\\Siddhartha\\Projects\\Automation-neon\\com.Makemymeal\\sikuli\\logo.png");
	}
	
	public void find_image(String path) throws FindFailed{
		s.findText(path);
		 System.out.println("target image found");

	}

}
