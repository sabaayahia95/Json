package com.smart.apps.json;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.smart.apps.json.models.GroupRegex;
import com.smart.apps.json.models.JsonData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ArrayList<HashMap<String, String>> contactList;
    List<JsonData> jsonData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonData = new ArrayList<>();

        m2("DataType");
        m2("AssignDataType");
        m2("Functions");
        m2("loop");
        m2("Condition");
        m2("Arrays");
        m2("Operators");
        m2("Key_Words");


        for (JsonData d : jsonData) {
            StringBuilder log = new StringBuilder();

            log.append(String.format(
                    "| Id -> %s | name -> %s| ",
                    d.getId(),
                    d.getGroupName()
            ));

            for (GroupRegex gr : d.getGroupRegex()) {

                log.append(String.format("GR Name : %s | Regex -> %s",
                        gr.getName(),
                        gr.getRegex()
                ));

            }

            Log.d(TAG, String.valueOf(log));

        }

    }
    private void m2(String itemName) {

        List<GroupRegex> groupRegex = new ArrayList<>();


        try {

            // جلب ملف الجيسون من ال assets
            String jsonFileString = Utils.getJsonFromAssets(getApplicationContext(), "data.json");

            // حفظ ملف الجيسون في متغير جيسون
            JSONObject obj = new JSONObject(jsonFileString);

            // اسم العنصر مثلا (DataType) و (Functions) ووو الخ ...
            JSONObject Item = obj.getJSONObject(itemName);

            // حفظ ال (group_regex) في مصفوفة لاستخراج القيم من داخلها
            JSONArray group_regex = Item.getJSONArray("group_regex");


            for (int i = 0; i < group_regex.length(); i++) {

                // حفظ ما بداخل (group_regex) في متغير ايضا لاستخراج القيم اللي فيه
                JSONObject rxDetail = group_regex.getJSONObject(i);

                // item_name -> inside group_regex
                JSONArray item_name = rxDetail.getJSONArray("item_name");

                // regex -> inside group_regex
                JSONArray item_regex = rxDetail.getJSONArray("regex");


                List<String> itemNames = new ArrayList<>();
                List<String> itemRegex = new ArrayList<>();

                for (int j = 0; j < item_name.length(); j++) {
                    itemNames.add(item_name.getString(j));
                }

                for (int j = 0; j < item_regex.length(); j++) {
                    itemRegex.add(item_regex.getString(j));
                }

                // هذا المتغير هو مودل اسمة(GroupRegex.java) معرف داخل المودل اللي اسمة JsonData.java
                // عمل المودلات الاثنين لتنظيم البيانات
                groupRegex.add(new GroupRegex(
                        rxDetail.getString("name"),
                        itemNames,
                        itemRegex
                ));
            }

            // حفظ الناتج النهائي في المودل
            jsonData.add(new JsonData(
                    Item.getString("id"),
                    Item.getString("group_name"),
                    groupRegex
            ));


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}