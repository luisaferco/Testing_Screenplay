package co.com.webapps.screenplay.utils.restservice;

import co.com.webapps.screenplay.exceptions.NotFoundFileException;
import co.com.webapps.screenplay.models.restservice.users.DataUser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

public class UsersServiceFile {

    private List<DataUser> dataUserList;
    private String path;

    public UsersServiceFile(String path) {
        this.path = path;
    }

    public UsersServiceFile theData(List<DataUser> dataUserList){
        this.dataUserList = dataUserList;
        writeFile();
        return this;
    }

    public void writeFile() {
        try {
            FileWriter fileWriter = new FileWriter(path);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (DataUser dataUser : dataUserList) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(dataUser.getId()+";");
                stringBuilder.append(dataUser.getUsername()+";");
                stringBuilder.append(dataUser.getEmail()+";");
                stringBuilder.append(dataUser.getAddress().getCity());
                printWriter.printf(stringBuilder.toString());
                printWriter.println();
            }
            printWriter.close();
        } catch (IOException e) {
            throw new NotFoundFileException("No s encontro el archivo "+path, e);
        }
    }

    private String headers(){
        Method[] methods = DataUser.class.getDeclaredMethods();
        String headers = "";
        StringBuilder stringBuilder = null;
        for(Method method: methods){
            Parameter[] parameters = method.getParameters();
            for (Parameter p:parameters){
                if(p.isNamePresent()){
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(p.getName()+";");
                }
                headers = stringBuilder.toString();
            }
        }
     return headers;


    }


}
