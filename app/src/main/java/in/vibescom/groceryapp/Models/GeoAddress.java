package in.vibescom.groceryapp.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.concurrent.CopyOnWriteArrayList;

import in.vibescom.groceryapp.Constants.Constants;

public class GeoAddress implements Serializable,Constants {
    private CopyOnWriteArrayList<Component> componentList =new CopyOnWriteArrayList<>();
    private Location location;

    public GeoAddress(JSONObject jsonObject) throws JSONException {
        JSONArray addressComonents = jsonObject.getJSONArray("address_components");
        JSONObject geometry = jsonObject.getJSONObject("geometry");

        for(int i = 0;i<addressComonents.length();i++){
            componentList.add(new Component(addressComonents.getJSONObject(i)));
        }
        this.location = new Location(geometry.getJSONObject("location"));
    }

    public static class Component{
        String name;
        int types;
        Component(JSONObject jsonComponent) throws JSONException {
            name = jsonComponent.getString("long_name");
            types = getTypeTypicalInt((String) jsonComponent.getJSONArray("types").get(0));
        }

        private int getTypeTypicalInt(String types) {
            int type=0;
            switch (types) {
                case kPremise:
                    type = 1;
                    break;
                case kStreetNumber:
                    type = 2;
                    break;
                case kRoute:
                    type = 3;
                    break;
                case kLocality:
                    type = 4;
                    break;
                case kAdministrativeAreaLevel2:
                    type = 5;
                    break;
                case kAdministrativeAreaLevel1:
                    type = 6;
                    break;
                case kCountry:
                    type = 7;
                    break;
                case kPostalCode:
                    type = 8;
                    break;
            }
            return type;
        }

        public int getTypes() {
            return types;
        }

        public void setTypes(int types) {
            this.types = types;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }

    public static class Location{
        Double lat;
        Double lng;
        Location(JSONObject locationObj) throws JSONException {
            lat = locationObj.getDouble("lat");
            lng = locationObj.getDouble("lng");
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }
    }

    public CopyOnWriteArrayList<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(CopyOnWriteArrayList<Component> componentList) {
        this.componentList = componentList;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
