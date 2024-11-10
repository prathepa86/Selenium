package SeleniumPractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class P18_PropertyReader {

	public static void main(String[] args) throws IOException {
		
		File filePath=new File(System.getProperty("user.dir")+"/testdata/environment.properties");
		FileInputStream oFis=new FileInputStream(filePath);
		Properties properties=new Properties();
		properties.load(oFis);
		String sURL = properties.getProperty("Url");
		String sEmail = properties.getProperty("email");
		String sPassword = properties.getProperty("password");
		String sOrderid = properties.getProperty("orderid");
		String sCustomerid = properties.getProperty("customerid");
		System.out.println(sURL+"\t"+sEmail+"\t"+sPassword+"\t"+sOrderid+"\t"+sCustomerid);
		
		//1.To fetch only property names .two ways
		//1.Using StringPropertyName->Return type is Set<String>
		Set<String> PropertyNames = properties.stringPropertyNames();
		System.out.println(PropertyNames);
		//2. Using
		Set<Object> Property_Names = properties.keySet();
		System.out.println(Property_Names);
		
		//To fetch only the values
		//1.using values method Return type->Collection<Object>
		Collection<Object> Propertyvalues = properties.values();
        System.out.println(Propertyvalues);
	}

}
