package cz.cvut.simonja3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class SearchActivity extends Activity {
	
	private ExpandableListAdapter listAdapter;
	private ExpandableListView listView;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        
        
        listView = (ExpandableListView) findViewById(R.id.searchCriterions);
        listAdapter = new MyExpandableListAdapter();                
        listView.setAdapter(listAdapter);
        expandAllGroups();
    }
	
	
	public void switchToSearchResults(View view) {
		Intent intent = new Intent(view.getContext(), SearchResultsActivity.class);
    	this.startActivity(intent);
	}
	
	private void expandAllGroups() {
		int count =  listAdapter.getGroupCount();
		for (int i = 0; i <count ; i++) {
		  listView.expandGroup(i);	
		}
	}


	public class MyExpandableListAdapter extends BaseExpandableListAdapter {
		
		 private String[] groups = { "Barva kvìtu", "Tvar listu"};
		 private String[][] children = {
				 {  "bílá", "èerná", "èervená", "fialová", "hnìdá", "modrá", "zelená", "žlutá"},
				 { "Ace", "Bandit", "Cha-Cha", "Deuce" },				 
		 };

		 public Object getChild(int groupPosition, int childPosition) {
	            return children[groupPosition][childPosition];
	        }

	        public long getChildId(int groupPosition, int childPosition) {
	            return childPosition;
	        }

	        public int getChildrenCount(int groupPosition) {
	            return children[groupPosition].length;
	        }

	        public TextView getGenericView() {
	            // Layout parameters for the ExpandableListView
	            AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
	                    ViewGroup.LayoutParams.FILL_PARENT, 64);

	            TextView textView = new TextView(SearchActivity.this);
	            textView.setLayoutParams(lp);
	            // Center the text vertically
	            textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
	            // Set the text starting position
	            textView.setPadding(36, 0, 0, 0);
	            return textView;
	        }

	        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
	                View convertView, ViewGroup parent) {
	            TextView textView = getGenericView();
	            textView.setText(getChild(groupPosition, childPosition).toString());
	            return textView;
	        }

	        public Object getGroup(int groupPosition) {
	            return groups[groupPosition];
	        }

	        public int getGroupCount() {
	            return groups.length;
	        }

	        public long getGroupId(int groupPosition) {
	            return groupPosition;
	        }

	        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
	                ViewGroup parent) {
	            TextView textView = getGenericView();
	            textView.setText(getGroup(groupPosition).toString());
	            return textView;
	        }

	        public boolean isChildSelectable(int groupPosition, int childPosition) {
	            return true;
	        }

	        public boolean hasStableIds() {
	        	return true;
	        }

		
	}
}
