package coverfoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityMethods {

	public static String readDataFromExcel(String excelFilePath, String sheetName, int rowNumber, int cellNumber)
			throws EncryptedDocumentException, IOException {
		FileInputStream excelFile = new FileInputStream(excelFilePath);
		String value = WorkbookFactory.create(excelFile).getSheet(sheetName).getRow(rowNumber).getCell(cellNumber)
				.getStringCellValue();
		return value;
	}

	public static String readDataFromPropertyFile(String key) throws IOException {
		Properties properties = new Properties();
		FileInputStream propertyFilePath = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		properties.load(propertyFilePath);
		return properties.getProperty(key);
	}

	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
		File destination = new File(
				"D:\\Selenium2025Workspace\\8thJune2024\\Screenshot\\" + fileName + timeStamp + ".png");
		FileHandler.copy(source, destination);
		
	}

}
