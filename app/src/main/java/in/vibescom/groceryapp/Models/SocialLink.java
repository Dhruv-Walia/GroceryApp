package in.vibescom.groceryapp.Models;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by akamahesh on 15/5/17.
 */

public class SocialLink extends BaseModel implements Serializable {
    private String contactId;
    private String socialId;
    private Boolean isVerified;
    private Integer type;

    public SocialLink(JSONObject jsonResponse){
        this.contactId                  = getValue(jsonResponse, kContactId,            String.class);
        this.socialId                   = getValue(jsonResponse, kSocialId,             String.class);
        this.type                       = getValue(jsonResponse, kType,                 Integer.class);
        this.isVerified                 = getValue(jsonResponse, kIsVerified,           Boolean.class);
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getSocialId() {
        return socialId;
    }

    public void setSocialId(String socialId) {
        this.socialId = socialId;
    }

    public Boolean getVerified() {
        return isVerified;
    }

    public void setVerified(Boolean verified) {
        isVerified = verified;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }


}
