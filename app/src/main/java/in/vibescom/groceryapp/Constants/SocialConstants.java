package in.vibescom.groceryapp.Constants;

/**
 * Created by mahesh on 19/4/17.
 */

public interface SocialConstants {

    public static final String PREFS_NAME = "social_manager_data";
    public static final String CALLBACKURL = "app://twitter-dev";

    public static final String PREF_KEY_OAUTH_TOKEN = "oauth_token";
    public static final String PREF_KEY_OAUTH_SECRET = "oauth_token_secret";
    public static final String PREF_KEY_TWITTER_LOGIN = "isTwitterLoggedIn";

    // Twitter oauth urls
    public static final String URL_TWITTER_AUTH = "auth_url";
    public static final String URL_TWITTER_OAUTH_VERIFIER = "oauth_verifier";
    public static final String URL_TWITTER_OAUTH_TOKEN = "oauth_token";

    //Facebook constants

    static final String kFacebookFields = "fields";
    static final String kFacebookAllFields = "id,name,link,email,picture,first_name,last_name,gender";
    static final String kFacebookCommanAllFields = "email,first_name,last_name,gender,id,link,name,friends";

    public static final String kFacebookEmail = "email";
    public static final String kID = "id";

    public static final String kFacebookFirstName = "first_name";
    public static final String kFacebookLastName = "last_name";
    public static final String kFacebookGender = "gender";

}
