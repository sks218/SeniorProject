package main;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import java.util.ArrayList;

/**
 * Handles the extraction of data from a JSON encoded string.
 *
 * @author willt
 * @version Oct 2, 2017
 */
public class JSONParser
{
    private String    data;
    private JSONArray elements;


    /**
     * Constructor
     *
     * @param dat
     *            the input string
     */
    public JSONParser(String dat)
    {
        data = dat;
    }


    /**
     * Get the length of the input string
     *
     * @return length
     */
    public int bytes()
    {
        return data.length();
    }


    /**
     * Create a list of data points. Each point will contain the value, time
     * stamp, and the type of units being measured.
     *
     * @param attr
     *            the unit we are trying to measure
     * @return an arraylist of points
     * @throws JSONException
     *             if there is an error reading the string
     */
    public ArrayList<String[]> parseList(String attr) throws JSONException
    {
        if (!Sources.list_attributes.contains(attr))
        {
            return null;
        }
        elements = new JSONObject(data).getJSONArray("Items");
        for (int i = 0; i < elements.length(); i++)
        {
            JSONObject meter = elements.getJSONObject(i);
            if (meter.getString("Name").equals(attr))
            {
                ArrayList<String[]> dataList =
                    new ArrayList<String[]>();
                JSONArray items = meter.getJSONArray("Items");
                for (int j = 0; j < items.length(); j++)
                {
                    JSONObject jsonPoint = items.getJSONObject(j);
                    String[] point = new String[2];
                    point[0] = jsonPoint.getString("Timestamp");
                    point[1] = jsonPoint.getDouble("Value") + "";
                    dataList.add(point);
                }
                return dataList;
            }
        }
        return null;
    }
}
