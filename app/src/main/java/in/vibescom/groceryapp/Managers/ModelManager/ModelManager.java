package in.vibescom.groceryapp.Managers.ModelManager;

import android.util.Log;

import org.json.JSONObject;

import in.vibescom.groceryapp.Constants.Blocks.GenricResponse;
import in.vibescom.groceryapp.Constants.Constants;
import in.vibescom.groceryapp.Libraries.DispatchQueue.DispatchQueue;
import in.vibescom.groceryapp.Managers.BaseManagers.BaseManager;
import in.vibescom.groceryapp.Models.BaseModel;
import in.vibescom.groceryapp.Models.CurrentUser;


/**
 * Singleton class to manage all models in projects. this is basically provide data to view in the
 * form of models
 */
public class ModelManager extends BaseManager implements Constants {

    private final static String TAG = ModelManager.class.getSimpleName();
    //Static Properties
    private static ModelManager _ModelManager;

    //Instance Properties
    private static CurrentUser mCurrentUser = null;
    private static String mGenericAuthToken = "";
    private DispatchQueue dispatchQueue =
            new DispatchQueue("com.queue.serial.modelmanager", DispatchQueue.QoS.userInitiated);

    /**
     * private constructor make it to be Singleton class
     */
    private ModelManager() {}

    /**
     * method to create a threadsafe singleton class instance
     *
     * @return a thread safe singleton object of model manager
     */
    public static synchronized ModelManager modelManager() {
        if (_ModelManager == null) {
            _ModelManager = new ModelManager();
            mCurrentUser = getDataFromPreferences(kCurrentUser, CurrentUser.class);
            mGenericAuthToken = getDataFromPreferences(kGenericAuthToken, String.class);
            Log.e(TAG, mCurrentUser + " ");
            Log.e(TAG, "genericAuthToken: " + mGenericAuthToken);
        }
        return _ModelManager;
    }

    public DispatchQueue getDispatchQueue() {
        return dispatchQueue;
    }

    /**
     * to initialize the singleton object
     */
    public void initializeModelManager() {
        System.out.println("ModelManager object initialized.");
    }

    /**
     * getter and setter method for current user
     *
     * @return {@link CurrentUser} if user already logged in, null otherwise
     */
    public synchronized CurrentUser getCurrentUser() {
        return mCurrentUser;
    }

    public synchronized void setCurrentUser(CurrentUser o) {
        mCurrentUser = o;
        archiveCurrentUser();
    }

    /**
     * set response to @User
     *
     * @param genricResponse contains JSONObject with user information in it
     */
    private void setupCurrentUser(GenricResponse<JSONObject> genricResponse) {
        mCurrentUser = new CurrentUser(genricResponse.getObject());
        archiveCurrentUser();
    }

    /**
     * Stores {@link CurrentUser} to the share preferences and synchronize sharedpreferece
     */
    public synchronized void archiveCurrentUser() {
        saveDataIntoPreferences(mCurrentUser, BaseModel.kCurrentUser);
    }

    /**
     * getter method for genericAuthToken
     */
    public synchronized String getGenericAuthToken() {
        return mGenericAuthToken;
    }

    public synchronized void setGenericAuthToken() {
        mGenericAuthToken = "";
        archiveGenericAuthToken();
    }

    /**
     * set response to mGenericAuthToken
     */
    private void setupGenericAuthToken(String response) {
        mGenericAuthToken = response;
        archiveGenericAuthToken();
    }

    /**
     * Stores genericAuthToken to the share preferences and synchronize SharedPreferences
     */
    public synchronized void archiveGenericAuthToken() {
        saveDataIntoPreferences(mGenericAuthToken, BaseModel.kGenericAuthToken);
    }


    /**
     * method will be called when  user register through system eg. with email and password
     *
     * @param parameters include user info provided by user
     * @param status     Block passed as callback for success condition
     * @param failure    Block passed as callback for failure condition
     */

}