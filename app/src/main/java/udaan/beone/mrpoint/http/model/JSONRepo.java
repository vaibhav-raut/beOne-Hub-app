package udaan.beone.mrpoint.http.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Vaibhav on 3/14/2016.
 */
public abstract class JSONRepo<O> {

    protected abstract Class<O> objectClass();

    public String buildJSONString(O o) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public O buildObject(String jsonString) {
        ObjectMapper mapper = new ObjectMapper();
        O object = null;
        try {
            object = mapper.readValue(jsonString, objectClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }
}
