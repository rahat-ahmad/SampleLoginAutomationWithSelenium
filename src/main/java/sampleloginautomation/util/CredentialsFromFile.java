package sampleloginautomation.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CredentialsFromFile {

    public List<String> getCredentials() throws FileNotFoundException{

            File myObj = new File("./src/main/resources/credentials.txt");
            Scanner myReader = new Scanner(myObj);
            List<String> credentials = new ArrayList<String>();
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                credentials.addAll(Arrays.asList(data.split(",")));
            }
            myReader.close();
            return credentials;

    }

}
