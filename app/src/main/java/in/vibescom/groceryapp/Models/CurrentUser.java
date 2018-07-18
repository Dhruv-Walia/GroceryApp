package in.vibescom.groceryapp.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import in.vibescom.groceryapp.Constants.Constants;

public class CurrentUser extends BaseModel implements Serializable,Constants {

    private String authToken;
    private Integer userId;
    private String jabberId;
    private String firstName;
    private String lastName;
    private SocialLink email;
    private SocialLink phone;
    private Integer gender;
    private Integer contactIdType;
    private String dateOfBirth;
    private String joinedDate;
    private String profilePicURL;
    private String referralCode;
    private UserRegType regType;
    private CopyOnWriteArrayList<SocialLink> userSocialLinks;
    private Address primaryAddress;
    private Boolean isAccountActivated;
    private Integer shoppingCartCount;

    public CurrentUser(JSONObject jsonResponse) {
        this.userId = getValue(jsonResponse, kUserId, Integer.class);
        this.jabberId = getValue(jsonResponse, kJabberId, String.class);
        this.authToken = getValue(jsonResponse, kAuthToken, String.class);
        this.firstName = getValue(jsonResponse, kFirstName, String.class);
        this.lastName = getValue(jsonResponse, kLastName, String.class);
        this.referralCode = getValue(jsonResponse, kReferralCode, String.class);
        this.gender = getValue(jsonResponse, kGender, Integer.class);
        this.email = new SocialLink(getValue(jsonResponse, kEmail, JSONObject.class));
        this.phone = new SocialLink(getValue(jsonResponse, kPhone, JSONObject.class));
        this.dateOfBirth = getValue(jsonResponse, kDateOfBirth, String.class);
        this.profilePicURL = getValue(jsonResponse, kProfilePicUrl, String.class);
        try {
            this.contactIdType = getValue(jsonResponse, kContactIdType, Integer.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.regType = UserRegType.getRegType(getValue(jsonResponse, kRegType, Integer.class));
        this.joinedDate = getValue(jsonResponse, kJoinedDate, String.class);
        try {
            this.userSocialLinks = handleSocialLinks(getValue(jsonResponse, kUserSocialLinks, JSONArray.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.isAccountActivated = getValue(jsonResponse, kIsAccountActivated, Boolean.class);
    }

    private CopyOnWriteArrayList<SocialLink> handleSocialLinks(JSONArray jsonArray) throws JSONException {
        CopyOnWriteArrayList<SocialLink> userSocialLinks = new CopyOnWriteArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            userSocialLinks.add(new SocialLink(jsonArray.getJSONObject(i)));
        }
        return userSocialLinks;
    }

    /**
     * @return fullname = Firstname+lastName
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getAuthToken() {
        return authToken;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getJabberId() {
        return jabberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setJabberId(String jabberId) {
        this.jabberId = jabberId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setContactIdType(Integer contactIdType) {
        this.contactIdType = contactIdType;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }

    public void setProfilePicURL(String profilePicURL) {
        this.profilePicURL = profilePicURL;
    }

    public void setReferralCode(String referralCode) {
        this.referralCode = referralCode;
    }

    public void setRegType(UserRegType regType) {
        this.regType = regType;
    }

    public void setPrimaryAddress(Address primaryAddress) {
        this.primaryAddress = primaryAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public SocialLink getEmail() {
        return email;
    }

    public SocialLink getPhone() {
        return phone;
    }

    public void setEmail(SocialLink email) {
        this.email = email;
    }

    public void setPhone(SocialLink phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getContactIdType() {
        return contactIdType;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getProfilePicURL() {
        return profilePicURL;
    }

    public UserRegType getRegType() {
        return regType;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public String getReferralCode() {
        return referralCode;
    }

    public Address getPrimaryAddress() {
        return primaryAddress;
    }

    public List<SocialLink> getUserSocialLinks() {
        return userSocialLinks;
    }

    public void setUserSocialLinks(CopyOnWriteArrayList<SocialLink> userSocialLinks) {
        this.userSocialLinks = userSocialLinks;
    }

    public Integer getShoppingCartCount() {
        return (shoppingCartCount == null) ? 0 : shoppingCartCount;
    }

    public void setShoppingCartCount(Integer shoppingCartCount) {
        this.shoppingCartCount = shoppingCartCount;
    }

    public Boolean getAccountActivated() {
        return isAccountActivated;
    }

    public void setAccountActivated(Boolean accountActivated) {
        isAccountActivated = accountActivated;
    }

}
