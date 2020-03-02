package tools;

import java.io.Serializable;
public class Data_Object implements Serializable{
    private String type;
    private String sender;
    private Boolean continuous;
    private String continuous_filename;
    private String continuous_id;
    private String data;
    public Data_Object(String sender,
                       String type,
                       Boolean continuous,
                       String continuous_id,
                       String continuous_filename,
                       String data){

        this.sender = sender;
        this.type = type;
        this.continuous = continuous;
        this.continuous_id = continuous_id;
        this.continuous_filename  = continuous_filename;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Boolean getContinuous() {
        return continuous;
    }

    public void setContinuous(Boolean continuous) {
        this.continuous = continuous;
    }

    public String getContinuous_filename() {
        return continuous_filename;
    }

    public void setContinuous_filename(String continuous_filename) {
        this.continuous_filename = continuous_filename;
    }

    public String getContinuous_id() {
        return continuous_id;
    }

    public void setContinuous_id(String continuous_id) {
        this.continuous_id = continuous_id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}