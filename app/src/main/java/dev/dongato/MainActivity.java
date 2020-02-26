package dev.dongato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Item 1");
        listDataHeader.add("Item 2");
        listDataHeader.add("Item 3");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("Item 1 - subItem 1");
        top250.add("Item 1 - subItem 2");
        top250.add("Item 1 - subItem 3");
        top250.add("Item 1 - subItem 4");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("Item 2 - subItem 1");
        nowShowing.add("Item 2 - subItem 2");
        nowShowing.add("Item 2 - subItem 3");
        nowShowing.add("Item 2 - subItem 4");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("Item 3 - subItem 1");
        comingSoon.add("Item 3 - subItem 2");
        comingSoon.add("Item 3 - subItem 3");
        comingSoon.add("Item 3 - subItem 4");

        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }
}
